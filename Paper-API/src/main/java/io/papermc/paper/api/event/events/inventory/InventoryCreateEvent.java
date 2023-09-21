package io.papermc.paper.api.event.events.inventory;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * This event is called when a player in creative mode puts down or picks up
 * an item in their inventory / hotbar and when they drop items from their
 * Inventory while in creative mode.
 */
public interface InventoryCreateEvent extends InventoryClickEvent {

    @Param(9)
    ItemStack cursor();
}
