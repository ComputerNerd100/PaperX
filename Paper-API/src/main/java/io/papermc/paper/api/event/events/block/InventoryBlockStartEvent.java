package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.event.events.inventory.FurnaceStartSmeltEvent;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Used when:
 * <ul>
 * <li>A Furnace starts smelting {@link FurnaceStartSmeltEvent}</li>
 * <li>A Brewing-Stand starts brewing {@link BrewingStartEvent}</li>
 * <li>A Campfire starts cooking {@link CampfireStartEvent}</li>
 * </ul>
 *
 * @apiNote draft API
 */
public interface InventoryBlockStartEvent extends BlockResultEvent {

    /**
     * Gets the source ItemStack for this event.
     *
     * @return the source ItemStack
     */
    @Param(0)
    ItemStack source();

}
