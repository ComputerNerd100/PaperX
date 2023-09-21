package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.LivingEntity;
import io.papermc.paper.api.event.util.Param;

import java.util.Set;

/**
 * Called when a splash water potion "splashes" and affects
 * different entities in different ways.
 */
public interface WaterBottleSplashEvent extends PotionSplashEvent {

    /**
     * Get a mutable collection of entities
     * that will be rehydrated by this.
     * <p>
     * As of 1.19.3 this only will contain Axolotls as they
     * are the only entity type that can be rehydrated, but
     * it may change in the future.
     *
     * @return the entities
     */
    @Param(5)
    Set<LivingEntity> rehydrate();

    /**
     * Get a mutable collection of entities that will
     * be extinguished as a result of this event.
     *
     * @return entities to be extinguished
     */
    @Param(6)
    Set<LivingEntity> extinguish();
}
