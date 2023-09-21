package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import net.kyori.adventure.text.Component;

/**
 * Called when a player leaves a server
 */
public interface PlayerQuitEvent extends PlayerResultEvent {

    /**
     * Gets the quit message to send to all online players
     *
     * @return string quit message
     */
    @Param(0)
    Component quitMessage();

    /**
     * Gets the reason the player quit
     * @return quit reason
     */
    @Param(1)
    QuitReason reason();

    enum QuitReason {
        /**
         * The player left on their own behalf.
         * <p>
         * This does not mean they pressed the disconnect button in their client, but rather that the client severed the
         * connection themselves. This may occur if no keep-alive packet is received on their side, among other things.
         */
        DISCONNECTED,

        /**
         * The player was kicked from the server.
         */
        KICKED,

        /**
         * The player has timed out.
         */
        TIMED_OUT,

        /**
         * The player's connection has entered an erroneous state.
         * <p>
         * Reasons for this may include invalid packets, invalid data, and uncaught exceptions in the packet handler,
         * among others.
         */
        ERRONEOUS_STATE,
    }
}
