package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.chat.ChatRenderer;
import io.papermc.paper.api.event.util.Param;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.chat.SignedMessage;
import net.kyori.adventure.text.Component;

import java.util.Set;

/**
 * An abstract implementation of a chat event, handling shared logic.
 */
public interface AbstractChatEvent extends CancellablePlayerEvent {

    /**
     * Gets a set of {@link Audience audiences} that this chat message will be displayed to.
     *
     * <p>The set returned may auto-populate on access. Any listener accessing the returned set should be aware that
     * it may reduce performance for a lazy set implementation.</p>
     *
     * @return a mutable set of {@link Audience audiences} who will receive the chat message
     */
    @Param(1)
    Set<Audience> viewers();

    /**
     * Gets the original and unmodified user-supplied message.
     * Changes made to this message will not be reflected in the chat message.
     *
     * @return the original user-supplied message
     */
    @Param(2)
    Component originalMessage();

    /**
     * Gets the signed message.
     * Changes made in this event will <b>not</b> update
     * the signed message.
     *
     * @return the signed message
     */
    @Param(3)
    SignedMessage signedMessage();

    /**
     * Gets the chat renderer.
     *
     * @return the chat renderer
     */
    @Param(4)
    ChatRenderer renderer();

    /**
     * Gets the user-supplied message.
     * Changes made to this message will be reflected in the chat message.
     *
     * @return the user-supplied message
     */
    @Param(5)
    Component message();
}
