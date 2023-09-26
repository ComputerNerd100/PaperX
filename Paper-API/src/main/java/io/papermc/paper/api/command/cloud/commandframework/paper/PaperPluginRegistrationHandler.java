package io.papermc.paper.api.command.cloud.commandframework.paper;

import cloud.commandframework.Command;
import cloud.commandframework.CommandManager;
import cloud.commandframework.arguments.CommandArgument;
import cloud.commandframework.arguments.StaticArgument;
import cloud.commandframework.internal.CommandRegistrationHandler;
import io.papermc.paper.api.Paper;
import io.papermc.paper.api.command.CommandSender;
import io.papermc.paper.api.entity.Player;
import org.apiguardian.api.API;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class PaperPluginRegistrationHandler<C extends CommandSender> implements CommandRegistrationHandler {

    private final Map<CommandArgument<?, ?>, PaperCommand<C>> registeredCommands = new HashMap<>();
    private final Set<String> recognizedAliases = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

    private Map<String, PaperCommand<C>> paperCommands;
    private PaperCommandManager<C> paperCommandManager;
    private CommandMap commandMap;

    protected PaperPluginRegistrationHandler() {
    }

    final void initialize(final @NonNull PaperCommandManager<C> bukkitCommandManager) throws Exception {
        final Method getCommandMap = Paper.getServer().getClass().getDeclaredMethod("getCommandMap");
        getCommandMap.setAccessible(true);
        this.commandMap = (CommandMap) getCommandMap.invoke(Paper.getServer());
        final Field knownCommands = SimpleCommandMap.class.getDeclaredField("knownCommands");
        knownCommands.setAccessible(true);
        @SuppressWarnings("unchecked") final Map<String, PaperCommand<C>> bukkitCommands =
                (Map<String, PaperCommand<C>>) knownCommands.get(this.commandMap);
        this.bukkitCommands = bukkitCommands;
        this.bukkitCommandManager = bukkitCommandManager;
        Paper.getHelpMap().registerHelpTopicFactory(PaperCommand.class, GenericCommandHelpTopic::new);
    }

    @Override
    public final boolean registerCommand(final @NonNull Command<?> command) {
        /* We only care about the root command argument */
        final CommandArgument<?, ?> commandArgument = command.getArguments().get(0);
        if (!(this.paperCommandManager.commandRegistrationHandler() instanceof CloudCommodoreManager)
                && this.registeredCommands.containsKey(commandArgument)) {
            return false;
        }
        final String label = commandArgument.getName();
        final String namespacedLabel = this.getNamespacedLabel(label);

        @SuppressWarnings("unchecked") final List<String> aliases = new ArrayList<>(
                ((StaticArgument<C>) commandArgument).getAlternativeAliases()
        );

        @SuppressWarnings("unchecked") final PaperCommand<C> paperCommand = new PaperCommand<C>(
                label,
                aliases,
                (Command<C>) command,
                (CommandArgument<C, ?>) commandArgument,
                this.paperCommandManager
        ) {
        };

        if (this.paperCommandManager.getSetting(CommandManager.ManagerSettings.OVERRIDE_EXISTING_COMMANDS)) {
            this.paperCommands.remove(label);
            aliases.forEach(this.paperCommands::remove);
        }

        final Set<String> newAliases = new HashSet<>();

        for (final String alias : aliases) {
            final String namespacedAlias = this.getNamespacedLabel(alias);
            newAliases.add(namespacedAlias);
            if (!this.bukkitCommandOrAliasExists(alias)) {
                newAliases.add(alias);
            }
        }

        if (!this.bukkitCommandExists(label)) {
            newAliases.add(label);
        }
        newAliases.add(namespacedLabel);

        this.commandMap.register(
                label,
                this.paperCommandManager.getOwningPlugin().getName().toLowerCase(),
                paperCommand
        );

        this.recognizedAliases.addAll(newAliases);
        if (this.paperCommandManager.getSplitAliases()) {
            newAliases.forEach(alias -> this.registerExternal(alias, command, paperCommand));
        }

        this.registeredCommands.put(commandArgument, paperCommand);
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public final void unregisterRootCommand(
            final @NonNull StaticArgument<?> rootCommand
    ) {
        final PaperCommand<C> registeredCommand = this.registeredCommands.get(rootCommand);
        if (registeredCommand == null) {
            return;
        }
        registeredCommand.disable();

        final List<String> aliases = new ArrayList<>(rootCommand.getAlternativeAliases());
        final Set<String> registeredAliases = new HashSet<>();

        for (final String alias : aliases) {
            registeredAliases.add(this.getNamespacedLabel(alias));
            if (this.bukkitCommandOrAliasExists(alias)) {
                registeredAliases.add(alias);
            }
        }

        if (this.bukkitCommandExists(rootCommand.getName())) {
            registeredAliases.add(rootCommand.getName());
        }
        registeredAliases.add(this.getNamespacedLabel(rootCommand.getName()));

        this.paperCommands.remove(rootCommand.getName());
        this.paperCommands.remove(this.getNamespacedLabel(rootCommand.getName()));

        this.recognizedAliases.removeAll(registeredAliases);
        if (this.paperCommandManager.getSplitAliases()) {
            registeredAliases.forEach(this::unregisterExternal);
        }

        this.registeredCommands.remove(rootCommand);

        if (this.paperCommandManager.hasCapability(CloudPaperCapabilities.NATIVE_BRIGADIER)) {
            // Once the command has been unregistered, we need to refresh the command list for all online players.
            Paper.getOnlinePlayers().forEach(Player::updateCommands);
        }
    }

    private @NonNull String getNamespacedLabel(final @NonNull String label) {
        return String.format("%s:%s", this.paperCommandManager.getOwningPlugin().getName(), label).toLowerCase();
    }

    /**
     * Check if the given alias is recognizable by this registration handler
     *
     * @param alias Alias
     * @return {@code true} if the alias is recognized, else {@code false}
     */
    public boolean isRecognized(final @NonNull String alias) {
        return this.recognizedAliases.contains(alias);
    }

    protected void registerExternal(
            final @NonNull String label,
            final @NonNull Command<?> command,
            final @NonNull PaperCommand<C> bukkitCommand
    ) {
    }

    @API(status = API.Status.STABLE, since = "1.7.0")
    protected void unregisterExternal(final @NonNull String label) {
    }

    /**
     * Returns true if a command exists in the Bukkit command map, is not an alias, and is not owned by us.
     *
     * @param commandLabel label to check
     * @return whether the command exists and is not an alias
     */
    private boolean bukkitCommandExists(final String commandLabel) {
        final PaperCommand<C> existingCommand = this.paperCommands.get(commandLabel);
        if (existingCommand == null) {
            return false;
        }
        if (existingCommand instanceof PluginIdentifiableCommand) {
            return existingCommand.getLabel().equals(commandLabel)
                    && !((PluginIdentifiableCommand) existingCommand).getPlugin().getName()
                    .equalsIgnoreCase(this.paperCommandManager.getOwningPlugin().getName());
        }
        return existingCommand.getLabel().equals(commandLabel);
    }

    /**
     * Returns true if a command exists in the Bukkit command map, and it is not owned by us, whether or not it is an alias.
     *
     * @param commandLabel label to check
     * @return whether the command exists
     */
    private boolean bukkitCommandOrAliasExists(final String commandLabel) {
        final PaperCommand<C> command = this.paperCommands.get(commandLabel);
        if (command instanceof PluginIdentifiableCommand identifiableCommand) {
            return !(identifiableCommand.getPlugin().getName()
                    .equalsIgnoreCase(this.paperCommandManager.getOwningPlugin().getName()));
        }
        return command != null;
    }
}
