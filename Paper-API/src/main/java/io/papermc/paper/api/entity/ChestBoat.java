package io.papermc.paper.api.entity;

import io.papermc.paper.api.inventory.InventoryHolder;
import io.papermc.paper.api.inventory.LootableEntityInventory;

/**
 * A {@link Boat} with a chest.
 */
public interface ChestBoat extends Boat, InventoryHolder, LootableEntityInventory {
}

