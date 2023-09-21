package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.LivingEntity;

/**
 * Called when an entity jumps
 * <p>
 * Cancelling the event will stop the entity from jumping
 */
public interface EntityJumpEvent extends CancellableEntityEvent {

    /**
     * Returns the involved entity
     * @return the entity that jumped
     */
    default LivingEntity livingEntity() {
        return (LivingEntity) this.entity();
    }
}
