package io.papermc.paper.api.inventory;

import io.papermc.paper.api.block.container.BrewingStand;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Interface to the inventory of a Brewing Stand.
 */
public interface BrewerInventory extends Inventory {

    /**
     * Get the current ingredient for brewing.
     *
     * @return The ingredient.
     */
    @Nullable
    ItemStack getIngredient();

    /**
     * Set the current ingredient for brewing.
     *
     * @param ingredient The ingredient
     */
    void setIngredient(@Nullable ItemStack ingredient);

    /**
     * Get the current fuel for brewing.
     *
     * @return The fuel
     */
    @Nullable
    ItemStack getFuel();

    /**
     * Set the current fuel for brewing. Generally only
     * {@link io.papermc.paper.api.material.Material#BLAZE_POWDER} will be of use.
     *
     * @param fuel The fuel
     */
    void setFuel(@Nullable ItemStack fuel);

    @Override
    @Nullable
    BrewingStand getHolder();
}

