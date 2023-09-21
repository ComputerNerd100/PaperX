package io.papermc.paper.api.event.events.vehicle;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;

/**
 * Raised when a vehicle collides with an entity.
 */
public interface VehicleEntityCollisionEvent extends VehicleCollisionEvent, Cancellable {

    /**
     * Gets the entity involved in this event
     * @return the entity involved in this event
     */
    @Param(1)
    Entity entity();
}
