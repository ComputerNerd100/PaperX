package io.papermc.paper.api.inventory.recipe;

import com.google.common.base.Preconditions;
import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.material.Material;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Map;

/**
 * Represents a shaped (ie normal) crafting recipe.
 */
public interface ShapedRecipe extends CraftingRecipe {

    /**
     * Set the shape of this recipe to the specified rows. Each character
     * represents a different ingredient; exactly what each character
     * represents is set separately. The first row supplied corresponds with
     * the upper most part of the recipe on the workbench e.g. if all three
     * rows are supplies the first string represents the top row on the
     * workbench.
     *
     * @param shape The rows of the recipe (up to 3 rows).
     * @return The changed recipe, so you can chain calls.
     */
    @NonNull ShapedRecipe shape(@NonNull final String... shape);

    /**
     * Sets the material that a character in the recipe shape refers to.
     * <p>
     * Note that before an ingredient can be set, the recipe's shape must be defined
     * with {@link #shape(String...)}.
     *
     * @param key The character that represents the ingredient in the shape.
     * @param ingredient The ingredient.
     * @return The changed recipe, so you can chain calls.
     * @throws IllegalArgumentException if the {@code key} does not appear in the shape.
     */
    @NonNull ShapedRecipe setIngredient(char key, @NonNull Material ingredient);

    /**
     * Sets the material that a character in the recipe shape refers to.
     * <p>
     * Note that before an ingredient can be set, the recipe's shape must be defined
     * with {@link #shape(String...)}.
     *
     * @param key The character that represents the ingredient in the shape.
     * @param ingredient The ingredient.
     * @param raw The raw material data as an integer.
     * @return The changed recipe, so you can chain calls.
     * @throws IllegalArgumentException if the {@code key} does not appear in the shape.
     * @deprecated Magic value
     */
    @Deprecated
    @NonNull
    ShapedRecipe setIngredient(char key, @NonNull Material ingredient, int raw);

    /**
     * Sets the {@link RecipeChoice} that a character in the recipe shape refers to.
     * <p>
     * Note that before an ingredient can be set, the recipe's shape must be defined
     * with {@link #shape(String...)}.
     *
     * @param key The character that represents the ingredient in the shape.
     * @param ingredient The ingredient.
     * @return The changed recipe, so you can chain calls.
     * @throws IllegalArgumentException if the {@code key} does not appear in the shape.
     */
    @NonNull ShapedRecipe setIngredient(char key, @NonNull RecipeChoice ingredient);
    @NonNull ShapedRecipe setIngredient(char key, @NonNull ItemStack item);

    /**
     * Get a copy of the choice map.
     *
     * @return The mapping of character to ingredients.
     */
    @NonNull Map<Character, RecipeChoice> getChoiceMap();

    /**
     * Get the shape.
     *
     * @return The recipe's shape.
     * @throws NullPointerException when not set yet
     */
    @NonNull String[] getShape();

}
