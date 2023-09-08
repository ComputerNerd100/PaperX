package io.papermc.paper.api.inventory.recipe;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a smithing transform recipe.
 */
public interface SmithingTransformRecipe extends SmithingRecipe {

    @NonNull RecipeChoice getTemplate();

}
