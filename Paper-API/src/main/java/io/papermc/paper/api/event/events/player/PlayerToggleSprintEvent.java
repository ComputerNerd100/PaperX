package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;

/**
 * Called when a player toggles their sprinting state
 */
public interface PlayerToggleSprintEvent extends CancellablePlayerEvent {

    /**
     * Gets whether the player is now sprinting or not.
     *
     * @return sprinting state
     */
    @Param(1)
    boolean isSprinting();

}
