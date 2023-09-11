package io.papermc.paper.api.entity;

import io.papermc.paper.api.inventory.Inventory;
import io.papermc.paper.api.inventory.InventoryHolder;
import io.papermc.paper.api.inventory.Merchant;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a villager NPC
 */
public interface AbstractVillager extends Breedable, NPC, InventoryHolder, Merchant {

    /**
     * Gets this villager's inventory.
     * <br>
     * Note that this inventory is not the Merchant inventory, rather, it is the
     * items that a villager might have collected (from harvesting crops, etc.)
     *
     * {@inheritDoc}
     */
    @NonNull
    @Override
    Inventory getInventory();
    
    /**
     * Reset this villager's trade offers
     */
    void resetOffers();
}
