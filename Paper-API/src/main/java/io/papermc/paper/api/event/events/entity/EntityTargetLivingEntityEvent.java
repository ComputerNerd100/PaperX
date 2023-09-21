package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.LivingEntity;

/**
 * Called when an Entity targets a {@link LivingEntity} and can only target
 * LivingEntity's.
 */
public interface EntityTargetLivingEntityEvent extends EntityTargetEvent {

    /**
     * Get the target of this event.
     * @return the target of this event
     */
    default LivingEntity livingTarget() {
    return (LivingEntity) target();
    }
}
