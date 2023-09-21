package io.papermc.paper.api.event.events.inventory;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Called when an item is put in an inventory containing a result slot
 */
public interface PrepareResultEvent extends InventoryResultEvent {

    /**
     * Get result item, may be null.
     *
     * @return result item
     */
    @Param(0)
    ItemStack eventResult();
}
