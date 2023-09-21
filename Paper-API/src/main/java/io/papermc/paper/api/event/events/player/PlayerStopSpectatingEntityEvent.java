package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;

/**
 * Triggered when a player stops spectating an entity in spectator mode.
 */
public interface PlayerStopSpectatingEntityEvent extends CancellablePlayerEvent {

    /**
     * Gets the entity that the player is spectating
     *
     * @return The entity the player is currently spectating (before they will stop).
     */
    @Param(1)
    Entity spectatorTarget();
}
