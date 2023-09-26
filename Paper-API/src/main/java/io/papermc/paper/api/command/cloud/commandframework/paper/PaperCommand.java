package io.papermc.paper.api.command.cloud.commandframework.paper;

import cloud.commandframework.Command;
import cloud.commandframework.CommandTree;
import cloud.commandframework.arguments.CommandArgument;
import cloud.commandframework.exceptions.*;
import cloud.commandframework.meta.CommandMeta;
import cloud.commandframework.permission.CommandPermission;
import cloud.commandframework.permission.Permission;
import io.papermc.paper.api.Paper;
import io.papermc.paper.api.Server;
import io.papermc.paper.api.command.BlockCommandSender;
import io.papermc.paper.api.command.CommandSender;
import io.papermc.paper.api.command.ConsoleCommandSender;
import io.papermc.paper.api.entity.minecart.CommandMinecart;
import io.papermc.paper.api.permisson.Permissible;
import io.papermc.paper.api.plugin.Plugin;
import io.papermc.paper.api.util.game.GameRule;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.TextReplacementConfig;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.CompletionException;
import java.util.logging.Level;

public abstract class PaperCommand<C extends CommandSender> {

    private String name;
    private String nextLabel;
    private String label;
    private List<String> aliases;
    private List<String> activeAliases;
    private String description;
    private String usageMessage;
    private String permission;
    private Component permissionMessage;
    private boolean disabled;
    private final CommandArgument<C, ?> command;
    private final PaperCommandManager<C> manager;
    private final Command<C> cloudCommand;
    private static final String MESSAGE_INTERNAL_ERROR = NamedTextColor.RED + "An internal error occurred while attempting to perform this command";
    private static final String MESSAGE_NO_PERMS = NamedTextColor.RED
            + "I'm sorry, but you do not have permission to perform this command. "
            + "Please contact the server administrators if you believe that this is in error.";
    private static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command. Type \"/help\" for help.";

    PaperCommand(@NonNull String label, @NonNull List<String> aliases, @NonNull Command<C> cloudCommand, @NonNull CommandArgument<C, ?> command, @NonNull PaperCommandManager<C> manager) {
        this.name = label;
        this.nextLabel = label;
        this.label = label;
        this.command = command;
        this.manager = manager;
        this.cloudCommand = cloudCommand;
        if (this.command.getOwningCommand() != null) {
            this.setPermission(this.command.getOwningCommand().getCommandPermission().toString());
        }
        this.description = (description == null) ? "" : description;
        this.usageMessage = (usageMessage == null) ? "" : usageMessage;
        this.aliases = aliases;
        this.activeAliases = new ArrayList<>(aliases);
        this.disabled = false;
    }

    public @NonNull List<String> tabComplete(@NonNull CommandSender sender, @NonNull String[] args) throws IllegalArgumentException {
        final StringBuilder builder = new StringBuilder(this.command.getName());
        for (final String string : args) {
            builder.append(" ").append(string);
        }
        return this.manager.suggest(
                this.manager.getCommandSenderMapper().apply(sender),
                builder.toString()
        );
    }

    public boolean execute(
            final @NonNull CommandSender commandSender,
            final @NonNull String @NonNull [] strings
    ) {
        /* Join input */
        final StringBuilder builder = new StringBuilder(this.command.getName());
        for (final String string : strings) {
            builder.append(" ").append(string);
        }
        final C sender = this.manager.getCommandSenderMapper().apply(commandSender);
        this.manager.executeCommand(sender, builder.toString())
                .whenComplete((commandResult, throwable) -> {
                    if (throwable != null) {
                        if (throwable instanceof CompletionException) {
                            throwable = throwable.getCause();
                        }
                        final Throwable finalThrowable = throwable;
                        if (throwable instanceof InvalidSyntaxException) {
                            this.manager.handleException(sender,
                                    InvalidSyntaxException.class,
                                    (InvalidSyntaxException) throwable, (c, e) ->
                                            commandSender.sendMessage(Component.text(NamedTextColor.RED + "Invalid Command Syntax. "
                                                    + "Correct command syntax is: "
                                                    + NamedTextColor.GRAY + "/"
                                                    + ((InvalidSyntaxException) finalThrowable)
                                                    .getCorrectSyntax())
                            ));
                        } else if (throwable instanceof InvalidCommandSenderException) {
                            this.manager.handleException(sender,
                                    InvalidCommandSenderException.class,
                                    (InvalidCommandSenderException) throwable, (c, e) ->
                                            commandSender.sendMessage(Component.text(NamedTextColor.RED + finalThrowable.getMessage()))
                            );
                        } else if (throwable instanceof NoPermissionException) {
                            this.manager.handleException(sender,
                                    NoPermissionException.class,
                                    (NoPermissionException) throwable, (c, e) ->
                                            commandSender.sendMessage(Component.text(MESSAGE_NO_PERMS))
                            );
                        } else if (throwable instanceof NoSuchCommandException) {
                            this.manager.handleException(sender,
                                    NoSuchCommandException.class,
                                    (NoSuchCommandException) throwable, (c, e) ->
                                            commandSender.sendMessage(Component.text(MESSAGE_UNKNOWN_COMMAND))
                            );
                        } else if (throwable instanceof ArgumentParseException) {
                            this.manager.handleException(sender,
                                    ArgumentParseException.class,
                                    (ArgumentParseException) throwable, (c, e) ->
                                            commandSender.sendMessage(Component.text(NamedTextColor.RED + "Invalid Command Argument: "
                                                    + NamedTextColor.GRAY + finalThrowable.getCause()
                                                    .getMessage()))

                            );
                        } else if (throwable instanceof CommandExecutionException) {
                            this.manager.handleException(sender,
                                    CommandExecutionException.class,
                                    (CommandExecutionException) throwable, (c, e) -> {
                                        commandSender.sendMessage(MESSAGE_INTERNAL_ERROR);
                                        this.manager.getOwningPlugin().getLogger().log(
                                                Level.SEVERE,
                                                "Exception executing command handler",
                                                finalThrowable.getCause()
                                        );
                                    }
                            );
                        } else {
                            commandSender.sendMessage(MESSAGE_INTERNAL_ERROR);
                            this.manager.getOwningPlugin().getLogger().log(
                                    Level.SEVERE,
                                    "An unhandled exception was thrown during command execution",
                                    throwable
                            );
                        }
                    }
                });
        return true;
    }

    public @NonNull String getDescription() {
        return this.cloudCommand.getCommandMeta().getOrDefault(CommandMeta.DESCRIPTION, "");
    }

    public @NonNull Plugin getPlugin() {
        return this.manager.getOwningPlugin();
    }

    public @NonNull String getUsage() {
        return this.manager.commandSyntaxFormatter().apply(
                Collections.singletonList(Objects.requireNonNull(this.namedNode().getValue())),
                this.namedNode()
        );
    }



    @ApiStatus.Internal
    void disable() {
        this.disabled = true;
    }

    public boolean isRegistered() {
        return !this.disabled;
    }

    private CommandTree.@Nullable Node<CommandArgument<C, ?>> namedNode() {
        return this.manager.commandTree().getNamedNode(this.command.getName());
    }

    /**
     * Returns the name of this command
     *
     * @return Name of this command
     */
    @NonNull
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this command.
     * <p>
     * May only be used before registering the command.
     * Will return true if the new name is set, and false
     * if the command has already been registered.
     *
     * @param name New command name
     * @return returns true if the name change happened instantly or false if
     *     the command was already registered
     */
    public boolean setName(@NonNull String name) {
        if (!isRegistered()) {
            this.name = (name == null) ? "" : name;
            return true;
        }
        return false;
    }

    /**
     * Gets the permission required by users to be able to perform this
     * command
     *
     * @return Permission name, or null if none
     */
    @Nullable
    public String getPermission() {
        return permission;
    }

    /**
     * Sets the permission required by users to be able to perform this
     * command
     *
     * @param permission Permission name or null
     */
    public void setPermission(@Nullable String permission) {
        this.permission = permission;
    }

    /**
     * Tests the given {@link CommandSender} to see if they can perform this
     * command.
     * <p>
     * If they do not have permission, they will be informed that they cannot
     * do this.
     *
     * @param target User to test
     * @return true if they can use it, otherwise false
     */
    public boolean testPermission(@NonNull CommandSender target) {
        if (testPermissionSilent(target)) {
            return true;
        }
        Component permissionMessage = this.permissionMessage != null ? this.permissionMessage : Paper.permissionMessage();
        if (!permissionMessage.equals(Component.empty())) {
            target.sendMessage(permissionMessage.replaceText(TextReplacementConfig.builder().matchLiteral("<permission>").replacement(permission).build()));
        }
        return false;
    }

    public boolean testPermissionSilent(final @NonNull CommandSender target) {
        final CommandTree.Node<CommandArgument<C, ?>> node = this.namedNode();
        if (this.disabled || node == null) {
            return false;
        }

        final CommandPermission permission = (CommandPermission) node
                .getNodeMeta()
                .getOrDefault("permission", Permission.empty());

        return this.manager.hasPermission(this.manager.getCommandSenderMapper().apply(target), permission);
    }

    /**
     * Returns the label for this command
     *
     * @return Label of this command
     */
    @NonNull
    public String getLabel() {
        return label;
    }

    /**
     * Sets the label of this command.
     * <p>
     * May only be used before registering the command.
     * Will return true if the new name is set, and false
     * if the command has already been registered.
     *
     * @param name The command's name
     * @return returns true if the name change happened instantly or false if
     *     the command was already registered
     */
    public boolean setLabel(@NonNull String name) {
        if (name == null) {
            name = "";
        }
        this.nextLabel = name;
        if (!isRegistered()) {
            this.label = name;
            return true;
        }
        return false;
    }

    /**
     * Registers this command to a CommandMap.
     * Once called it only allows changes the registered CommandMap
     *
     * @param commandMap the CommandMap to register this command to
     * @return true if the registration was successful (the current registered
     *     CommandMap was the passed CommandMap or null) false otherwise
     */
    public boolean register(@NonNull CommandMap commandMap) {
        if (allowChangesFrom(commandMap)) {
            this.commandMap = commandMap;
            return true;
        }

        return false;
    }

    /**
     * Unregisters this command from the passed CommandMap applying any
     * outstanding changes
     *
     * @param commandMap the CommandMap to unregister
     * @return true if the unregistration was successful (the current
     *     registered CommandMap was the passed CommandMap or null) false
     *     otherwise
     */
    public boolean unregister(@NonNull CommandMap commandMap) {
        if (allowChangesFrom(commandMap)) {
            this.commandMap = null;
            this.activeAliases = new ArrayList<>(this.aliases);
            this.label = this.nextLabel;
            return true;
        }

        return false;
    }

    private boolean allowChangesFrom(@NonNull CommandMap commandMap) {
        return (null == this.commandMap || this.commandMap == commandMap);
    }

    /**
     * Returns a list of active aliases of this command
     *
     * @return List of aliases
     */
    @NonNull
    public List<String> getAliases() {
        return activeAliases;
    }

    /**
     * Sets the list of aliases to request on registration for this command.
     * This is not effective outside of defining aliases in the {@link
     * PluginDescriptionFile#getCommands()} (under the
     * `<code>aliases</code>' node) is equivalent to this method.
     *
     * @param aliases aliases to register to this command
     * @return this command object, for chaining
     */
    @NonNull
    public PaperCommand<C> setAliases(@NonNull List<String> aliases) {
        this.aliases = aliases;
        if (!isRegistered()) {
            this.activeAliases = new ArrayList<String>(aliases);
        }
        return this;
    }

    /**
     * Sets a brief description of this command. Defining a description in the
     * {@link PluginDescriptionFile#getCommands()} (under the
     * `<code>description</code>' node) is equivalent to this method.
     *
     * @param description new command description
     * @return this command object, for chaining
     */
    @NonNull
    public PaperCommand<C> setDescription(@NonNull String description) {
        this.description = (description == null) ? "" : description;
        return this;
    }

    /**
     * Sets the example usage of this command
     *
     * @param usage new example usage
     * @return this command object, for chaining
     */
    @NonNull
    public PaperCommand<C> setUsage(@NonNull String usage) {
        this.usageMessage = (usage == null) ? "" : usage;
        return this;
    }

    /**
     * Gets the permission message.
     *
     * @return the permission message
     */
    public net.kyori.adventure.text.@Nullable Component permissionMessage() {
        return this.permissionMessage;
    }

    /**
     * Sets the permission message.
     *
     * @param permissionMessage the permission message
     */
    public void permissionMessage(@Nullable Component permissionMessage) {
        this.permissionMessage = permissionMessage;
    }

    public static void broadcastCommandMessage(@NonNull CommandSender source, @NonNull String message) {
        broadcastCommandMessage(source, message, true);
    }

    public static void broadcastCommandMessage(@NonNull CommandSender source, @NonNull String message, boolean sendToSource) {
        broadcastCommandMessage(source, LegacyComponentSerializer.legacySection().deserialize(message), sendToSource);
    }

    public static void broadcastCommandMessage(@NonNull CommandSender source, @NonNull Component message) {
        broadcastCommandMessage(source, message, true);
    }

    public static void broadcastCommandMessage(@NonNull CommandSender source, @NonNull Component message, boolean sendToSource) {
        TextComponent.Builder result = Component.text()
                .color(NamedTextColor.WHITE)
                .decoration(TextDecoration.ITALIC, false)
                .append(source.name())
                .append(net.kyori.adventure.text.Component.text(": "))
                .append(message);

        if (source instanceof BlockCommandSender) {
            BlockCommandSender blockCommandSender = (BlockCommandSender) source;

            if (!blockCommandSender.getBlock().getWorld().getGameRuleValue(GameRule.COMMAND_BLOCK_OUTPUT)) {
                Paper.getConsoleSender().sendMessage(result);
                return;
            }
        } else if (source instanceof CommandMinecart) {
            CommandMinecart commandMinecart = (CommandMinecart) source;

            if (!commandMinecart.getWorld().getGameRuleValue(GameRule.COMMAND_BLOCK_OUTPUT)) {
                Paper.getConsoleSender().sendMessage(result);
                return;
            }
        }

        Set<Permissible> users = Paper.getPluginManager().getPermissionSubscriptions(Server.BROADCAST_CHANNEL_ADMINISTRATIVE);
        TextComponent.Builder colored = net.kyori.adventure.text.Component.text()
                .color(NamedTextColor.GRAY)
                .decorate(TextDecoration.ITALIC)
                .append(Component.text("["), result, net.kyori.adventure.text.Component.text("]"));

        if (sendToSource && !(source instanceof ConsoleCommandSender)) {
            source.sendMessage(message);
        }

        for (Permissible user : users) {
            if (user instanceof CommandSender && user.hasPermission(Server.BROADCAST_CHANNEL_ADMINISTRATIVE)) {
                CommandSender target = (CommandSender) user;

                if (target instanceof ConsoleCommandSender) {
                    target.sendMessage(result);
                } else if (target != source) {
                    target.sendMessage(colored);
                }
            }
        }
    }

    @Override
    public String toString() {
        return getClass().getName() + '(' + name + ')';
    }
}
