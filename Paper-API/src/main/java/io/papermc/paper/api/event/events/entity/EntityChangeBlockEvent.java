package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.block.data.BlockData;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when any Entity changes a block and a more specific event is not available.
 */
public interface EntityChangeBlockEvent extends CancellableEntityEvent {

    /**
     * Gets the block the entity is changing
     *
     * @return the block that is changing
     */
    @Param(1)
    Block block();

    /**
     * Gets the data for the block that would be changed into
     *
     * @return the data for the block that would be changed into
     */
    @Param(2)
    BlockData to();

}
