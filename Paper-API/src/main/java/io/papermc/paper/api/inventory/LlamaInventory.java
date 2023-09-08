package io.papermc.paper.api.inventory;

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * An interface to the inventory of a {@link Llama}.
 */
public interface LlamaInventory extends SaddledHorseInventory {

    /**
     * Gets the item in the llama's decor slot.
     *
     * @return the decor item
     */
    @Nullable
    ItemStack getDecor();

    /**
     * Sets the item in the llama's decor slot.
     *
     * @param stack the new item
     */
    void setDecor(@Nullable ItemStack stack);
}
