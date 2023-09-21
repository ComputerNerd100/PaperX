package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.LivingEntity;
import io.papermc.paper.api.event.util.Param;

/**
 * Fired when an Entity is knocked back by the hit of another Entity. The acceleration
 * vector can be modified. If this event is cancelled, the entity is not knocked back.
 *
 */
public interface EntityKnockbackByEntityEvent extends EntityPushedByEntityAttackEvent {

    /**
     * @return the entity which was knocked back
     */
    default LivingEntity livingEntity() {
        return (LivingEntity) this.entity();
    }

    /**
     * @return the original knockback strength.
     */
    @Param(3)
    float knockbackStrength();
}
