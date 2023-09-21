package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;

/**
 * Is called when a {@link Player} tracks an {@link Entity}.
 * <p>
 * If cancelled entity is not shown to the player and interaction in both directions is not possible.
 */
public interface PlayerTrackEntityEvent extends CancellablePlayerEvent {

    /**
     * Gets the entity that will be tracked
     *
     * @return the entity tracked
     */
    @Param(1)
    Entity entity();
}
