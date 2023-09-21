package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Turtle;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.location.Location;

/**
 * Fired when a Turtle lays eggs
 */
public interface TurtleLayEggEvent extends CancellableEntityEvent {

    /**
     * The turtle laying the eggs
     *
     * @return The turtle
     */
    default Turtle getTurtle() {
        return (Turtle) entity();
    }

    /**
     * Get the location where the eggs are being laid
     *
     * @return Location of eggs
     */
    @Param(1)
    Location location();

    /**
     * Get the number of eggs being laid
     *
     * @return Number of eggs
     */
    @Param(2)
    int eggCount();
}
