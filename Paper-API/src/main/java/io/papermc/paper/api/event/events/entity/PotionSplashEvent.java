package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.LivingEntity;
import io.papermc.paper.api.entity.ThrownPotion;
import io.papermc.paper.api.event.util.Param;

import java.util.Map;

/**
 * Called when a splash potion hits an area
 */
public interface PotionSplashEvent extends ProjectileHitEvent {

    /**
     * Gets the potion which caused this event
     *
     * @return The thrown potion entity
     */
    default ThrownPotion potion() {
        return (ThrownPotion) projectile();
    }

    /**
     * Retrieves a list of all effected entities
     *
     * @return A fresh copy of the affected entity list
     */
    @Param(4)
    Map<LivingEntity, Double> affectedEntities();
}
