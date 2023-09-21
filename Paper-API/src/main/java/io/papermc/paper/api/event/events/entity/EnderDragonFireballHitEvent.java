package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.AreaEffectCloud;
import io.papermc.paper.api.entity.DragonFireball;
import io.papermc.paper.api.entity.LivingEntity;
import io.papermc.paper.api.event.util.Param;

import java.util.Collection;

/**
 * Fired when a DragonFireball collides with a block/entity and spawns an AreaEffectCloud
 */
public interface EnderDragonFireballHitEvent extends CancellableEntityEvent {

    /**
     * The fireball involved in this event
     */
    default DragonFireball fireball() {
        return (DragonFireball) this.entity();
    }

    /**
     * The living entities hit by fireball
     *
     * May be null if no entities were hit
     *
     * @return the targets
     */
    @Param(1)
    Collection<LivingEntity> targets();

    /**
     * @return The area effect cloud spawned in this collision
     */
    @Param(2)
    AreaEffectCloud areaEffectCloud();
}
