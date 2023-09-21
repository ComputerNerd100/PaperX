package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Item;
import io.papermc.paper.api.event.util.Param;

/**
 * Thrown when an entity creates an item drop.
 */
public interface EntityDropItemEvent extends CancellableEntityEvent {

    /**
     * Gets the Item created by the entity
     *
     * @return Item created by the entity
     */
    @Param(1)
    Item drop();
}
