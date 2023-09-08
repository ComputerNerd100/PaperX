package io.papermc.paper.api.inventory.recipe;

import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.namespace.Keyed;
import io.papermc.paper.api.namespace.NamespacedKey;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a smithing recipe.
 */
public interface SmithingRecipe extends Recipe, Keyed {

    /**
     * Get the base recipe item.
     *
     * @return base choice
     */
    @NonNull
    RecipeChoice getBase();

    /**
     * Get the addition recipe item.
     *
     * @return addition choice
     */
    @NonNull
    RecipeChoice getAddition();

    @NonNull
    @Override
    ItemStack getResult();

    @NonNull
    @Override
    NamespacedKey getKey();

    /**
     * Whether or not to copy the NBT of the input base item to the output.
     *
     * @return true to copy the NBT (default for vanilla smithing recipes)
     */
    boolean willCopyNbt();
}
