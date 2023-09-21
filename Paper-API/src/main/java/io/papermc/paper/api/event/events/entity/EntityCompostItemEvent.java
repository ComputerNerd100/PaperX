package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.events.block.ComposeItemEvent;
import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when an item is about to be composted by an entity.
 */
public interface EntityCompostItemEvent extends ComposeItemEvent, Cancellable {

    /**
     * Gets the entity that interacted with the composter.
     *
     * @return the entity that composted an item.
     */
    @Param(2)
    Entity entity();
}
