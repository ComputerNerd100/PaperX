package io.papermc.paper.api.event.events.vehicle;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.location.Location;

/**
 * Raised when a vehicle moves.
 */
public interface VehicleMoveEvent extends VehicleResultEvent {

    /**
     * Get the previous position.
     *
     * @return Old position.
     */
    @Param(0)
    Location from();

    /**
     * Get the next position.
     *
     * @return New position.
     */
    @Param(1)
    Location to();
}
