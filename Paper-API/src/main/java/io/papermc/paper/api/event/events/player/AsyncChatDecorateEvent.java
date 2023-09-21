package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.events.server.ServerEvent;
import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;
import net.kyori.adventure.text.Component;

/**
 * This event is fired when the server decorates a component for chat purposes. This is called
 * before {@link AsyncChatEvent} and the other chat events. It is recommended that you modify the
 * message here, and use the chat events for modifying receivers and later the chat type. If you
 * want to keep the message as "signed" for the clients who get it, be sure to include the entire
 * original message somewhere in the final message.
 * @see AsyncChatCommandDecorateEvent for the decoration of messages sent via commands
 */
public interface AsyncChatDecorateEvent extends ServerEvent, Cancellable {

    /**
     * Gets the player (if available) associated with this event.
     * <p>
     * Certain commands request decorations without a player context
     * which is why this is possibly null.
     *
     * @return the player or null
     */
    @Param(0)
    Player player();

    /**
     * Gets the original decoration input
     *
     * @return the input
     */
    @Param(1)
    Component originalMessage();

    /**
     * Gets the decoration result. This may already be different from
     * {@link #originalMessage()} if some other listener to this event
     * changed the result.
     *
     * @return the result
     */
    @Param(2)
    Component result();
}
