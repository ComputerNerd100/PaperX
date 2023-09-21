package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Called when a player swap items between main hand and off hand using the
 * hotkey.
 */
public interface PlayerSwapHandItemsEvent extends CancellablePlayerEvent {

    /**
     * Gets the item switched to the main hand.
     *
     * @return item in the main hand
     */
    @Param(1)
    ItemStack mainHandItem();

    /**
     * Gets the item switched to the off hand.
     *
     * @return item in the off hand
     */
    @Param(2)
    ItemStack offHandItem();
}
