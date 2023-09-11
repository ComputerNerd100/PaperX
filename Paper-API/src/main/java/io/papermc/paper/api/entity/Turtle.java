package io.papermc.paper.api.entity;

import io.papermc.paper.api.location.Location;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a turtle.
 */
public interface Turtle extends Animals {

    /**
     * Gets whether the turtle has an egg
     *
     * @return Whether the turtle has an egg
     */
    boolean hasEgg();

    /**
     * Gets whether the turtle is laying an egg
     *
     * @return Whether the turtle is laying an egg
     */
    boolean isLayingEgg();

    // Paper start
    /**
     * Get the turtle's home location
     *
     * @return Home location
     */
    @NonNull
    Location getHome();

    /**
     * Set the turtle's home location
     *
     * @param location Home location
     */
    void setHome(@NonNull Location location);

    /**
     * Check if turtle is currently pathfinding to it's home
     *
     * @return True if going home
     */
    boolean isGoingHome();

    /**
     * Get if turtle is digging to lay eggs
     *
     * @return True if digging
     */
    boolean isDigging();

    /**
     * Set if turtle is carrying egg
     *
     * @param hasEgg True if carrying egg
     */
    void setHasEgg(boolean hasEgg);
    // Paper end
}

