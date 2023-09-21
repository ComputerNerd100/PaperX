package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Turtle;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.location.Location;

/**
 * Fired when a Turtle starts digging to lay eggs
 */
public interface TurtleStartDiggingEvent extends CancellableEntityEvent {

    /**
     * The turtle digging
     *
     * @return The turtle
     */
    default Turtle getTurtle() {
        return (Turtle) entity();
    }

    /**
     * Get the location where the turtle is digging
     *
     * @return Location where digging
     */
    @Param(1)
    Location location();
}
