package io.papermc.paper.api.event.events.hanging;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;

/**
 * Triggered when a hanging entity is removed by an entity
 */
public interface HangingBreakByEntityEvent extends HangingBreakEvent {

    /**
     * Gets the entity that removed the hanging entity.
     * May be null, for example when broken by an explosion.
     *
     * @return the entity that removed the hanging entity
     */
    @Param(2)
    Entity remover();
}
