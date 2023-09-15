package io.papermc.paper.api.entity;

import io.papermc.paper.api.block.color.DyeColor;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a Wolf
 */
public interface Wolf extends Tameable, Sittable, CollarColorable {

    /**
     * Checks if this wolf is angry
     *
     * @return Anger true if angry
     */
    boolean isAngry();

    /**
     * Sets the anger of this wolf.
     * <p>
     * An angry wolf can not be fed or tamed.
     *
     * @param angry true if angry
     * @see #setTarget(LivingEntity)
     */
    void setAngry(boolean angry);

    /**
     * Get the collar color of this wolf
     *
     * @return the color of the collar
     */
    @NonNull
    @Override
    DyeColor getCollarColor();

    /**
     * Set the collar color of this wolf
     *
     * @param color the color to apply
     */
    @Override
    void setCollarColor(@NonNull DyeColor color);

    /**
     * Gets whether the wolf is wet
     *
     * @return Whether the wolf is wet
     */
    boolean isWet();

    /**
     * Gets the wolf's tail angle in radians
     *
     * @return The angle of the wolf's tail in radians
     */
    float getTailAngle();

    /**
     * Gets if the wolf is interested
     *
     * @return Whether the wolf is interested
     */
    boolean isInterested();

    /**
     * Set wolf to be interested
     *
     * @param interested Whether the wolf is interested
     */
    void setInterested(boolean interested);
}

