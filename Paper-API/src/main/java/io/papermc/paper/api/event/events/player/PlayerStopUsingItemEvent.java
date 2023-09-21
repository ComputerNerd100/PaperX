package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Called when the server detects a player stopping using an item.
 * Examples of this are letting go of the interact button when holding a bow, an edible item, or a spyglass.
 */
public interface PlayerStopUsingItemEvent extends PlayerResultEvent {

    /**
     * Gets the exact item the player is releasing
     *
     * @return ItemStack the exact item the player released
     */
    @Param(0)
    ItemStack item();

    /**
     * Gets the number of ticks the item was held for
     *
     * @return int the number of ticks the item was held for
     */
    @Param(1)
    int ticksHeldFor();
}
