package io.papermc.paper.api.command.cloud.commandframework.paper.parser;

import cloud.commandframework.ArgumentDescription;
import cloud.commandframework.arguments.CommandArgument;
import cloud.commandframework.arguments.parser.ArgumentParseResult;
import cloud.commandframework.arguments.parser.ArgumentParser;
import cloud.commandframework.brigadier.argument.WrappedBrigadierParser;
import cloud.commandframework.context.CommandContext;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.papermc.paper.api.command.cloud.commandframework.paper.PaperCommandManager;
import io.papermc.paper.api.command.cloud.commandframework.paper.data.ProtoItemStack;
import io.papermc.paper.api.command.cloud.commandframework.paper.internal.CommandBuildContextSupplier;
import io.papermc.paper.api.command.cloud.commandframework.paper.internal.CraftPaperReflection;
import io.papermc.paper.api.command.cloud.commandframework.paper.internal.MinecraftArgumentTypes;
import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.material.Material;
import io.papermc.paper.api.namespace.NamespacedKey;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

/**
 * Argument type for parsing a {@link Material} and optional extra NBT data into a {@link ProtoItemStack}.
 *
 * <p>This argument type only provides basic suggestions by default. On Minecraft 1.13 and newer, enabling Brigadier
 * compatibility through {@link PaperCommandManager#registerBrigadier()} will allow client side validation and
 * suggestions to be utilized.</p>
 *
 * @param <C> Command sender type
 * @since 1.5.0
 */
public final class ItemStackArgument<C> extends CommandArgument<C, ProtoItemStack> {

    private ItemStackArgument(
            final boolean required,
            final @NonNull String name,
            final @NonNull String defaultValue,
            final @Nullable BiFunction<@NonNull CommandContext<C>, @NonNull String,
                    @NonNull List<@NonNull String>> suggestionsProvider,
            final @NonNull ArgumentDescription defaultDescription
    ) {
        super(required, name, new Parser<>(), defaultValue, ProtoItemStack.class, suggestionsProvider, defaultDescription);
    }

    /**
     * Create a new {@link Builder}.
     *
     * @param name Name of the argument
     * @param <C>  Command sender type
     * @return Created builder
     * @since 1.5.0
     */
    public static <C> ItemStackArgument.@NonNull Builder<C> builder(final @NonNull String name) {
        return new ItemStackArgument.Builder<>(name);
    }

    /**
     * Create a new required {@link ItemStackArgument}.
     *
     * @param name Argument name
     * @param <C>  Command sender type
     * @return Created argument
     * @since 1.5.0
     */
    public static <C> @NonNull ItemStackArgument<C> of(final @NonNull String name) {
        return ItemStackArgument.<C>builder(name).build();
    }

    /**
     * Create a new optional {@link ItemStackArgument}.
     *
     * @param name Argument name
     * @param <C>  Command sender type
     * @return Created argument
     * @since 1.5.0
     */
    public static <C> @NonNull ItemStackArgument<C> optional(final @NonNull String name) {
        return ItemStackArgument.<C>builder(name).asOptional().build();
    }


    /**
     * Builder for {@link ItemStackArgument}.
     *
     * @param <C> sender type
     * @since 1.5.0
     */
    public static final class Builder<C> extends TypedBuilder<C, ProtoItemStack, Builder<C>> {

        private Builder(final @NonNull String name) {
            super(ProtoItemStack.class, name);
        }

        @Override
        public @NonNull ItemStackArgument<C> build() {
            return new ItemStackArgument<>(
                    this.isRequired(),
                    this.getName(),
                    this.getDefaultValue(),
                    this.getSuggestionsProvider(),
                    this.getDefaultDescription()
            );
        }
    }

    /**
     * Parser for {@link ProtoItemStack}. Requires a CraftBukkit based server implementation.
     *
     * @param <C> sender type
     * @since 1.5.0
     */
    public static final class Parser<C> implements ArgumentParser<C, ProtoItemStack> {

        private final ArgumentParser<C, ProtoItemStack> parser;

        /**
         * Create a new {@link Parser}.
         *
         * @since 1.5.0
         */
        public Parser() {
            if (findItemInputClass() != null) {
                this.parser = new ModernParser<>();
            } else {
                this.parser = new LegacyParser<>();
            }
        }

        @Override
        public @NonNull ArgumentParseResult<ProtoItemStack> parse(
                final @NonNull CommandContext<C> commandContext,
                final @NonNull Queue<@NonNull String> inputQueue
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
    }

    private static @Nullable Class<?> findItemInputClass() {
        //TODO: Remove reflection
        final Class<?>[] classes = new Class<?>[]{
                CraftPaperReflection.findNMSClass("ArgumentPredicateItemStack"),
                CraftPaperReflection.findMCClass("commands.arguments.item.ArgumentPredicateItemStack"),
                CraftPaperReflection.findMCClass("commands.arguments.item.ItemInput")
        };
        for (final Class<?> clazz : classes) {
            if (clazz != null) {
                return clazz;
            }
        }
        return null;
    }

    //TODO: Remove reflection
    private static final class ModernParser<C> implements ArgumentParser<C, ProtoItemStack> {

        private static final Class<?> NMS_ITEM_STACK_CLASS = CraftPaperReflection.needNMSClassOrElse(
                "ItemStack",
                "net.minecraft.world.item.ItemStack"
        );
        private static final Class<?> CRAFT_ITEM_STACK_CLASS =
                CraftPaperReflection.needIPCClass("inventory.CraftItemStack");
        private static final Class<?> ARGUMENT_ITEM_STACK_CLASS =
                MinecraftArgumentTypes.getClassByKey(NamespacedKey.minecraft("item_stack"));
        private static final Class<?> ITEM_INPUT_CLASS = requireNonNull(findItemInputClass(), "ItemInput class");
        private static final Class<?> NMS_ITEM_CLASS = CraftPaperReflection.needNMSClassOrElse(
                "Item",
                "net.minecraft.world.item.Item"
        );
        private static final Class<?> CRAFT_MAGIC_NUMBERS_CLASS =
                CraftPaperReflection.needIPCClass("util.CraftMagicNumbers");
        private static final Method GET_MATERIAL_METHOD = CraftPaperReflection
                .needMethod(CRAFT_MAGIC_NUMBERS_CLASS, "getMaterial", NMS_ITEM_CLASS);
        private static final Method CREATE_ITEM_STACK_METHOD = CraftPaperReflection.firstNonNullOrThrow(
                () -> "Couldn't find createItemStack method on ItemInput",
                CraftPaperReflection.findMethod(ITEM_INPUT_CLASS, "a", int.class, boolean.class),
                CraftPaperReflection.findMethod(ITEM_INPUT_CLASS, "createItemStack", int.class, boolean.class)
        );
        private static final Method AS_BUKKIT_COPY_METHOD = CraftPaperReflection
                .needMethod(CRAFT_ITEM_STACK_CLASS, "asBukkitCopy", NMS_ITEM_STACK_CLASS);
        private static final Field ITEM_FIELD = CraftPaperReflection.firstNonNullOrThrow(
                () -> "Couldn't find item field on ItemInput",
                CraftPaperReflection.findField(ITEM_INPUT_CLASS, "b"),
                CraftPaperReflection.findField(ITEM_INPUT_CLASS, "item")
        );
        private static final Field COMPOUND_TAG_FIELD = CraftPaperReflection.firstNonNullOrThrow(
                () -> "Couldn't find tag field on ItemInput",
                CraftPaperReflection.findField(ITEM_INPUT_CLASS, "c"),
                CraftPaperReflection.findField(ITEM_INPUT_CLASS, "tag")
        );
        private static final Class<?> HOLDER_CLASS = CraftPaperReflection.findMCClass("core.Holder");
        private static final @Nullable Method VALUE_METHOD = HOLDER_CLASS == null
                ? null
                : CraftPaperReflection.firstNonNullOrThrow(
                () -> "Couldn't find Holder#value",
                CraftPaperReflection.findMethod(HOLDER_CLASS, "value"),
                CraftPaperReflection.findMethod(HOLDER_CLASS, "a")
        );

        private final ArgumentParser<C, ProtoItemStack> parser;

        ModernParser() {
            try {
                this.parser = this.createParser();
            } catch (final ReflectiveOperationException ex) {
                throw new RuntimeException("Failed to initialize modern ItemStack parser.", ex);
            }
        }

        @SuppressWarnings("unchecked")
        private ArgumentParser<C, ProtoItemStack> createParser() throws ReflectiveOperationException {
            final Constructor<?> ctr = ARGUMENT_ITEM_STACK_CLASS.getDeclaredConstructors()[0];
            final ArgumentType<Object> inst;
            if (ctr.getParameterCount() == 0) {
                inst = (ArgumentType<Object>) ctr.newInstance();
            } else {
                // 1.19+
                inst = (ArgumentType<Object>) ctr.newInstance(CommandBuildContextSupplier.commandBuildContext());
            }
            return new WrappedBrigadierParser<C, Object>(inst)
                    .map((ctx, itemInput) -> ArgumentParseResult.success(new ModernProtoItemStack(itemInput)));
        }

        @Override
        public @NonNull ArgumentParseResult<@NonNull ProtoItemStack> parse(
                @NonNull final CommandContext<@NonNull C> commandContext,
                @NonNull final Queue<@NonNull String> inputQueue
        ) {
            // Minecraft has a parser for this - just use it
            return this.parser.parse(commandContext, inputQueue);
        }

        @Override
        public @NonNull List<@NonNull String> suggestions(
                final @NonNull CommandContext<C> commandContext,
                final @NonNull String input
        ) {
            return this.parser.suggestions(commandContext, input);
        }

        private static final class ModernProtoItemStack implements ProtoItemStack {

            private final Object itemInput;
            private final Material material;
            private final @Nullable String snbt;

            ModernProtoItemStack(final @NonNull Object itemInput) {
                this.itemInput = itemInput;
                try {
                    Object item = ITEM_FIELD.get(itemInput);
                    if (HOLDER_CLASS != null && HOLDER_CLASS.isInstance(item)) {
                        item = VALUE_METHOD.invoke(item);
                    }
                    this.material = (Material) GET_MATERIAL_METHOD.invoke(null, item);
                    final Object compoundTag = COMPOUND_TAG_FIELD.get(itemInput);
                    if (compoundTag != null) {
                        this.snbt = compoundTag.toString();
                    } else {
                        this.snbt = null;
                    }
                } catch (final ReflectiveOperationException ex) {
                    throw new RuntimeException(ex);
                }
            }

            @Override
            public @NonNull Material material() {
                return this.material;
            }

            @Override
            public boolean hasExtraData() {
                return this.snbt != null;
            }

            @Override
            public @NonNull ItemStack createItemStack(final int stackSize, final boolean respectMaximumStackSize) {
                try {
                    return (ItemStack) AS_BUKKIT_COPY_METHOD.invoke(
                            null,
                            CREATE_ITEM_STACK_METHOD.invoke(this.itemInput, stackSize, respectMaximumStackSize)
                    );
                } catch (final InvocationTargetException ex) {
                    final Throwable cause = ex.getCause();
                    if (cause instanceof CommandSyntaxException) {
                        throw new IllegalArgumentException(cause.getMessage(), cause);
                    }
                    throw new RuntimeException(ex);
                } catch (final ReflectiveOperationException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static final class LegacyParser<C> implements ArgumentParser<C, ProtoItemStack> {

        private final ArgumentParser<C, ProtoItemStack> parser = new MaterialArgument.MaterialParser<C>()
                .map((ctx, material) -> ArgumentParseResult.success(new LegacyProtoItemStack(material)));

        @Override
        public @NonNull ArgumentParseResult<@NonNull ProtoItemStack> parse(
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
            return Arrays.stream(Material.values())
                    .filter(Material::isItem)
                    .map(value -> value.name().toLowerCase(Locale.ROOT))
                    .collect(Collectors.toList());
        }

        private static final class LegacyProtoItemStack implements ProtoItemStack {

            private final Material material;

            private LegacyProtoItemStack(final @NonNull Material material) {
                this.material = material;
            }

            @Override
            public @NonNull Material material() {
                return this.material;
            }

            @Override
            public boolean hasExtraData() {
                return false;
            }

            @Override
            public @NonNull ItemStack createItemStack(final int stackSize, final boolean respectMaximumStackSize)
                    throws IllegalArgumentException {
                if (respectMaximumStackSize && stackSize > this.material.getMaxStackSize()) {
                    throw new IllegalArgumentException(String.format(
                            "The maximum stack size for %s is %d",
                            this.material,
                            this.material.getMaxStackSize()
                    ));
                }
                return new ItemStack(this.material, stackSize);
            }
        }
    }
}

