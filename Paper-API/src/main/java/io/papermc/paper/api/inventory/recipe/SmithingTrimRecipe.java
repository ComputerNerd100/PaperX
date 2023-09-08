package io.papermc.paper.api.inventory.recipe;

import org.checkerframework.checker.nullness.qual.NonNull;

public interface SmithingTrimRecipe extends SmithingRecipe {

    @NonNull RecipeChoice getTemplate();

}
