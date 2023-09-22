package io.papermc.paper.api.entity;

import io.papermc.paper.api.block.data.BlockData;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a block display entity.
 */
public interface BlockDisplay extends Display {

    /**
     * Gets the displayed block.
     *
     * @return the displayed block
     */
    @NonNull BlockData getBlock();

    /**
     * Sets the displayed block.
     *
     * @param block the new block
     */
    void setBlock(@NonNull BlockData block);
}

