package io.papermc.paper.api.inventory;


import io.papermc.paper.api.block.Block;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a block inventory holder - either a BlockState, or a regular
 * Block.
 */
public interface BlockInventoryHolder extends InventoryHolder {

    /**
     * Gets the block associated with this holder.
     *
     * @return the block associated with this holder
     * @throws IllegalStateException if the holder is a block state and is not
     * placed
     */
    @NonNull
    Block getBlock();
}
