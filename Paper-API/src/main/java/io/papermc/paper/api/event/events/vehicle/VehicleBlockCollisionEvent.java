package io.papermc.paper.api.event.events.vehicle;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.util.vector.Vector;

/**
 * Raised when a vehicle collides with a block.
 */
public interface VehicleBlockCollisionEvent extends VehicleCollisionEvent {

    /**
     * Gets the block the vehicle collided with
     *
     * @return the block the vehicle collided with
     */
    @Param(1)
    Block block();

    /**
     * Gets velocity at which the vehicle collided with the block
     *
     * @return pre-collision moving velocity
     */
    @Param(2)
    Vector velocity();
}
