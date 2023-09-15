package io.papermc.paper.api.entity;

import io.papermc.paper.api.util.vector.Vector;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a vehicle entity.
 */
public interface Vehicle extends Entity {

    /**
     * Gets the vehicle's velocity.
     *
     * @return velocity vector
     */
    @Override
    @NonNull Vector getVelocity();

    /**
     * Sets the vehicle's velocity in meters per tick.
     *
     * @param vel velocity vector
     */
    @Override
    void setVelocity(@NonNull Vector vel);
}

