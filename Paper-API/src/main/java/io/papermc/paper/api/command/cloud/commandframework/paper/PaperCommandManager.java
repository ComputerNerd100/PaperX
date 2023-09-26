package io.papermc.paper.api.command.cloud.commandframework.paper;

import cloud.commandframework.CloudCapability;
import cloud.commandframework.CommandManager;
import cloud.commandframework.CommandTree;
import cloud.commandframework.arguments.parser.ParserParameters;
import cloud.commandframework.brigadier.BrigadierManagerHolder;
import cloud.commandframework.brigadier.CloudBrigadierManager;
import cloud.commandframework.execution.CommandExecutionCoordinator;
import cloud.commandframework.execution.FilteringCommandSuggestionProcessor;
import cloud.commandframework.meta.CommandMeta;
import cloud.commandframework.meta.SimpleCommandMeta;
import cloud.commandframework.tasks.TaskFactory;
import cloud.commandframework.tasks.TaskRecipe;
import io.leangen.geantyref.TypeToken;
import io.papermc.paper.api.Paper;
import io.papermc.paper.api.command.CommandSender;
import io.papermc.paper.api.command.cloud.commandframework.paper.annotation.specifier.AllowEmptySelection;
import io.papermc.paper.api.command.cloud.commandframework.paper.annotation.specifier.DefaultNamespace;
import io.papermc.paper.api.command.cloud.commandframework.paper.annotation.specifier.RequireExplicitNamespace;
import io.papermc.paper.api.command.cloud.commandframework.paper.argument.NamespacedKeyArgument;
import io.papermc.paper.api.command.cloud.commandframework.paper.arguments.selector.MultipleEntitySelector;
import io.papermc.paper.api.command.cloud.commandframework.paper.arguments.selector.MultiplePlayerSelector;
import io.papermc.paper.api.command.cloud.commandframework.paper.arguments.selector.SingleEntitySelector;
import io.papermc.paper.api.command.cloud.commandframework.paper.arguments.selector.SinglePlayerSelector;
import io.papermc.paper.api.command.cloud.commandframework.paper.data.ProtoItemStack;
import io.papermc.paper.api.command.cloud.commandframework.paper.internal.CraftPaperReflection;
import io.papermc.paper.api.command.cloud.commandframework.paper.parser.*;
import io.papermc.paper.api.command.cloud.commandframework.paper.parser.location.Location2D;
import io.papermc.paper.api.command.cloud.commandframework.paper.parser.location.Location2DArgument;
import io.papermc.paper.api.command.cloud.commandframework.paper.parser.location.LocationArgument;
import io.papermc.paper.api.command.cloud.commandframework.paper.parser.selector.MultipleEntitySelectorArgument;
import io.papermc.paper.api.command.cloud.commandframework.paper.parser.selector.MultiplePlayerSelectorArgument;
import io.papermc.paper.api.command.cloud.commandframework.paper.parser.selector.SingleEntitySelectorArgument;
import io.papermc.paper.api.command.cloud.commandframework.paper.parser.selector.SinglePlayerSelectorArgument;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.location.Location;
import io.papermc.paper.api.material.Material;
import io.papermc.paper.api.player.OfflinePlayer;
import io.papermc.paper.api.plugin.Plugin;
import io.papermc.paper.api.world.World;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class PaperCommandManager<C extends CommandSender> extends CommandManager<C> implements BrigadierManagerHolder<C> {
    private final Plugin owningPlugin;

    private final Function<CommandSender, C> commandSenderMapper;
    private final Function<C, CommandSender> backwardsCommandSenderMapper;

    private final TaskFactory taskFactory;

    private boolean splitAliases = false;
    private PaperBrigadierListener<C> paperBrigadierListener = null;

    public PaperCommandManager(final @NonNull Plugin owningPlugin,
                               final @NonNull Function<@NonNull CommandTree< @NonNull C>,
                                       @NonNull CommandExecutionCoordinator< @NonNull C>> commandExecutionCoordinator,
                               final @NonNull Function<@NonNull CommandSender, @NonNull C> commandSenderMapper,
                               final @NonNull Function<@NonNull C, @NonNull CommandSender> backwardsCommandSenderMapper
                               ) throws Exception {
        super(commandExecutionCoordinator, new PaperPluginRegistrationHandler<>());
        ((PaperPluginRegistrationHandler<C>) this.commandRegistrationHandler()).initialize(this);
        this.owningPlugin = owningPlugin;
        this.commandSenderMapper = commandSenderMapper;
        this.backwardsCommandSenderMapper = backwardsCommandSenderMapper;

        final PaperSynchronizer paperSyncronizer = new PaperSynchronizer(owningPlugin);
        this.taskFactory = new TaskFactory(paperSyncronizer);

        this.commandSuggestionProcessor(new FilteringCommandSuggestionProcessor<>(
                FilteringCommandSuggestionProcessor.Filter.<C>startsWith(true).andTrimBeforeLastSpace()
        ));

        CloudPaperCapabilities.CAPABLE.forEach(this::registerCapability);
        this.registerCapability(CloudCapability.StandardCapabilities.ROOT_COMMAND_DELETION);

        this.registerCommandPreProcessor(new PaperCommandPreprocessor<>(this));

        this.parserRegistry().registerParserSupplier(TypeToken.get(World.class), parserParameters ->
                new WorldArgument.WorldParser<>());
        this.parserRegistry().registerParserSupplier(TypeToken.get(Material.class), parserParameters ->
                new MaterialArgument.MaterialParser<>());
        this.parserRegistry().registerParserSupplier(TypeToken.get(Player.class), parserParameters ->
                new PlayerArgument.PlayerParser<>());
        this.parserRegistry().registerParserSupplier(TypeToken.get(OfflinePlayer.class), parserParameters ->
                new OfflinePlayerArgument.OfflinePlayerParser<>());
        this.parserRegistry().registerParserSupplier(TypeToken.get(Enchantment.class), parserParameters ->
                new EnchantmentArgument.EnchantmentParser<>());
        this.parserRegistry().registerParserSupplier(TypeToken.get(Location.class), parserParameters ->
                new LocationArgument.LocationParser<>());
        this.parserRegistry().registerParserSupplier(TypeToken.get(Location2D.class), parserParameters ->
                new Location2DArgument.Location2DParser<>());
        this.parserRegistry().registerParserSupplier(TypeToken.get(ProtoItemStack.class), parserParameters ->
                new ItemStackArgument.Parser<>());

        this.parserRegistry().registerParserSupplier(TypeToken.get(SingleEntitySelector.class), parserParameters ->
                new SingleEntitySelectorArgument.SingleEntitySelectorParser<>());
        this.parserRegistry().registerParserSupplier(TypeToken.get(SinglePlayerSelector.class), parserParameters ->
                new SinglePlayerSelectorArgument.SinglePlayerSelectorParser<>());
        this.parserRegistry().registerAnnotationMapper(
                AllowEmptySelection.class,
                (annotation, type) -> ParserParameters.single(PaperParserParameters.ALLOW_EMPTY_SELECTOR_RESULT, annotation.value()));
        this.parserRegistry().registerParserSupplier(
                TypeToken.get(MultipleEntitySelector.class),
                parserParameters -> new MultipleEntitySelectorArgument.MultipleEntitySelectorParser<>(
                        parserParameters.get(PaperParserParameters.ALLOW_EMPTY_SELECTOR_RESULT, true)
                )
        );
        this.parserRegistry().registerParserSupplier(
                TypeToken.get(MultiplePlayerSelector.class),
                parserParameters -> new MultiplePlayerSelectorArgument.MultiplePlayerSelectorParser<>(
                        parserParameters.get(PaperParserParameters.ALLOW_EMPTY_SELECTOR_RESULT, true)
                )
        );

        if (CraftPaperReflection.classExists("org.bukkit.NamespacedKey")) {
            this.registerParserSupplierFor(NamespacedKeyArgument.class);
            this.parserRegistry().registerAnnotationMapper(
                    RequireExplicitNamespace.class,
                    (annotation, type) -> ParserParameters.single(PaperParserParameters.REQUIRE_EXPLICIT_NAMESPACE, true)
            );
            this.parserRegistry().registerAnnotationMapper(
                    DefaultNamespace.class,
                    (annotation, type) -> ParserParameters.single(PaperParserParameters.DEFAULT_NAMESPACE, annotation.value())
            );
        }

        /* Register MC 1.13+ parsers */
        if (this.hasCapability(CloudPaperCapabilities.NATIVE_BRIGADIER)) {
            this.registerParserSupplierFor(ItemStackPredicateArgument.class);
            this.registerParserSupplierFor(BlockPredicateArgument.class);
        }

        this.owningPlugin.getServer().getPluginManager().registerEvents(
                new CloudPaperListener<>(this),
                this.owningPlugin
        );

        this.captionRegistry(new PaperCaptionRegistryFactory<C>().create());
    }

    /**
     * Create a command manager using Bukkit's {@link CommandSender} as the sender type.
     *
     * @param owningPlugin                plugin owning the command manager
     * @param commandExecutionCoordinator execution coordinator instance
     * @return a new command manager
     * @throws Exception If the construction of the manager fails
     * @see #PaperCommandManager(Plugin, Function, Function, Function) for a more thorough explanation
     * @since 1.5.0
     */
    public static @NonNull PaperCommandManager<@NonNull CommandSender> createNative(
            final @NonNull Plugin owningPlugin,
            final @NonNull Function<@NonNull CommandTree<@NonNull CommandSender>,
                    @NonNull CommandExecutionCoordinator<@NonNull CommandSender>> commandExecutionCoordinator
    ) throws Exception {
        return new PaperCommandManager<>(
                owningPlugin,
                commandExecutionCoordinator,
                UnaryOperator.identity(),
                UnaryOperator.identity()
        );
    }

    /**
     * Create a new task recipe. This can be used to create chains of synchronous/asynchronous method calls
     *
     * @return Task recipe
     */
    public @NonNull TaskRecipe taskRecipe() {
        return this.taskFactory.recipe();
    }

    /**
     * Get the plugin that owns the manager
     *
     * @return Owning plugin
     */
    public @NonNull Plugin getOwningPlugin() {
        return this.owningPlugin;
    }

    /**
     * Create default command meta data
     *
     * @return Meta data
     */
    @Override
    public @NonNull SimpleCommandMeta createDefaultCommandMeta() {
        return SimpleCommandMeta.builder().with(CommandMeta.DESCRIPTION, "").build();
    }

    /**
     * Get the command sender mapper
     *
     * @return Command sender mapper
     */
    public final @NonNull Function<@NonNull CommandSender, @NonNull C> getCommandSenderMapper() {
        return this.commandSenderMapper;
    }

    @Override
    public final boolean hasPermission(final @NonNull C sender, final @NonNull String permission) {
        if (permission.isEmpty()) {
            return true;
        }
        return this.backwardsCommandSenderMapper.apply(sender).hasPermission(permission);
    }

    protected final boolean getSplitAliases() {
        return this.splitAliases;
    }

    protected final void setSplitAliases(final boolean value) {
        this.requireState(RegistrationState.BEFORE_REGISTRATION);
        this.splitAliases = value;
    }

    /**
     * Check whether Brigadier can be used on the server instance
     *
     * @throws BrigadierFailureException An exception is thrown if Brigadier isn't available. The exception
     *                                   will contain the reason for this.
     */
    protected final void checkBrigadierCompatibility() throws BrigadierFailureException {
        if (!this.hasCapability(CloudPaperCapabilities.NATIVE_BRIGADIER)) {
            throw new BrigadierFailureException(
                    BrigadierFailureReason.VERSION_TOO_LOW,
                    new IllegalArgumentException(
                            "Brigadier does not appear to be present on the currently running server. This is usually due to "
                                    + "running too old a version of Minecraft (Brigadier is implemented in 1.13 and newer).")
            );
        }
    }

    /**
     * Check for the platform capabilities
     *
     * @return A set containing all capabilities of the instance
     */
    public final @NonNull Set<@NonNull CloudPaperCapabilities> queryCapabilities() {
        return CloudPaperCapabilities.CAPABLE;
    }

    /**
     * Attempt to register the Brigadier mapper, and return it.
     *
     * @throws BrigadierFailureException If Brigadier isn't
     *                                   supported by the platform
     */
    /**
     * Register Brigadier mappings using the native paper events
     *
     * @throws BrigadierFailureException Exception thrown if the mappings cannot be registered
     */
    public void registerBrigadier() throws BrigadierFailureException {
        this.requireState(RegistrationState.BEFORE_REGISTRATION);
        this.checkBrigadierCompatibility();
        if (!this.hasCapability(CloudPaperCapabilities.NATIVE_BRIGADIER)) {
            throw new BrigadierFailureException(BrigadierFailureReason.VERSION_TOO_LOW);
        } else {
            try {
                this.paperBrigadierListener = new PaperBrigadierListener<>(this);
                Paper.getPluginManager().registerEvents(
                        this.paperBrigadierListener,
                        this.getOwningPlugin()
                );
            } catch (final Throwable e) {
                throw new BrigadierFailureException(BrigadierFailureReason.PAPER_BRIGADIER_INITIALIZATION_FAILURE, e);
            }
        }
    }

    /**
     * {@inheritDoc}
     *
     * @since 1.2.0
     */
    @Override
    public @Nullable CloudBrigadierManager<C, ?> brigadierManager() {
        if (this.paperBrigadierListener != null) {
            return this.paperBrigadierListener.brigadierManager();
        }
        return super.brigadierManager();
    }

    /**
     * Strip the plugin namespace from a plugin namespaced command. This
     * will also strip the leading '/' if it's present
     *
     * @param command Command
     * @return Stripped command
     */
    public final @NonNull String stripNamespace(final @NonNull String command) {
        @NonNull String input;

        /* Remove leading '/' */
        if (command.charAt(0) == '/') {
            input = command.substring(1);
        } else {
            input = command;
        }

        /* Remove leading plugin namespace */
        final String namespace = String.format("%s:", this.getOwningPlugin().name().toLowerCase());
        if (input.startsWith(namespace)) {
            input = input.substring(namespace.length());
        }

        return input;
    }

    /**
     * Get the backwards command sender plugin
     *
     * @return The backwards command sender mapper
     */
    public final @NonNull Function<@NonNull C, @NonNull CommandSender> getBackwardsCommandSenderMapper() {
        return this.backwardsCommandSenderMapper;
    }

    /**
     * Attempts to call the method on the provided class matching the signature
     * <p>{@code private static void registerParserSupplier(BukkitCommandManager)}</p>
     * using reflection.
     *
     * @param argumentClass argument class
     */
    private void registerParserSupplierFor(final @NonNull Class<?> argumentClass) {
        try {
            final Method registerParserSuppliers = argumentClass
                    .getDeclaredMethod("registerParserSupplier", PaperCommandManager.class);
            registerParserSuppliers.setAccessible(true);
            registerParserSuppliers.invoke(null, this);
        } catch (final ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    final void lockIfBrigadierCapable() {
        if (this.hasCapability(CloudPaperCapabilities.NATIVE_BRIGADIER)) {
            this.lockRegistration();
        }
    }

    /**
     * Register asynchronous completions. This requires all argument parsers to be thread safe, and it
     * is up to the caller to guarantee that such is the case
     *
     * @throws IllegalStateException when the server does not support asynchronous completions.
     * @see #hasCapability(CloudCapability) Check if the capability is present
     */
    public void registerAsynchronousCompletions() throws IllegalStateException {
        this.requireState(RegistrationState.BEFORE_REGISTRATION);
        if (!this.hasCapability(CloudPaperCapabilities.ASYNCHRONOUS_COMPLETION)) {
            throw new IllegalStateException("Failed to register asynchronous command completion listener.");
        }
        Paper.getServer().getPluginManager().registerEvents(
                new AsyncCommandSuggestionsListener<>(this),
                this.getOwningPlugin()
        );
    }

    /**
     * Reasons to explain why Brigadier failed to initialize
     */
    public enum BrigadierFailureReason {
        COMMODORE_NOT_PRESENT,
        VERSION_TOO_LOW,
        VERSION_TOO_HIGH,
        PAPER_BRIGADIER_INITIALIZATION_FAILURE
    }


    public static final class BrigadierFailureException extends IllegalStateException {

        private static final long serialVersionUID = 7816660840063155703L;
        private final BrigadierFailureReason reason;

        /**
         * Initialize a new Brigadier failure exception
         *
         * @param reason Reason
         */
        public BrigadierFailureException(final @NonNull BrigadierFailureReason reason) {
            this.reason = reason;
        }

        /**
         * Initialize a new Brigadier failure exception
         *
         * @param reason Reason
         * @param cause  Cause
         */
        public BrigadierFailureException(final @NonNull BrigadierFailureReason reason, final @NonNull Throwable cause) {
            super(cause);
            this.reason = reason;
        }

        /**
         * Get the reason for the exception
         *
         * @return Reason
         */
        public @NonNull BrigadierFailureReason getReason() {
            return this.reason;
        }

        @Override
        public String getMessage() {
            return String.format(
                    "Could not initialize Brigadier mappings. Reason: %s (%s)",
                    this.reason.name().toLowerCase().replace("_", " "),
                    this.getCause() == null ? "" : this.getCause().getMessage()
            );
        }
    }
}
