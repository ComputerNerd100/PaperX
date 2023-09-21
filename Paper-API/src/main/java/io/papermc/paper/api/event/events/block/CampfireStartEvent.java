package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.recipe.CampfireRecipe;

/**
 * Called when a Campfire starts to cook.
 */
public interface CampfireStartEvent extends InventoryBlockStartEvent {

    /**
     * Gets the total cook time associated with this event.
     *
     * @return the total cook time
     */
    @Param(1)
    int cookingTime();

    /**
     * Gets the CampfireRecipe associated with this event.
     *
     * @return the CampfireRecipe being cooked
     */
    @Param(2)
    CampfireRecipe recipe();

}
