package io.papermc.paper.api.event.events.inventory;

import io.papermc.paper.api.entity.Item;
import io.papermc.paper.api.event.Event;
import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.Inventory;

/**
 * Called when a hopper or hopper minecart picks up a dropped item.
 */
public interface InventoryPickupItemEvent extends Event, Cancellable {

    /**
     * Gets the Inventory that picked up the item
     *
     * @return Inventory
     */
    @Param(0)
    Inventory inventory();

    /**
     * Gets the Item entity that was picked up
     *
     * @return Item
     */
    @Param(1)
    Item item();
}
