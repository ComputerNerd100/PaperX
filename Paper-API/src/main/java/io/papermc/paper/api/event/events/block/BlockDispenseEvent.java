package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.util.vector.Vector;

/**
 * Called when an item is dispensed from a block.
 * <p>
 * If a Block Dispense event is cancelled, the block will not dispense the
 * item.
 */
public interface BlockDispenseEvent extends CancellableBlockEvent {

    /**
     * Gets the item that is being dispensed.
     *
     * @return An ItemStack for the item being dispensed
     */
    @Param(1)
    ItemStack dispensedItem();

    /**
     * Gets the velocity in meters per tick.
     *
     * @return A Vector for the dispensed item's velocity
     */
    @Param(2)
    Vector velocity();

}
