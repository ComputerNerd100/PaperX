package io.papermc.paper.api.entity.minecart;

import io.papermc.paper.api.entity.Minecart;
import io.papermc.paper.api.inventory.InventoryHolder;
import io.papermc.paper.api.inventory.LootableEntityInventory;

/**
 * Represents a minecart with a chest. These types of {@link Minecart
 * minecarts} have their own inventory that can be accessed using methods
 * from the {@link InventoryHolder} interface.
 */
public interface StorageMinecart extends Minecart, InventoryHolder, LootableEntityInventory {
}
