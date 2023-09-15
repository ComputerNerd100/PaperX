package io.papermc.paper.api.inventory;

import org.checkerframework.checker.nullness.qual.Nullable;

public interface ArmoredHorseInventory extends AbstractHorseInventory {

    /**
     * Gets the item in the horse's armor slot.
     *
     * @return the armor item
     */
    @Nullable
    ItemStack getArmor();

    /**
     * Sets the item in the horse's armor slot.
     *
     * @param stack the new item
     */
    void setArmor(@Nullable ItemStack stack);
}
