package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Called when a player places an item in or takes an item out of a flowerpot.
 */
public interface PlayerFlowerPotManipulateEvent extends CancellablePlayerEvent {

    /**
     * Gets the flowerpot that is involved in this event.
     *
     * @return the flowerpot that is involved with this event
     */
    @Param(1)
    Block flowerpot();

    /**
     * Gets the item being placed, or taken from, the flower pot.
     * Check if placing with {@link #placing()}.
     *
     * @return the item placed, or taken from, the flowerpot
     */
    @Param(2)
    ItemStack item();

    /**
     * Gets if the item is being placed into the flowerpot.
     *
     * @return if the item is being placed into the flowerpot
     */
    @Param(3)
    boolean placing();
}
