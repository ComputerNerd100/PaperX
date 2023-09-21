package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Item;
import io.papermc.paper.api.event.util.Param;

/**
 * Thrown when a player drops an item from their inventory
 */
public interface PlayerDropItemEvent extends CancellablePlayerEvent {

    /**
     * Gets the ItemDrop created by the player
     *
     * @return ItemDrop created by the player
     */
    @Param(1)
    Item drop();
}
