package io.papermc.paper.api.entity;

import io.papermc.paper.api.math.Position;
import org.jetbrains.annotations.ApiStatus;

/**
 * Represents what part of the entity should be used when determining where to face a position/entity.
 *
 * @see Player#lookAt(Position, LookAnchor)
 * @see Player#lookAt(Entity, LookAnchor, LookAnchor)
 */
@ApiStatus.Experimental
public enum LookAnchor {
    /**
     * Represents the entity's feet.
     * @see LivingEntity#getLocation()
     */
    FEET,
    /**
     * Represents the entity's eyes.
     * @see LivingEntity#getEyeLocation()
     */
    EYES
}
