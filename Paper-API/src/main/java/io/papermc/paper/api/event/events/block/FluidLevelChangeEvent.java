package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.data.BlockData;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when the fluid level of a block changes due to changes in adjacent
 * blocks.
 */
public interface FluidLevelChangeEvent extends CancellableBlockEvent {

    /**
     * Gets the new data of the changed block.
     *
     * @return new data
     */
    @Param(1)
    BlockData newData();

}
