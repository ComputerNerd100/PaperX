package io.papermc.paper.api.block.tilestate;


import io.papermc.paper.api.loot.Lootable;
import org.jetbrains.annotations.Nullable;

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
    public ItemStack getItem();

    /**
     * Sets the item which will be revealed when the sand is fully brushed away
     * and uncovered.
     *
     * @param item the item
     */
    public void setItem(@Nullable ItemStack item);
}