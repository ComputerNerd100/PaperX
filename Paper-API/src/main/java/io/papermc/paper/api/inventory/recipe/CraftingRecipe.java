package io.papermc.paper.api.inventory.recipe;

import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.namespace.Keyed;
import io.papermc.paper.api.namespace.NamespacedKey;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface CraftingRecipe extends Recipe, Keyed {

    @Override
    @NonNull NamespacedKey getKey();

    /**
     * Get the result of this recipe.
     *
     * @return The result stack.
     */
    @Override
    @NonNull ItemStack getResult();

    /**
     * Get the group of this recipe. Recipes with the same group may be grouped
     * together when displayed in the client.
     *
     * @return recipe group. An empty string denotes no group. May not be null.
     */
    @NonNull String getGroup();

    /**
     * Set the group of this recipe. Recipes with the same group may be grouped
     * together when displayed in the client.
     *
     * @param group recipe group. An empty string denotes no group. May not be
     * null.
     */
    void setGroup(@NonNull String group);

    /**
     * Gets the category which this recipe will appear in the recipe book under.
     *
     * Defaults to {@link CraftingBookCategory#MISC} if not set.
     *
     * @return recipe book category
     */
    @NonNull CraftingBookCategory getCategory();

    /**
     * Sets the category which this recipe will appear in the recipe book under.
     *
     * Defaults to {@link CraftingBookCategory#MISC} if not set.
     *
     * @param category recipe book category
     */
    void setCategory(@NonNull CraftingBookCategory category);
}
