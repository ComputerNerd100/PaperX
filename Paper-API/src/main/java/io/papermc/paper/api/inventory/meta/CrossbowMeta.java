package io.papermc.paper.api.inventory.meta;

import io.papermc.paper.api.inventory.ItemStack;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;

public interface CrossbowMeta extends ItemMeta {

    /**
     * Returns whether the item has any charged projectiles.
     *
     * @return whether charged projectiles are present
     */
    boolean hasChargedProjectiles();

    /**
     * Returns an immutable list of the projectiles charged on this item.
     *
     * @return charged projectiles
     */
    @NonNull
    List<ItemStack> getChargedProjectiles();

    /**
     * Sets the projectiles charged on this item.
     *
     * Removes all projectiles when given null.
     *
     * @param projectiles the projectiles to set
     * @throws IllegalArgumentException if one of the projectiles is not an
     * arrow or firework rocket
     */
    void setChargedProjectiles(@Nullable List<ItemStack> projectiles);

    /**
     * Adds a charged projectile to this item.
     *
     * @param item projectile
     * @throws IllegalArgumentException if the projectile is not an arrow or
     * firework rocket
     */
    void addChargedProjectile(@NonNull ItemStack item);
}
