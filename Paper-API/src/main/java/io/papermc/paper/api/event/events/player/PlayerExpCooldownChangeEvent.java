package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a player's experience cooldown changes.
 */
public interface PlayerExpCooldownChangeEvent extends PlayerResultEvent {

    /**
     * Gets the new cooldown for the player.
     *
     * @return The new cooldown
     * @see Player#getExpCooldown()
     */
    @Param(0)
    int newCooldown();

    /**
     * Gets the reason for the change.
     *
     * @return The reason for the change
     */
    @Param(1)
    ChangeReason reason();

    enum ChangeReason {

        /**
         * The cooldown was set by picking up an experience orb.
         */
        PICKUP_ORB,
        /**
         * The cooldown was set by a plugin.
         *
         * @see Player#setExpCooldown(int)
         */
        PLUGIN
    }
}
