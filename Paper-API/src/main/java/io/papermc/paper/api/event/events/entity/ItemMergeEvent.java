package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Item;
import io.papermc.paper.api.event.util.Param;

public interface ItemMergeEvent extends CancellableEntityEvent {
    default Item item() {
        return (Item) entity();
    }

    /**
     * Gets the Item entity the main Item is being merged into.
     *
     * @return The Item being merged with
     */
    @Param(1)
    Item target();
}
