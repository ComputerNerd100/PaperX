package io.papermc.paper.api.event.events.world;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.location.Location;
import io.papermc.paper.api.util.game.GameEvent;

/**
 * Represents a generic Mojang game event.
 *
 * Specific Bukkit events should be used where possible, this event is mainly
 * used internally by Sculk sensors.
 */
public interface GenericGameEvent extends CancellableWorldEvent {

    /**
     * Get the underlying event.
     *
     * @return the event
     */
    @Param(1)
    GameEvent event();

    /**
     * Get the location where the event occurred.
     *
     * @return event location
     */
    @Param(2)
    Location location();

    /**
     * Get the entity which triggered this event, if present.
     *
     * @return triggering entity or null
     */
    @Param(3)
    Entity entity();

    /**
     * Get the block radius to which this event will be broadcast.
     *
     * @return broadcast radius
     */
    @Param(4)
    int radius();
}
