package io.papermc.paper.api.inventory.recipe;

import io.papermc.paper.api.namespace.Keyed;

/**
 * Represents a complex recipe which has imperative server-defined behavior, eg
 * armor dyeing.
 *
 * Note: Since a complex recipe has dynamic outputs, {@link #getResult()} will
 * sometimes return an AIR ItemStack.
 */
public interface ComplexRecipe extends Recipe, Keyed {}

