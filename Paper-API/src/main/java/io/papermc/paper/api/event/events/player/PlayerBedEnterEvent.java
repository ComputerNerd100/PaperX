package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.world.World;

/**
 * This event is fired when the player is almost about to enter the bed.
 */
public interface PlayerBedEnterEvent extends CancellablePlayerEvent {

    /**
     * Returns the bed block involved in this event.
     *
     * @return the bed block involved in this event
     */
    @Param(1)
    Block bed();

    /**
     * This describes the default outcome of this event.
     *
     * @return the bed enter result representing the default outcome of this event
     */
    @Param(2)
    BedEnterResult result();

    /**
     * This controls the action to take with the bed that was clicked on.
     * <p>
     * In case of {@link io.papermc.paper.api.event.Event.Result#DEFAULT}, the default outcome is described by
     * {@link #result()}.
     *
     * @return the action to take with the interacted bed
     */
    @Param(3)
    Result useBed();

    /**
     * Represents the default possible outcomes of this event.
     */
    enum BedEnterResult {
        /**
         * The player will enter the bed.
         */
        OK,
        /**
         * The world doesn't allow sleeping or saving the spawn point (eg,
         * Nether, The End or Custom Worlds). This is based on
         * {@link World#isBedWorks()} and {@link World#isNatural()}.
         *
         * Entering the bed is prevented and if {@link World#isBedWorks()} is
         * false then the bed explodes.
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
         * Bed was obstructed.
         */
        OBSTRUCTED,
        /**
         * Entering the bed is prevented due to there being monsters nearby.
         */
        NOT_SAFE,
        /**
         * Entering the bed is prevented due to there being some other problem.
         */
        OTHER_PROBLEM;
    }
}
