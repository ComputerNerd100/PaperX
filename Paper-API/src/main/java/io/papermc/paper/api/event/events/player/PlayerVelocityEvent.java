package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.util.vector.Vector;

/**
 * Called when the velocity of a player changes.
 */
public interface PlayerVelocityEvent extends CancellablePlayerEvent {

    /**
     * Gets the velocity vector that will be sent to the player
     *
     * @return Vector the player will get
     */
    @Param(1)
    Vector velocity();
}
