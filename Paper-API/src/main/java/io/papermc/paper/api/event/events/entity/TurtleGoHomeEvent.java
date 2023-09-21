package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Turtle;

/**
 * Fired when a Turtle decides to go home
 */
public interface TurtleGoHomeEvent extends CancellableEntityEvent {

    /**
     * The turtle going home
     *
     * @return The turtle
     */
    default Turtle getTurtle() {
        return (Turtle) entity();
    }
}
