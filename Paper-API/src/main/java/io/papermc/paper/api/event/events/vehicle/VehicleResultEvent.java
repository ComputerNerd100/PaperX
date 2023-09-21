package io.papermc.paper.api.event.events.vehicle;

import io.papermc.paper.api.entity.Vehicle;
import io.papermc.paper.api.event.type.ResultEvent;

/**
 * Represents a vehicle event that returns a result
 * <p>
 *     <b>
 *         Anything that implements/extends this interface cannon inherit {@link CancellableVehicleEvent}
 *     </b>
 */
public interface VehicleResultEvent extends VehicleEvent, ResultEvent<Vehicle> {
    default Vehicle vehicle() {
        return result();
    }
    default void setVehicle(Vehicle vehicle) {
        rawResult().set(vehicle);
    }
}
