package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.event.events.inventory.InventoryMoveItemEvent;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Called when an item is about to be composted by a hopper.
 * To prevent hoppers from moving items into composters, cancel the {@link InventoryMoveItemEvent}.
 */
public interface ComposeItemEvent extends BlockResultEvent {

    /**
     * Gets the item that was used on the composter.
     *
     * @return the item
     */
    @Param(0)
    ItemStack item();

    /**
     * Gets whether the composter will rise a level.
     *
     * @return true if successful
     */
    @Param(1)
    boolean willRaiseLevel();

}
