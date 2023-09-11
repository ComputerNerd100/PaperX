package io.papermc.paper.api.entity;

import io.papermc.paper.api.inventory.ItemStack;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface ThrowableProjectile extends Projectile {

    /**
     * Gets the ItemStack the thrown projectile will display.
     *
     * @return The thrown item display ItemStack
     */
    @NonNull
    ItemStack getItem();

    /**
     * Sets the display ItemStack for the thrown projectile.
     *
     * @param item ItemStack set to be displayed
     */
    void setItem(@NonNull ItemStack item);
}
