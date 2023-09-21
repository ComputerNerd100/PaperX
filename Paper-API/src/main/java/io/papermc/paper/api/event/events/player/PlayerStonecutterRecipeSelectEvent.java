package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.StonecutterInventory;
import io.papermc.paper.api.inventory.recipe.StonecuttingRecipe;

/**
 * Called when a player selects a recipe in a stonecutter.
 */
public interface PlayerStonecutterRecipeSelectEvent extends CancellablePlayerEvent {

    /**
     * Gets the stonecutter inventory.
     * @return the stonecutter inventory
     */
    @Param(1)
    StonecutterInventory stonecutterInventory();

    /**
     * Gets the stonecutting recipe.
     * @return the stonecutting recipe
     */
    @Param(2)
    StonecuttingRecipe stonecuttingRecipe();
}
