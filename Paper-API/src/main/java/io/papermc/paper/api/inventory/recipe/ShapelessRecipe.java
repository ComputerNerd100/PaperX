package io.papermc.paper.api.inventory.recipe;

import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.material.Material;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

public interface ShapelessRecipe extends CraftingRecipe {

    /**
     * Adds the specified ingredient.
     *
     * @param ingredient The ingredient to add.
     * @return The changed recipe, so you can chain calls.
     */
    @NonNull ShapelessRecipe addIngredient(@NonNull Material ingredient);

    /**
     * Adds the specified ingredient.
     *
     * @param ingredient The ingredient to add.
     * @param rawdata The data value, or -1 to allow any data value.
     * @return The changed recipe, so you can chain calls.
     * @deprecated Magic value
     */
    @Deprecated
    @NonNull ShapelessRecipe addIngredient(@NonNull Material ingredient, int rawdata);

    /**
     * Adds multiples of the specified ingredient.
     *
     * @param count How many to add (can't be more than 9!)
     * @param ingredient The ingredient to add.
     * @return The changed recipe, so you can chain calls.
     */
    @NonNull ShapelessRecipe addIngredient(int count, @NonNull Material ingredient);

    /**
     * Adds multiples of the specified ingredient.
     *
     * @param count How many to add (can't be more than 9!)
     * @param ingredient The ingredient to add.
     * @param rawdata The data value, or -1 to allow any data value.
     * @return The changed recipe, so you can chain calls.
     * @deprecated Magic value
     */
    @Deprecated
    @NonNull ShapelessRecipe addIngredient(int count, @NonNull Material ingredient, int rawdata);
    @NonNull ShapelessRecipe addIngredient(@NonNull RecipeChoice ingredient);
    @NonNull ShapedRecipe addIngredient(@NonNull ItemStack item);
    @NonNull ShapelessRecipe addIngredient(int count, @NonNull ItemStack item);
    @NonNull ShapelessRecipe removeIngredient(@NonNull ItemStack ingredient);
    @NonNull ShapelessRecipe removeIngredient(int count, @NonNull ItemStack ingredient);

    /**
     * Removes an ingredient from the list.
     *
     * @param ingredient The ingredient to remove
     * @return The changed recipe.
     */
    @NonNull ShapelessRecipe removeIngredient(@NonNull RecipeChoice ingredient);

    /**
     * Removes an ingredient from the list. If the ingredient occurs multiple
     * times, only one instance of it is removed. Only removes exact matches,
     * with a data value of 0.
     *
     * @param ingredient The ingredient to remove
     * @return The changed recipe.
     */
    @NonNull ShapelessRecipe removeIngredient(@NonNull Material ingredient);

    /**
     * Removes multiple instances of an ingredient from the list. If there are
     * fewer instances than specified, all will be removed. Only removes exact
     * matches, with a data value of 0.
     *
     * @param count The number of copies to remove.
     * @param ingredient The ingredient to remove
     * @return The changed recipe.
     */
    @NonNull ShapelessRecipe removeIngredient(int count, @NonNull Material ingredient);

    /**
     * Removes an ingredient from the list. If the ingredient occurs multiple
     * times, only one instance of it is removed. If the data value is -1,
     * only ingredients with a -1 data value will be removed.
     *
     * @param ingredient The ingredient to remove
     * @param rawdata The data value;
     * @return The changed recipe.
     * @deprecated Magic value
     */
    @Deprecated
    @NonNull ShapelessRecipe removeIngredient(@NonNull Material ingredient, int rawdata);

    /**
     * Removes multiple instances of an ingredient from the list. If there are
     * less instances then specified, all will be removed. If the data value
     * is -1, only ingredients with a -1 data value will be removed.
     *
     * @param count The number of copies to remove.
     * @param ingredient The ingredient to remove.
     * @param rawdata The data value.
     * @return The changed recipe.
     * @deprecated Magic value
     */
    @Deprecated
    @NonNull ShapelessRecipe removeIngredient(int count, @NonNull Material ingredient, int rawdata);
    @NonNull List<RecipeChoice> getChoiceList();
}
