package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.LivingEntity;

/**
 * Sent when an entity's swimming status is toggled.
 */
public interface EntityToggleSwimEvent extends CancellableEntityEvent {
    default LivingEntity livingEntity() {
        return (LivingEntity) entity();
    }

    /**
     * Returns true if the entity is now swims or
     * false if the entity stops swimming.
     *
     * @return new swimming state
     */
    boolean swimming();
}
