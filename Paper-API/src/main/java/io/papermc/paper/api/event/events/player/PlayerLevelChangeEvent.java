package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;

/**
 * Called when a players level changes
 */
public interface PlayerLevelChangeEvent extends PlayerResultEvent {

    /**
     * Gets the old level of the player
     *
     * @return The old level of the player
     */
    @Param(1)
    int oldLevel();

    /**
     * Gets the new level of the player
     *
     * @return The new (current) level of the player
     */
    @Param(2)
    int newLevel();
}
