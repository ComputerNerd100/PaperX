package io.papermc.paper.api.entity;

import io.papermc.paper.api.block.color.DyeColor;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Entities that can have their collars colored.
 */
public interface CollarColorable extends LivingEntity {

    /**
     * Get the collar color of this entity
     *
     * @return the color of the collar
     */
    @NonNull DyeColor getCollarColor();

    /**
     * Set the collar color of this entity
     *
     * @param color the color to apply
     */
    void setCollarColor(@NonNull DyeColor color);
}

