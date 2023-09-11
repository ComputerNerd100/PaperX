package io.papermc.paper.api.entity;

import io.papermc.paper.api.inventory.ItemStack;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a sized fireball.
 */
public interface SizedFireball extends Fireball {

    /**
     * Gets the display {@link ItemStack}.
     *
     * @return display ItemStack
     */
    @NonNull
    ItemStack getDisplayItem();

    /**
     * Sets the display {@link ItemStack} for the fireball.
     *
     * @param item the ItemStack to display
     */
    void setDisplayItem(@NonNull ItemStack item);
}

