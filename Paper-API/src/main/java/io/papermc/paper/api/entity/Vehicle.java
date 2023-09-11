package io.papermc.paper.api.entity;

import io.papermc.paper.api.util.vector.Vector;
import org.jetbrains.annotations.NotNull;

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
    @NotNull Vector getVelocity();

    /**
     * Sets the vehicle's velocity in meters per tick.
     *
     * @param vel velocity vector
     */
    @Override
    void setVelocity(@NotNull Vector vel);
}

