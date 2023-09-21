package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

public interface BlockPreDispenseEvent extends CancellableBlockEvent {

    /**
     * Gets the {@link ItemStack} to be dispensed.
     *
     * @return The item to be dispensed
     */
    @Param(1)
    ItemStack itemStack();

    /**
     * Gets the inventory slot of the dispenser to dispense from.
     *
     * @return The inventory slot
     */
    @Param(2)
    int slot();

}
