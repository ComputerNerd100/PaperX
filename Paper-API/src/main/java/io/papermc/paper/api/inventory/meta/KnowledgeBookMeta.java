package io.papermc.paper.api.inventory.meta;

import io.papermc.paper.api.namespace.NamespacedKey;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface KnowledgeBookMeta extends ItemMeta {

    /**
     * Checks for the existence of recipes in the book.
     *
     * @return true if the book has recipes
     */
    boolean hasRecipes();

    /**
     * Gets all the recipes in the book.
     *
     * @return list of all the recipes in the book
     */
    @NonNull
    List<NamespacedKey> getRecipes();

    /**
     * Clears the existing book recipes, and sets the book to use the provided
     * recipes.
     *
     * @param recipes A list of recipes to set the book to use
     */
    void setRecipes(@NonNull List<NamespacedKey> recipes);

    /**
     * Adds new recipe to the end of the book.
     *
     * @param recipes A list of recipe keys
     */
    void addRecipe(@NonNull NamespacedKey... recipes);

    @NonNull
    @Override
    KnowledgeBookMeta clone();
}
