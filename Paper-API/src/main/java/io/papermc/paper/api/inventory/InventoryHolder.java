package io.papermc.paper.api.inventory;

import org.checkerframework.checker.nullness.qual.NonNull;

public interface InventoryHolder {

    /**
     * Get the object's inventory.
     *
     * @return The inventory.
     */
    @NonNull Inventory getInventory();
}
