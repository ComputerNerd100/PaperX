package io.papermc.paper.api.inventory.recipe;

import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.material.Material;
import io.papermc.paper.api.namespace.Keyed;
import io.papermc.paper.api.namespace.NamespacedKey;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a Stonecutting recipe.
 */
public interface StonecuttingRecipe extends Recipe, Keyed {

    /**
     * Sets the input of this Stonecutting recipe.
     *
     * @param input The input material.
     * @return The changed recipe, so you can chain calls.
     */
    @NonNull StonecuttingRecipe setInput(@NonNull Material input);

    /**
     * Sets the input of this Stonecutting recipe.
     *
     * @param input The input choice.
     * @return The changed recipe, so you can chain calls.
     */
    @NonNull StonecuttingRecipe setInputChoice(@NonNull RecipeChoice input);

    /**
     * Get the input choice.
     *
     * @return The input choice.
     */
    @NonNull RecipeChoice getInputChoice();

    /**
     * Get the result of this recipe.
     *
     * @return The resulting stack.
     */
    @Override
    @NonNull ItemStack getResult();

    @Override
    @NotNull NamespacedKey getKey();

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
}
