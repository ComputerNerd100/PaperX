package io.papermc.paper.api.command.cloud.commandframework.paper.parser;

import cloud.commandframework.ArgumentDescription;
import cloud.commandframework.arguments.CommandArgument;
import cloud.commandframework.arguments.parser.ArgumentParseResult;
import cloud.commandframework.arguments.parser.ArgumentParser;
import cloud.commandframework.brigadier.argument.WrappedBrigadierParser;
import cloud.commandframework.context.CommandContext;
import com.mojang.brigadier.arguments.ArgumentType;
import io.leangen.geantyref.TypeToken;
import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.command.CommandSender;
import io.papermc.paper.api.command.cloud.commandframework.paper.PaperCommandManager;
import io.papermc.paper.api.command.cloud.commandframework.paper.data.BlockPredicate;
import io.papermc.paper.api.command.cloud.commandframework.paper.internal.CommandBuildContextSupplier;
import io.papermc.paper.api.command.cloud.commandframework.paper.internal.CraftPaperReflection;
import io.papermc.paper.api.command.cloud.commandframework.paper.internal.MinecraftArgumentTypes;
import io.papermc.paper.api.command.cloud.commandframework.paper.internal.RegistryReflection;
import io.papermc.paper.api.namespace.NamespacedKey;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * Argument type for parsing a {@link BlockPredicate}.
 *
 * <p>This argument type is only usable on Minecraft 1.13+, as it depends on Minecraft internals added in that version.</p>
 *
 * <p>This argument type only provides basic suggestions by default. Enabling Brigadier compatibility through
 * {@link PaperCommandManager#registerBrigadier()} will allow client side validation and suggestions to be utilized.</p>
 *
 * @param <C> Command sender type
 * @since 1.5.0
 */
public final class BlockPredicateArgument<C> extends CommandArgument<C, BlockPredicate> {

    private BlockPredicateArgument(
            final boolean required,
            final @NonNull String name,
            final @NonNull String defaultValue,
            final @Nullable BiFunction<@NonNull CommandContext<C>, @NonNull String,
                    @NonNull List<@NonNull String>> suggestionsProvider,
            final @NonNull ArgumentDescription defaultDescription
    ) {
        super(required, name, new Parser<>(), defaultValue, BlockPredicate.class, suggestionsProvider, defaultDescription);
    }

    /**
     * Create a new {@link Builder}.
     *
     * @param name Name of the argument
     * @param <C>  Command sender type
     * @return Created builder
     * @since 1.5.0
     */
    public static <C> BlockPredicateArgument.@NonNull Builder<C> builder(final @NonNull String name) {
        return new BlockPredicateArgument.Builder<>(name);
    }

    /**
     * Create a new required {@link BlockPredicateArgument}.
     *
     * @param name Argument name
     * @param <C>  Command sender type
     * @return Created argument
     * @since 1.5.0
     */
    public static <C> @NonNull BlockPredicateArgument<C> of(final @NonNull String name) {
        return BlockPredicateArgument.<C>builder(name).build();
    }

    /**
     * Create a new optional {@link BlockPredicateArgument}.
     *
     * @param name Argument name
     * @param <C>  Command sender type
     * @return Created argument
     * @since 1.5.0
     */
    public static <C> @NonNull BlockPredicateArgument<C> optional(final @NonNull String name) {
        return BlockPredicateArgument.<C>builder(name).asOptional().build();
    }


    /**
     * Builder for {@link BlockPredicateArgument}.
     *
     * @param <C> sender type
     * @since 1.5.0
     */
    public static final class Builder<C> extends TypedBuilder<C, BlockPredicate, Builder<C>> {

        private Builder(final @NonNull String name) {
            super(BlockPredicate.class, name);
        }

        @Override
        public @NonNull BlockPredicateArgument<C> build() {
            return new BlockPredicateArgument<>(
                    this.isRequired(),
                    this.getName(),
                    this.getDefaultValue(),
                    this.getSuggestionsProvider(),
                    this.getDefaultDescription()
            );
        }
    }

    /**
     * Parser for {@link BlockPredicateArgument}. Only supported on Minecraft 1.13 and newer CraftBukkit based servers.
     *
     * @param <C> sender type
     * @since 1.5.0
     */
    public static final class Parser<C> implements ArgumentParser<C, BlockPredicate> {

        private static final Class<?> TAG_CONTAINER_CLASS;

        //TODO: TOO MUCH REFLECTION
        static {
            Class<?> tagContainerClass;
            if (CraftPaperReflection.MAJOR_REVISION > 12 && CraftPaperReflection.MAJOR_REVISION < 16) {
                tagContainerClass = CraftPaperReflection.needNMSClass("TagRegistry");
            } else {
                tagContainerClass = CraftPaperReflection.firstNonNullOrThrow(
                        () -> "tagContainerClass",
                        CraftPaperReflection.findNMSClass("ITagRegistry"),
                        CraftPaperReflection.findMCClass("tags.ITagRegistry"),
                        CraftPaperReflection.findMCClass("tags.TagContainer"),
                        CraftPaperReflection.findMCClass("core.IRegistry"),
                        CraftPaperReflection.findMCClass("core.Registry")
                );
            }
            TAG_CONTAINER_CLASS = tagContainerClass;
        }

        private static final Class<?> CRAFT_WORLD_CLASS = CraftPaperReflection.needIPCClass("CraftWorld");
        private static final Class<?> MINECRAFT_SERVER_CLASS = CraftPaperReflection.needNMSClassOrElse(
                "MinecraftServer",
                "net.minecraft.server.MinecraftServer"
        );
        private static final Class<?> COMMAND_LISTENER_WRAPPER_CLASS = CraftPaperReflection.firstNonNullOrThrow(
                () -> "Couldn't find CommandSourceStack class",
                CraftPaperReflection.findNMSClass("CommandListenerWrapper"),
                CraftPaperReflection.findMCClass("commands.CommandListenerWrapper"),
                CraftPaperReflection.findMCClass("commands.CommandSourceStack")
        );
        private static final Class<?> ARGUMENT_BLOCK_PREDICATE_CLASS =
                MinecraftArgumentTypes.getClassByKey(NamespacedKey.minecraft("block_predicate"));
        private static final Class<?> ARGUMENT_BLOCK_PREDICATE_RESULT_CLASS = CraftPaperReflection.firstNonNullOrThrow(
                () -> "Couldn't find BlockPredicateArgument$Result class",
                CraftPaperReflection.findNMSClass("ArgumentBlockPredicate$b"),
                CraftPaperReflection.findMCClass("commands.arguments.blocks.ArgumentBlockPredicate$b"),
                CraftPaperReflection.findMCClass("commands.arguments.blocks.BlockPredicateArgument$Result")
        );
        private static final Class<?> SHAPE_DETECTOR_BLOCK_CLASS = CraftPaperReflection.firstNonNullOrThrow(
                () -> "Couldn't find BlockInWorld class",
                CraftPaperReflection.findNMSClass("ShapeDetectorBlock"),
                CraftPaperReflection.findMCClass("world.level.block.state.pattern.ShapeDetectorBlock"),
                CraftPaperReflection.findMCClass("world.level.block.state.pattern.BlockInWorld")
        );
        private static final Class<?> LEVEL_READER_CLASS = CraftPaperReflection.firstNonNullOrThrow(
                () -> "Couldn't find LevelReader class",
                CraftPaperReflection.findNMSClass("IWorldReader"),
                CraftPaperReflection.findMCClass("world.level.IWorldReader"),
                CraftPaperReflection.findMCClass("world.level.LevelReader")
        );
        private static final Class<?> BLOCK_POSITION_CLASS = CraftPaperReflection.firstNonNullOrThrow(
                () -> "Couldn't find BlockPos class",
                CraftPaperReflection.findNMSClass("BlockPosition"),
                CraftPaperReflection.findMCClass("core.BlockPosition"),
                CraftPaperReflection.findMCClass("core.BlockPos")
        );
        private static final Constructor<?> BLOCK_POSITION_CTR =
                CraftPaperReflection.needConstructor(BLOCK_POSITION_CLASS, int.class, int.class, int.class);
        private static final Constructor<?> SHAPE_DETECTOR_BLOCK_CTR = CraftPaperReflection
                .needConstructor(SHAPE_DETECTOR_BLOCK_CLASS, LEVEL_READER_CLASS, BLOCK_POSITION_CLASS, boolean.class);
        private static final Method GET_HANDLE_METHOD = CraftPaperReflection.needMethod(CRAFT_WORLD_CLASS, "getHandle");
        private static final @Nullable Method CREATE_PREDICATE_METHOD = CraftPaperReflection.firstNonNullOrNull(
                CraftPaperReflection.findMethod(ARGUMENT_BLOCK_PREDICATE_RESULT_CLASS, "create", TAG_CONTAINER_CLASS),
                CraftPaperReflection.findMethod(ARGUMENT_BLOCK_PREDICATE_RESULT_CLASS, "a", TAG_CONTAINER_CLASS)
        );
        private static final Method GET_SERVER_METHOD = CraftPaperReflection.streamMethods(COMMAND_LISTENER_WRAPPER_CLASS)
                .filter(it -> it.getReturnType().equals(MINECRAFT_SERVER_CLASS) && it.getParameterCount() == 0)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Could not find CommandSourceStack#getServer."));
        private static final @Nullable Method GET_TAG_REGISTRY_METHOD = CraftPaperReflection.firstNonNullOrNull(
                CraftPaperReflection.findMethod(MINECRAFT_SERVER_CLASS, "getTagRegistry"),
                CraftPaperReflection.findMethod(MINECRAFT_SERVER_CLASS, "getTags"),
                CraftPaperReflection.streamMethods(MINECRAFT_SERVER_CLASS)
                        .filter(it -> it.getReturnType().equals(TAG_CONTAINER_CLASS) && it.getParameterCount() == 0)
                        .findFirst()
                        .orElse(null)
        );

        private final ArgumentParser<C, BlockPredicate> parser;

        /**
         * Create a new {@link Parser}.
         *
         * @since 1.5.0
         */
        public Parser() {
            try {
                this.parser = this.createParser();
            } catch (final ReflectiveOperationException ex) {
                throw new RuntimeException("Failed to initialize BlockPredicate parser.", ex);
            }
        }

        @SuppressWarnings("unchecked")
        private ArgumentParser<C, BlockPredicate> createParser() throws ReflectiveOperationException {
            final Constructor<?> ctr = ARGUMENT_BLOCK_PREDICATE_CLASS.getDeclaredConstructors()[0];
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
                    return ArgumentParseResult.success(new BlockPredicateImpl((Predicate<Object>) result));
                }
                final Object commandSourceStack = ctx.get(WrappedBrigadierParser.COMMAND_CONTEXT_BRIGADIER_NATIVE_SENDER);
                try {
                    final Object server = GET_SERVER_METHOD.invoke(commandSourceStack);
                    final Object obj;
                    if (GET_TAG_REGISTRY_METHOD != null) {
                        obj = GET_TAG_REGISTRY_METHOD.invoke(server);
                    } else {
                        obj = RegistryReflection.registryByName("block");
                    }
                    Objects.requireNonNull(CREATE_PREDICATE_METHOD, "create on BlockPredicateArgument$Result");
                    final Predicate<Object> predicate = (Predicate<Object>) CREATE_PREDICATE_METHOD.invoke(result, obj);
                    return ArgumentParseResult.success(new BlockPredicateImpl(predicate));
                } catch (final ReflectiveOperationException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }

        @Override
        public @NonNull ArgumentParseResult<@NonNull BlockPredicate> parse(
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

        private static final class BlockPredicateImpl implements BlockPredicate {

            private final Predicate<Object> predicate;

            BlockPredicateImpl(final @NonNull Predicate<Object> predicate) {
                this.predicate = predicate;
            }

            private boolean testImpl(final @NonNull Block block, final boolean loadChunks) {
                try {
                    final Object blockInWorld = SHAPE_DETECTOR_BLOCK_CTR.newInstance(
                            GET_HANDLE_METHOD.invoke(block.getWorld()),
                            BLOCK_POSITION_CTR.newInstance(block.getX(), block.getY(), block.getZ()),
                            loadChunks
                    );
                    return this.predicate.test(blockInWorld);
                } catch (final ReflectiveOperationException ex) {
                    throw new RuntimeException(ex);
                }
            }

            @Override
            public boolean test(final @NonNull Block block) {
                return this.testImpl(block, false);
            }

            @Override
            public @NonNull BlockPredicate loadChunks() {
                return new BlockPredicate() {
                    @Override
                    public @NonNull BlockPredicate loadChunks() {
                        return this;
                    }

                    @Override
                    public boolean test(final Block block) {
                        return BlockPredicateImpl.this.testImpl(block, true);
                    }
                };
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
        commandManager.parserRegistry()
                .registerParserSupplier(TypeToken.get(BlockPredicate.class), params -> new BlockPredicateArgument.Parser<>());
    }
}
