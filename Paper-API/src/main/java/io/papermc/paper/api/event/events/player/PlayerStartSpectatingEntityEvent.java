package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;

/**
 * Triggered when a player starts spectating an entity in spectator mode.
 */
public interface PlayerStartSpectatingEntityEvent extends CancellablePlayerEvent {

    /**
     * Gets the entity that the player is currently spectating or themselves if they weren't spectating anything
     *
     * @return The entity the player is currently spectating (before they start spectating the new target).
     */
    @Param(1)
    Entity currentSpectatorTarget();

    /**
     * Gets the new entity that the player will now be spectating
     *
     * @return The entity the player is now going to be spectating.
     */
    @Param(2)
    Entity newSpectatorTarget();
}
