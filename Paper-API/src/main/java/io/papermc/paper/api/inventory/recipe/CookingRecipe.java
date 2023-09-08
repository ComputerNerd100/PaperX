package io.papermc.paper.api.inventory.recipe;

import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.material.Material;
import io.papermc.paper.api.namespace.Keyed;
import io.papermc.paper.api.namespace.NamespacedKey;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface CookingRecipe<T extends CookingRecipe> extends Recipe, Keyed {

    /**
     * Sets the input of this cooking recipe.
     *
     * @param input The input material.
     * @return The changed recipe, so you can chain calls.
     */
    @NonNull CookingRecipe setInput(@NonNull Material input);

    /**
     * Sets the input of this cooking recipe.
     *
     * @param input The input choice.
     * @return The changed recipe, so you can chain calls.
     */
    @NonNull T setInputChoice(@NonNull RecipeChoice input);

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

    /**
     * Sets the experience given by this recipe.
     *
     * @param experience the experience level
     */
    void setExperience(float experience);

    /**
     * Get the experience given by this recipe.
     *
     * @return experience level
     */
    float getExperience();

    /**
     * Set the cooking time for this recipe in ticks.
     *
     * @param cookingTime new cooking time
     */
    void setCookingTime(int cookingTime);

    /**
     * Get the cooking time for this recipe in ticks.
     *
     * @return cooking time
     */
    int getCookingTime();

    @Override
    @NonNull NamespacedKey getKey();

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
     * Defaults to {@link CookingBookCategory#MISC} if not set.
     *
     * @return recipe book category
     */
    @NonNull CookingBookCategory getCategory();

    /**
     * Sets the category which this recipe will appear in the recipe book under.
     *
     * Defaults to {@link CookingBookCategory#MISC} if not set.
     *
     * @param category recipe book category
     */
    void setCategory(@NonNull CookingBookCategory category);
}
