package io.papermc.paper.api.event.events.vehicle;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;

/**
 * Raised when a vehicle receives damage.
 */
public interface VehicleDamageEvent extends CancellableVehicleEvent {

    /**
     * Gets the Entity that is attacking the vehicle
     *
     * @return the Entity that is attacking the vehicle
     */
    @Param(1)
    Entity attacker();

    /**
     * Gets the damage done to the vehicle
     *
     * @return the damage done to the vehicle
     */
    @Param(2)
    double damage();
}
