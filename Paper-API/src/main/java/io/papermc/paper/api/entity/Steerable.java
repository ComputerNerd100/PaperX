package io.papermc.paper.api.entity;

import io.papermc.paper.api.material.Material;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents an entity which may be saddled, ridden and steered using an item.
 */
public interface Steerable extends Animals {

    /**
     * Check if the pig has a saddle.
     *
     * @return if the pig has been saddled.
     */
    boolean hasSaddle();

    /**
     * Sets if the pig has a saddle or not
     *
     * @param saddled set if the pig has a saddle or not.
     */
    void setSaddle(boolean saddled);

    /**
     * Get the time in ticks this entity's movement is being increased.
     *
     * Movement speed is often increased as a result of using the
     * {@link #getSteerMaterial()}.
     *
     * @return the current boost ticks
     */
    int getBoostTicks();

    /**
     * Set the time in ticks this entity's movement will be increased.
     *
     * This will reset the current boost ticks to 0
     * ({@link #getCurrentBoostTicks()}).
     *
     * @param ticks the boost time
     */
    void setBoostTicks(int ticks);

    /**
     * Get the time in ticks this entity's movement has been increased as of the
     * most recent boost.
     *
     * Current boost ticks will never be {@literal >} {@link #getBoostTicks()}.
     *
     * @return the current boost ticks
     */
    int getCurrentBoostTicks();

    /**
     * Set the time in ticks this entity's movement has been increased relative
     * to the most recent boost.
     *
     * @param ticks the current boost ticks. Must be {@literal >=} 0 and {@literal <=}
     * {@link #getBoostTicks()}
     */
    void setCurrentBoostTicks(int ticks);

    /**
     * Get the material used to steer this entity when ridden by a player.
     *
     * @return the lure material
     */
    @NonNull Material getSteerMaterial();
}

