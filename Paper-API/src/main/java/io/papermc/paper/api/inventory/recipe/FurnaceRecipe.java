package io.papermc.paper.api.inventory.recipe;

import io.papermc.paper.api.material.Material;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface FurnaceRecipe extends CookingRecipe<FurnaceRecipe> {

    @Override
    @NonNull FurnaceRecipe setInput(@NonNull Material input);

    @Override
    @NonNull FurnaceRecipe setInputChoice(@NonNull RecipeChoice input);
}
