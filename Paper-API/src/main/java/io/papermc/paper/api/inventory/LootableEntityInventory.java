package io.papermc.paper.api.inventory;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;

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
