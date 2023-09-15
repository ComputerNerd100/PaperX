package io.papermc.paper.api.inventory;

import io.papermc.paper.api.entity.AbstractHorse;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * An interface to the inventory of an {@link AbstractHorse}.
 */
public interface AbstractHorseInventory extends Inventory {

    /**
     * Gets the item in the horse's saddle slot.
     *
     * @return the saddle item
     */
    @Nullable
    ItemStack getSaddle();

    /**
     * Sets the item in the horse's saddle slot.
     *
     * @param stack the new item
     */
    void setSaddle(@Nullable ItemStack stack);
}
