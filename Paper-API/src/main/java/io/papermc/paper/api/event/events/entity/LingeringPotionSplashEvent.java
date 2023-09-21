package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.AreaEffectCloud;
import io.papermc.paper.api.entity.ThrownPotion;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a splash potion hits an area
 */
public interface LingeringPotionSplashEvent extends ProjectileHitEvent {
    default ThrownPotion potion() {
        return (ThrownPotion) projectile();
    }

    /**
     * Gets the AreaEffectCloud spawned
     *
     * @return The spawned AreaEffectCloud
     */
    @Param(4)
    AreaEffectCloud entity();
}
