package io.papermc.paper.api.inventory;

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Interface to the inventory of a Stonecutter.
 */
public interface StonecutterInventory extends Inventory {

    /**
     * Gets the input item.
     *
     * @return input item
     */
    @Nullable
    default ItemStack getInputItem() {
        return getItem(0);
    }

    /**
     * Sets the input item.
     *
     * @param itemStack item to set
     */
    default void setInputItem(@Nullable ItemStack itemStack) {
        setItem(0, itemStack);
    }

    /**
     * Gets the result item.
     *
     * @return result
     */
    @Nullable
    default ItemStack getResult() {
        return getItem(1);
    }

    /**
     * Sets the result item.
     *
     * @param itemStack item to set
     */
    default void setResult(@Nullable ItemStack itemStack) {
        setItem(1, itemStack);
    }
}
