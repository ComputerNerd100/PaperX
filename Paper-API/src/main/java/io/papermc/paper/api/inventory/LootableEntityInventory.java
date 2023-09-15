package io.papermc.paper.api.inventory;

import io.papermc.paper.api.entity.Entity;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents an Inventory that can generate loot, such as Minecarts inside of Mineshafts
 */
public interface LootableEntityInventory extends LootableInventory {

    /**
     * Gets the entity that is lootable
     * @return The Entity
     */
    @NonNull
    Entity getEntity();
}
