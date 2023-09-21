package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.AnimalTamer;
import io.papermc.paper.api.entity.LivingEntity;
import io.papermc.paper.api.event.util.Param;

/**
 * Thrown when a LivingEntity is tamed
 */
public interface EntityTameEvent extends CancellableEntityEvent {
    default LivingEntity livingEntity() {
        return (LivingEntity) entity();
    }

    /**
     * Gets the owning AnimalTamer
     *
     * @return the owning AnimalTamer
     */
    @Param(1)
    AnimalTamer owner();
}
