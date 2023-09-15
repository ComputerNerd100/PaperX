package io.papermc.paper.api.inventory;

import io.papermc.paper.api.block.container.Furnace;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Interface to the inventory of a Furnace.
 */
public interface FurnaceInventory extends Inventory {

    /**
     * Get the current item in the result slot.
     *
     * @return The item
     */
    @Nullable
    ItemStack getResult();

    /**
     * Get the current fuel.
     *
     * @return The item
     */
    @Nullable
    ItemStack getFuel();

    /**
     * Get the item currently smelting.
     *
     * @return The item
     */
    @Nullable
    ItemStack getSmelting();

    /**
     * Set the current fuel.
     *
     * @param stack The item
     */
    void setFuel(@Nullable ItemStack stack);

    /**
     * Set the current item in the result slot.
     *
     * @param stack The item
     */
    void setResult(@Nullable ItemStack stack);

    /**
     * Set the item currently smelting.
     *
     * @param stack The item
     */
    void setSmelting(@Nullable ItemStack stack);

    /**
     * Check if an item can be used as a fuel source in this furnace container
     *
     * @param item Item to check
     * @return True if a valid fuel source
     */
    public boolean isFuel(@Nullable ItemStack item);

    /**
     * Check if an item can be smelted in this furnace container
     *
     * @param item Item to check
     * @return True if can be smelt
     */
    public boolean canSmelt(@Nullable ItemStack item);

    @Override
    @Nullable
    Furnace getHolder();
}
