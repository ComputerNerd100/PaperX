package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when an entity causes another entity to combust.
 */
public interface EntityCombustByEntityEvent extends EntityCombustEvent {

    /**
     * Get the entity that caused the combustion event.
     *
     * @return the Entity that set the combustee alight.
     */
    @Param(2)
    Entity combuster();
}
