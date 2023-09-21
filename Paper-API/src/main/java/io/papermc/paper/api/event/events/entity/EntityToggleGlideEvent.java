package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.LivingEntity;
import io.papermc.paper.api.event.util.Param;

/**
 * Sent when an entity's gliding status is toggled with an Elytra.
 * Examples of when this event would be called:
 * <ul>
 *     <li>Player presses the jump key while in midair and using an Elytra</li>
 *     <li>Player lands on ground while they are gliding (with an Elytra)</li>
 * </ul>
 * This can be visually estimated by the animation in which a player turns horizontal.
 */
public interface EntityToggleGlideEvent extends CancellableEntityEvent {
    default LivingEntity livingEntity() {
        return (LivingEntity) entity();
    }

    /**
     * Returns true if the entity is now gliding or
     * false if the entity stops gliding.
     *
     * @return new gliding state
     */
    @Param(1)
    boolean gliding();
}
