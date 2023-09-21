package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.entity.LightningStrike;
import io.papermc.paper.api.entity.LivingEntity;

/**
 * Called when an {@link Entity} breaks a door
 * <p>
 * Cancelling the event will cause the event to be delayed
 */
public interface EntityBreakDoorEvent extends EntityChangeBlockEvent {
    default LivingEntity livingEntity() {
        return (LivingEntity) entity();
    }
}
