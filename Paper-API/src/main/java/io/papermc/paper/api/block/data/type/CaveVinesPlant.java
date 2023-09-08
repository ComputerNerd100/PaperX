package io.papermc.paper.api.block.data.type;

import io.papermc.paper.api.block.data.BlockData;

/**
 * 'berries' indicates whether the block has berries.
 */
public interface CaveVinesPlant extends BlockData {

    /**
     * Gets the value of the 'berries' property.
     *
     * @return the 'berries' value
     */
    boolean isBerries();

    /**
     * Sets the value of the 'berries' property.
     *
     * @param berries the new 'berries' value
     */
    void setBerries(boolean berries);
}
