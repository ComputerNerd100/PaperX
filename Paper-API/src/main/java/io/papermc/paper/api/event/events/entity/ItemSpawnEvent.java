package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Item;

/**
 * Called when an item is spawned into a world
 */
public interface ItemSpawnEvent extends EntitySpawnEvent {
    default Item item() {
        return (Item) entity();
    }
}
