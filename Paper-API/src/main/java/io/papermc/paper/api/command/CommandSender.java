package io.papermc.paper.api.command;

import io.papermc.paper.api.Server;
import io.papermc.paper.api.permisson.Permissible;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.audience.MessageType;
import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface CommandSender extends Audience, Permissible {

    /**
     * Returns the server instance that this command is running on
     *
     * @return Server instance
     */
    @NonNull Server getServer();

    /**
     * Gets the name of this command sender
     *
     * @return Name of the sender
     */
    @NonNull String getName();

    /**
     * Gets the name of this command sender
     *
     * @return Name of the sender
     */
    @NonNull Component name();

    @Override
    default void sendMessage(final @NonNull Identity identity, final @NonNull Component message, final @NonNull MessageType type) {
        this.sendMessage(LegacyComponentSerializer.legacySection().serialize(message));
    }

    /**
     * Sends a message with the MiniMessage format to the command sender.
     * <p>
     * See <a href="https://docs.advntr.dev/minimessage/">MiniMessage docs</a>
     * for more information on the format.
     *
     * @param message MiniMessage content
     */
    default void sendRichMessage(final @NonNull String message) {
        this.sendMessage(net.kyori.adventure.text.minimessage.MiniMessage.miniMessage().deserialize(message));
    }

    /**
     * Sends a message with the MiniMessage format to the command sender.
     * <p>
     * See <a href="https://docs.advntr.dev/minimessage/">MiniMessage docs</a> and <a href="https://docs.advntr.dev/minimessage/dynamic-replacements">MiniMessage Placeholders docs</a>
     * for more information on the format.
     *
     * @param message MiniMessage content
     * @param resolvers resolvers to use
     */
    default void sendRichMessage(final @NonNull String message, final net.kyori.adventure.text.minimessage.tag.resolver.@NonNull TagResolver... resolvers) {
        this.sendMessage(net.kyori.adventure.text.minimessage.MiniMessage.miniMessage().deserialize(message, resolvers));
    }

    /**
     * Sends a plain message to the command sender.
     *
     * @param message plain message
     */
    default void sendPlainMessage(final @NonNull String message) {
        this.sendMessage(Component.text(message));
    }
}

