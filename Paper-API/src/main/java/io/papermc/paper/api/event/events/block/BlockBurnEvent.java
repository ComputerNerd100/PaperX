package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a block is destroyed as a result of being burnt by fire.
 * <p>
 * If a Block Burn event is cancelled, the block will not be destroyed as a
 * result of being burnt by fire.
 */
public interface BlockBurnEvent extends CancellableBlockEvent {

    /**
     * Gets the block which ignited this block.
     *
     * @return The Block that ignited and burned this block, or null if no
     * source block exists
     */
    @Param(1)
    Block ignitingBlock();

}
