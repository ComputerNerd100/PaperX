package io.papermc.paper.api.event.events.inventory;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.recipe.Recipe;

/**
 * Called when the recipe of an Item is completed inside a crafting matrix.
 */
public interface CraftItemEvent extends InventoryClickEvent {

    /**
     * @return A copy of the current recipe on the crafting matrix.
     */
    @Param(9)
    Recipe recipe();
}
