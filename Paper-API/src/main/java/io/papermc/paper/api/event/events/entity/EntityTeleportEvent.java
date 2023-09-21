package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.location.Location;

/**
 * Thrown when a non-player entity is teleported from one location to another.
 * <br>
 * This may be as a result of natural causes (Enderman, Shulker), pathfinding
 * (Wolf), or commands (/teleport).
 */
public interface EntityTeleportEvent extends CancellableEntityEvent {

    /**
     * Gets the location that this entity moved from
     *
     * @return Location this entity moved from
     */
    @Param(1)
    Location from();

    /**
     * Gets the location that this entity moved to
     *
     * @return Location the entity moved to
     */
    @Param(2)
    Location to();

}
