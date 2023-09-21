package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.BlockState;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when the moisture level of a soil block changes.
 */
public interface MoistureChangeEvent extends CancellableBlockEvent {

    /**
     * Gets the new state of the affected block.
     *
     * @return new block state
     */
    @Param(1)
    BlockState newState();

}
