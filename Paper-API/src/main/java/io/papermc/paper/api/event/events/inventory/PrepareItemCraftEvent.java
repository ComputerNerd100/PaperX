package io.papermc.paper.api.event.events.inventory;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.CraftingInventory;
import io.papermc.paper.api.inventory.recipe.Recipe;

/**
 * Called when an item is put in a slot for crafting.
 */
public interface PrepareItemCraftEvent extends InventoryResultEvent {

    /**
     * Check if this event was triggered by a tool repair operation rather
     * than a crafting recipe.
     *
     * @return True if this is a repair.
     */
    @Param(0)
    boolean repair();

    /**
     * @return The crafting inventory on which the recipe was formed.
     */
    @Param(1)
    CraftingInventory matrix();

    /**
     * Get the recipe that has been formed. If this event was triggered by a
     * tool repair, this will be a temporary shapeless recipe representing the
     * repair.
     *
     * @return The recipe being crafted.
     */
    default Recipe recipe() {
        return matrix().getRecipe();
    }
}
