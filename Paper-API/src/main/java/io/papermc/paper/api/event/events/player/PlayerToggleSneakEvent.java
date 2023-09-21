package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;

/**
 * Called when a player toggles their sneaking state
 */
public interface PlayerToggleSneakEvent extends CancellablePlayerEvent {

    /**
     * Returns whether the player is now sneaking or not.
     *
     * @return sneaking state
     */
    @Param(1)
    boolean isSneaking();
}
