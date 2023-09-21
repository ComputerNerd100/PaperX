package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Fired when a player's item breaks (such as a shovel or flint and steel).
 * <p>
 * After this event, the item's amount will be set to {@code item amount - 1}
 * and its durability will be reset to 0.
 */
public interface PlayerItemBreakEvent extends PlayerResultEvent {

    /**
     * Gets the item that broke
     *
     * @return The broken item
     */
    @Param(0)
    ItemStack brokenItem();
}
