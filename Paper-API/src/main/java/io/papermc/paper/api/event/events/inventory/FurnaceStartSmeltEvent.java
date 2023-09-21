package io.papermc.paper.api.event.events.inventory;

import io.papermc.paper.api.event.events.block.InventoryBlockStartEvent;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.recipe.CookingRecipe;

/**
 * Called when a Furnace starts smelting.
 */
public interface FurnaceStartSmeltEvent extends InventoryBlockStartEvent {

    /**
     * Gets the FurnaceRecipe associated with this event
     *
     * @return the FurnaceRecipe being cooked
     */
    @Param(1)
    CookingRecipe<?> recipe();

    /**
     * Gets the total cook time associated with this event
     *
     * @return the total cook time
     */
    @Param(2)
    int totalCookTime();
}
