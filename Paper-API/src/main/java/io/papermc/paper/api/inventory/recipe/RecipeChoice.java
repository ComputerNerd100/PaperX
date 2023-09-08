package io.papermc.paper.api.inventory.recipe;

import com.google.common.base.Preconditions;
import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.material.Material;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Predicate;

/**
 * Represents a potential item match within a recipe. All choices within a
 * recipe must be satisfied for it to be craftable.
 *
 * <b>This class is not legal for implementation by plugins!</b>
 */
public interface RecipeChoice extends Predicate<ItemStack>, Cloneable {

    /**
     * Gets a single item stack representative of this stack choice.
     *
     * @return a single representative item
     * @deprecated for compatibility only
     */
    @Deprecated
    @NonNull
    ItemStack getItemStack();

    @NonNull
    RecipeChoice clone();

    @Override
    boolean test(@NonNull ItemStack itemStack);

    /**
     * Represents a choice of multiple matching Materials.
     */
    interface MaterialChoice extends RecipeChoice {

        @Override
        boolean test(@NonNull ItemStack t);

        @NotNull
        @Override
        ItemStack getItemStack();

        @NotNull
        List<Material> getChoices();

        @NotNull
        @Override
        MaterialChoice clone();
    }

    /**
     * Represents a choice that will be valid only one of the stacks is exactly
     * matched (aside from stack size).
     */
    interface ExactChoice extends RecipeChoice {

        @NotNull
        @Override
        ItemStack getItemStack();

        @NotNull
        List<ItemStack> getChoices();

        @NotNull
        @Override
        ExactChoice clone();

        @Override
        boolean test(@NonNull ItemStack t);
    }
}

