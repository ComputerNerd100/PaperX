package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.event.events.player.PlayerMoveEvent;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.location.Location;

/**
 * Holds information for living entity movement events
 * <p>
 * Does not fire for players; use {@link PlayerMoveEvent} for player movement.
 */
public interface EntityMoveEvent extends CancellableEntityEvent {

    /**
     * Gets the location this entity moved from
     *
     * @return Location the entity moved from
     */
    @Param(1)
    Location from();

    /**
     * Gets the location this entity moved to
     *
     * @return Location the entity moved to
     */
    @Param(2)
    Location to();
}
