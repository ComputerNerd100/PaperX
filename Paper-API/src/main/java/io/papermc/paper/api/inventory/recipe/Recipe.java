package io.papermc.paper.api.inventory.recipe;

import io.papermc.paper.api.inventory.ItemStack;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents some type of crafting recipe.
 */
public interface Recipe {

    /**
     * Get the result of this recipe.
     *
     * @return The result stack
     */
    @NonNull
    ItemStack getResult();
}