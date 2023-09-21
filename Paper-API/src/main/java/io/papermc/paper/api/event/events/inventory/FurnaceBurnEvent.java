package io.papermc.paper.api.event.events.inventory;

import io.papermc.paper.api.event.events.block.CancellableBlockEvent;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Called when an ItemStack is successfully burned as fuel in a furnace.
 */
public interface FurnaceBurnEvent extends CancellableBlockEvent {

    /**
     * Gets the fuel ItemStack for this event
     *
     * @return the fuel ItemStack
     */
    @Param(1)
    ItemStack fuel();

    /**
     * Gets the burn time for this fuel
     *
     * @return the burn time for this fuel
     */
    @Param(2)
    int burnTime();

    /**
     * Gets whether the furnace's fuel is burning or not.
     *
     * @return whether the furnace's fuel is burning or not.
     */
    @Param(3)
    boolean burning();

    /**
     * Gets whether the furnace's fuel will be consumed or not.
     *
     * @return whether the furnace's fuel will be consumed
     */
    @Param(4)
    boolean consumeFuel();
}
