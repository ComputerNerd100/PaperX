package io.papermc.paper.api.command;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.audience.ForwardingAudience;
import net.kyori.adventure.audience.MessageType;
import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface ProxiedCommandSender extends CommandSender, net.kyori.adventure.audience.ForwardingAudience.Single {

    /**
     * Returns the CommandSender which triggered this proxied command
     *
     * @return the caller which triggered the command
     */
    @NonNull
    CommandSender getCaller();

    /**
     * Returns the CommandSender which is being used to call the command
     *
     * @return the caller which the command is being run as
     */
    @NonNull
    CommandSender getCallee();

    // Paper start
    @Override
    default void sendMessage(final @NonNull Identity source, final @NonNull Component message, final @NonNull MessageType type) {
        ForwardingAudience.Single.super.sendMessage(source, message, type);
    }

    @NonNull
    @Override
    default Audience audience() {
        return this.getCaller();
    }
}

