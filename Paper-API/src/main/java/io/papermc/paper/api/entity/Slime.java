package io.papermc.paper.api.entity;

import io.papermc.paper.api.attribute.Attribute;

/**
 * Represents a Slime.
 */
public interface Slime extends Mob, Enemy {

    /**
     * @return The size of the slime
     */
    int getSize();

    /**
     * Setting the size of the slime (regardless of previous size)
     * will set the following attributes:
     * <ul>
     *     <li>{@link Attribute#GENERIC_MAX_HEALTH}</li>
     *     <li>{@link Attribute#GENERIC_MOVEMENT_SPEED}</li>
     *     <li>{@link Attribute#GENERIC_ATTACK_DAMAGE}</li>
     * </ul>
     * to their per-size defaults and heal the
     * slime to its max health (assuming it's alive).
     *
     * @param sz The new size of the slime.
     */
    void setSize(int sz);

    /**
     * Get whether this slime can randomly wander/jump around on its own
     *
     * @return true if can wander
     */
    boolean canWander();

    /**
     * Set whether this slime can randomly wander/jump around on its own
     *
     * @param canWander true if can wander
     */
    void setWander(boolean canWander);
}
