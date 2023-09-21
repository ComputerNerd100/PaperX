package io.papermc.paper.api.event.events.vehicle;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;

/**
 * Raised when an entity enters a vehicle.
 */
public interface VehicleEnterEvent extends CancellableVehicleEvent {

    /**
     * Gets the Entity that entered the vehicle.
     *
     * @return the Entity that entered the vehicle
     */
    @Param(1)
    Entity entered();
}
