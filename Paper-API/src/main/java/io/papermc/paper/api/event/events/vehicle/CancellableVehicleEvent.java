package io.papermc.paper.api.event.events.vehicle;

import io.papermc.paper.api.entity.Vehicle;
import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;

/**
 * Represents a vehicle event that can be cancelled
 * <p>
 *     <b>
 *         Anything that implements/extends this interface cannon inherit {@link VehicleResultEvent}
 *     </b>
 */
public interface CancellableVehicleEvent extends VehicleEvent, Cancellable {

    /**
     * Gets the vehicle involved in this event
     * @return the vehicle involved in this event
     */
    @Param(0)
    Vehicle vehicle();
}
