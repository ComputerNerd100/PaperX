package io.papermc.paper.api.event.events.vehicle;

import io.papermc.paper.api.entity.Vehicle;
import io.papermc.paper.api.event.util.Param;

/**
 * Raised when a vehicle collides.
 */
public interface VehicleCollisionEvent extends VehicleEvent {

    /**
     * Gets the vehicle involved in this event
     * @return the vehicle involved in this event
     */
    @Param(0)
    Vehicle vehicle();
}
