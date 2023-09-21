package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.block.sign.Side;
import io.papermc.paper.api.block.tilestate.Sign;
import io.papermc.paper.api.entity.HumanEntity;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a player begins editing a sign's text.
 * <p>
 * Cancelling this event stops the sign editing menu from opening.
 */
public interface PlayerOpenSignEvent extends CancellablePlayerEvent {

    /**
     * Gets the sign that was clicked.
     *
     * @return {@link Sign} that was clicked
     */
    @Param(1)
    Sign sign();

    /**
     * Gets which side of the sign was clicked.
     *
     * @return {@link Side} that was clicked
     * @see Sign#getSide(Side)
     */
    @Param(2)
    Side side();

    /**
     * The cause of this sign open.
     *
     * @return the cause
     */
    @Param(3)
    Cause cause();

    /**
     * The cause of the {@link PlayerOpenSignEvent}.
     */
    enum Cause {
        /**
         * The event was triggered by the placement of a sign.
         */
        PLACE,
        /**
         * The event was triggered by an interaction with a sign.
         */
        INTERACT,
        /**
         * The event was triggered via a plugin with {@link HumanEntity#openSign(Sign, Side)}
         */
        PLUGIN,
        /**
         * Fallback cause for any unknown cause.
         */
        UNKNOWN,
    }
}
