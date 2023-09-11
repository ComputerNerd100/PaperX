package io.papermc.paper.api.entity;

import io.papermc.paper.api.block.BlockFace;
import io.papermc.paper.api.util.vector.Vector;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface ShulkerBullet extends Projectile {

    /**
     * Retrieve the target of this bullet.
     *
     * @return the targeted entity
     */
    @Nullable
    Entity getTarget();

    /**
     * Sets the target of this bullet
     *
     * @param target the entity to target
     */
    void setTarget(@Nullable Entity target);
    
    /**
     * Gets the relative offset that this shulker bullet should move towards,
     * note that this will change each tick as the skulker bullet approaches the target.
     *
     * @return target delta offset
     */
    @NonNull
    Vector getTargetDelta();


    /**
     * Sets the relative offset that this shulker bullet should move towards,
     * note that this will change each tick as the skulker bullet approaches the target.
     * This is usually relative towards their target.
     *
     * @param vector target
     */
    void setTargetDelta(@NonNull Vector vector);

    /**
     * Gets the current movement direction.
     * This is used to determine the next movement direction to ensure
     * that the bullet does not move in the same direction.
     *
     * @return null or their current direction
     */
    @Nullable
    BlockFace getCurrentMovementDirection();

    /**
     * Set the current movement direction.
     * This is used to determine the next movement direction to ensure
     * that the bullet does not move in the same direction.
     *
     * Set to null to simply pick a random direction.
     *
     * @param movementDirection null or a direction
     */
    void setCurrentMovementDirection(@Nullable BlockFace movementDirection);

    /**
     * Gets how many ticks this shulker bullet
     * will attempt to move in its current direction.
     *
     * @return number of steps
     */
    int getFlightSteps();

    /**
     * Sets how many ticks this shulker bullet
     * will attempt to move in its current direction.
     *
     * @param steps number of steps
     */
    void setFlightSteps(int steps);
}

