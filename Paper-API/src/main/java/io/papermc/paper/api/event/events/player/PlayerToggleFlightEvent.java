package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;

/**
 * Called when a player toggles their flying state
 */
public interface PlayerToggleFlightEvent extends CancellablePlayerEvent {

    /**
     * Returns whether the player is trying to start or stop flying.
     *
     * @return flying state
     */
    @Param(1)
    boolean isFlying();
}
