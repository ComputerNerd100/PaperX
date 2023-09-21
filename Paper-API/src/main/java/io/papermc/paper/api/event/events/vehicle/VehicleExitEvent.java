package io.papermc.paper.api.event.events.vehicle;

import io.papermc.paper.api.entity.LivingEntity;
import io.papermc.paper.api.event.util.Param;

/**
 * Raised when a living entity exits a vehicle.
 */
public interface VehicleExitEvent extends CancellableVehicleEvent {

    /**
     * Get the living entity that exited the vehicle.
     *
     * @return The entity.
     */
    @Param(1)
    LivingEntity exited();
}
