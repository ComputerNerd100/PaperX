package io.papermc.paper.api.inventory.meta;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents an item that has durability and can take damage.
 */
public interface Damageable extends ItemMeta {

    /**
     * Checks to see if this item has damage
     *
     * @return true if this has damage
     */
    boolean hasDamage();

    /**
     * Gets the damage
     *
     * @return the damage
     */
    int getDamage();

    /**
     * Sets the damage
     *
     * @param damage item damage
     */
    void setDamage(int damage);

    @NonNull
    @Override
    Damageable clone();
}

