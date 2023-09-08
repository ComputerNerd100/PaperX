package io.papermc.paper.api.block.tilestate;


import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.loot.Lootable;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents a captured state of suspicious sand or gravel.
 */
public interface BrushableBlock extends Lootable, TileState {

    /**
     * Get the item which will be revealed when the sand is fully brushed away
     * and uncovered.
     *
     * @return the item
     */
    @org.jetbrains.annotations.NotNull // Paper
    ItemStack getItem();

    /**
     * Sets the item which will be revealed when the sand is fully brushed away
     * and uncovered.
     *
     * @param item the item
     */
    void setItem(@Nullable ItemStack item);
}