package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.inventory.recipe.CookingRecipe;

/**
 * Called when an ItemStack is successfully cooked in a block.
 */
public interface BlockCookEvent extends CancellableBlockEvent {

    /**
     * Gets the smelted ItemStack for this event
     *
     * @return smelting source ItemStack
     */
    @Param(1)
    ItemStack source();

    /**
     * Gets the resultant ItemStack for this event
     *
     * @return smelting result ItemStack
     */
    @Param(2)
    ItemStack result();

    /**
     * Gets the cooking recipe associated with this event.
     *
     * @return the recipe
     */
    @Param(3)
    CookingRecipe<?> recipe();
}
