package io.papermc.paper.api.inventory;

import io.papermc.paper.api.block.Block;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents an Inventory that can generate loot, such as Chests inside of Fortresses and Mineshafts
 */
public interface LootableBlockInventory extends LootableInventory {

    /**
     * Gets the block that is lootable
     * @return The Block
     */
    @NonNull
    Block getBlock();
}
