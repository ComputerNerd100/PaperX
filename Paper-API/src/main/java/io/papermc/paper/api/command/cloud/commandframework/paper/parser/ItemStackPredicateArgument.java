package io.papermc.paper.api.command.cloud.commandframework.paper.parser;

import cloud.commandframework.ArgumentDescription;
import cloud.commandframework.arguments.CommandArgument;
import cloud.commandframework.arguments.parser.ArgumentParseResult;
import cloud.commandframework.arguments.parser.ArgumentParser;
import cloud.commandframework.brigadier.argument.WrappedBrigadierParser;
import cloud.commandframework.context.CommandContext;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.StringRange;
import io.leangen.geantyref.TypeToken;
import io.papermc.paper.api.command.CommandSender;
import io.papermc.paper.api.command.cloud.commandframework.paper.PaperCommandManager;
import io.papermc.paper.api.command.cloud.commandframework.paper.data.ItemStackPredicate;
import io.papermc.paper.api.command.cloud.commandframework.paper.internal.CommandBuildContextSupplier;
import io.papermc.paper.api.command.cloud.commandframework.paper.internal.CraftPaperReflection;
import io.papermc.paper.api.command.cloud.commandframework.paper.internal.MinecraftArgumentTypes;
import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.namespace.NamespacedKey;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * Argument type for parsing an {@link ItemStackPredicate}.
 *
 * <p>This argument type is only usable on Minecraft 1.13+, as it depends on Minecraft internals added in that version.</p>
 *
 * <p>This argument type only provides basic suggestions by default. Enabling Brigadier compatibility through
 * {@link PaperCommandManager#registerBrigadier()} will allow client side validation and suggestions to be utilized.</p>
 *
 * @param <C> Command sender type
 * @since 1.5.0
 */
public final class ItemStackPredicateArgument<C> extends CommandArgument<C, ItemStackPredicate> {

    private ItemStackPredicateArgument(
            final boolean required,
            final @NonNull String name,
            final @NonNull String defaultValue,
            final @Nullable BiFunction<@NonNull CommandContext<C>, @NonNull String,
                    @NonNull List<@NonNull String>> suggestionsProvider,
            final @NonNull ArgumentDescription defaultDescription
    ) {
        super(required, name, new Parser<>(), defaultValue, ItemStackPredicate.class, suggestionsProvider, defaultDescription);
    }

    /**
     * Create a new {@link Builder}.
     *
     * @param name Name of the argument
     * @param <C>  Command sender type
     * @return Created builder
     * @since 1.5.0
     */
    public static <C> ItemStackPredicateArgument.@NonNull Builder<C> builder(final @NonNull String name) {
        return new ItemStackPredicateArgument.Builder<>(name);
    }

    /**
     * Create a new required {@link ItemStackPredicateArgument}.
     *
     * @param name Argument name
     * @param <C>  Command sender type
     * @return Created argument
     * @since 1.5.0
     */
    public static <C> @NonNull ItemStackPredicateArgument<C> of(final @NonNull String name) {
        return ItemStackPredicateArgument.<C>builder(name).build();
    }

    /**
     * Create a new optional {@link ItemStackPredicateArgument}.
     *
     * @param name Argument name
     * @param <C>  Command sender type
     * @return Created argument
     * @since 1.5.0
     */
    public static <C> @NonNull ItemStackPredicateArgument<C> optional(final @NonNull String name) {
        return ItemStackPredicateArgument.<C>builder(name).asOptional().build();
    }


    /**
     * Builder for {@link ItemStackPredicateArgument}.
     *
     * @param <C> sender type
     * @since 1.5.0
     */
    public static final class Builder<C> extends TypedBuilder<C, ItemStackPredicate, Builder<C>> {

        private Builder(final @NonNull String name) {
            super(ItemStackPredicate.class, name);
        }

        @Override
        public @NonNull ItemStackPredicateArgument<C> build() {
            return new ItemStackPredicateArgument<>(
                    this.isRequired(),
                    this.getName(),
                    this.getDefaultValue(),
                    this.getSuggestionsProvider(),
                    this.getDefaultDescription()
            );
        }
    }

    /**
     * Parser for {@link ItemStackPredicateArgument}. Only supported on Minecraft 1.13 and newer CraftBukkit based servers.
     *
     * @param <C> sender type
     * @since 1.5.0
     */
    public static final class Parser<C> implements ArgumentParser<C, ItemStackPredicate> {

        private static final Class<?> CRAFT_ITEM_STACK_CLASS =
                CraftPaperReflection.needIPCClass("inventory.CraftItemStack");
        private static final Class<?> ARGUMENT_ITEM_PREDICATE_CLASS =
                MinecraftArgumentTypes.getClassByKey(NamespacedKey.minecraft("item_predicate"));
        private static final Class<?> ARGUMENT_ITEM_PREDICATE_RESULT_CLASS = CraftPaperReflection.firstNonNullOrNull(
                CraftPaperReflection.findNMSClass("ArgumentItemPredicate$b"),
                CraftPaperReflection.findMCClass("commands.arguments.item.ArgumentItemPredicate$b"),
                CraftPaperReflection.findMCClass("commands.arguments.item.ItemPredicateArgument$Result")
        );
        private static final @Nullable Method CREATE_PREDICATE_METHOD = ARGUMENT_ITEM_PREDICATE_RESULT_CLASS == null
                ? null
                : CraftPaperReflection.firstNonNullOrNull(
                CraftPaperReflection.findMethod(
                        ARGUMENT_ITEM_PREDICATE_RESULT_CLASS,
                        "create",
                        com.mojang.brigadier.context.CommandContext.class
                ),
                CraftPaperReflection.findMethod(
                        ARGUMENT_ITEM_PREDICATE_RESULT_CLASS,
                        "a",
                        CommandContext.class
                )
        );
        private static final Method AS_NMS_COPY_METHOD =
                CraftPaperReflection.needMethod(CRAFT_ITEM_STACK_CLASS, "asNMSCopy", ItemStack.class);

        private final ArgumentParser<C, ItemStackPredicate> parser;

        /**
         * Create a new {@link Parser}.
         *
         * @since 1.5.0
         */
        public Parser() {
            try {
                this.parser = this.createParser();
            } catch (final ReflectiveOperationException ex) {
                throw new RuntimeException("Failed to initialize ItemPredicate parser.", ex);
            }
        }

        @SuppressWarnings("unchecked")
        private ArgumentParser<C, ItemStackPredicate> createParser() throws ReflectiveOperationException {
            final Constructor<?> ctr = ARGUMENT_ITEM_PREDICATE_CLASS.getDeclaredConstructors()[0];
            final ArgumentType<Object> inst;
            if (ctr.getParameterCount() == 0) {
                inst = (ArgumentType<Object>) ctr.newInstance();
            } else {
                // 1.19+
                inst = (ArgumentType<Object>) ctr.newInstance(CommandBuildContextSupplier.commandBuildContext());
            }
            return new WrappedBrigadierParser<C, Object>(inst).map((ctx, result) -> {
                if (result instanceof Predicate) {
                    // 1.19+
                    return ArgumentParseResult.success(new ItemStackPredicateImpl((Predicate<Object>) result));
                }
                final Object commandSourceStack = ctx.get(WrappedBrigadierParser.COMMAND_CONTEXT_BRIGADIER_NATIVE_SENDER);
                final CommandContext<Object> dummy = createDummyContext(ctx, commandSourceStack);
                Objects.requireNonNull(CREATE_PREDICATE_METHOD, "ItemPredicateArgument$Result#create");
                try {
                    final Predicate<Object> predicate = (Predicate<Object>) CREATE_PREDICATE_METHOD.invoke(result, dummy);
                    return ArgumentParseResult.success(new ItemStackPredicateImpl(predicate));
                } catch (final ReflectiveOperationException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }

        private static <C> @NonNull CommandContext<Object> createDummyContext(
                final @NonNull CommandContext<C> ctx,
                final @NonNull Object commandSourceStack
        ) {
            return new CommandContext<>(
                    commandSourceStack,
                    ctx.getRawInputJoined(),
                    Collections.emptyMap(),
                    null,
                    null,
                    Collections.emptyList(),
                    StringRange.at(0),
                    null,
                    null,
                    false
            );
        }

        @Override
        public @NonNull ArgumentParseResult<@NonNull ItemStackPredicate> parse(
                @NonNull final CommandContext<@NonNull C> commandContext,
                @NonNull final Queue<@NonNull String> inputQueue
        ) {
            return this.parser.parse(commandContext, inputQueue);
        }

        @Override
        public @NonNull List<@NonNull String> suggestions(
                final @NonNull CommandContext<C> commandContext,
                final @NonNull String input
        ) {
            return this.parser.suggestions(commandContext, input);
        }

        private static final class ItemStackPredicateImpl implements ItemStackPredicate {

            private final Predicate<Object> predicate;

            ItemStackPredicateImpl(final @NonNull Predicate<Object> predicate) {
                this.predicate = predicate;
            }

            @Override
            public boolean test(final @NonNull ItemStack itemStack) {
                try {
                    return this.predicate.test(AS_NMS_COPY_METHOD.invoke(null, itemStack));
                } catch (final ReflectiveOperationException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    /**
     * Called reflectively by {@link PaperCommandManager}.
     *
     * @param commandManager command manager
     * @param <C>            sender type
     */
    @SuppressWarnings("unused")
    private static <C extends CommandSender> void registerParserSupplier(final @NonNull PaperCommandManager<C> commandManager) {
        commandManager.parserRegistry().registerParserSupplier(
                TypeToken.get(ItemStackPredicate.class),
                params -> new ItemStackPredicateArgument.Parser<>()
        );
    }
}
