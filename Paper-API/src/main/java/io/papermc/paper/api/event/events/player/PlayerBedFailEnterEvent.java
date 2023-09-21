package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.event.util.Param;
import net.kyori.adventure.text.Component;

/**
 * Called when a player fails to enter a bed.
 */
public interface PlayerBedFailEnterEvent extends CancellablePlayerEvent {

    /**
     * Get the reason why the player failed to enter the bed.
     * @return the reason
     */
    @Param(1)
    FailReason failReason();

    /**
     * Get the bed the player tried to enter.
     * @return the bed
     */
    @Param(2)
    Block bed();

    /**
     * Whether the bed will explode if the player enters it.
     * @return whether the bed will explode
     */
    @Param(3)
    boolean willExplode();

    /**
     * Get the message to send to the player.
     * @return the message
     */
    @Param(4)
    Component message();

    enum FailReason {
        /**
         * The world doesn't allow sleeping (ex. Nether or The End). Entering
         * the bed is prevented and the bed explodes.
         */
        NOT_POSSIBLE_HERE,
        /**
         * Entering the bed is prevented due to it not being night nor
         * thundering currently.
         * <p>
         * If the event is forcefully allowed during daytime, the player will
         * enter the bed (and set its bed location), but might get immediately
         * thrown out again.
         */
        NOT_POSSIBLE_NOW,
        /**
         * Entering the bed is prevented due to the player being too far away.
         */
        TOO_FAR_AWAY,
        /**
         * Bed is obstructed.
         */
        OBSTRUCTED,
        /**
         * Entering the bed is prevented due to there being some other problem.
         */
        OTHER_PROBLEM,
        /**
         * Entering the bed is prevented due to there being monsters nearby.
         */
        NOT_SAFE;
    }
}
