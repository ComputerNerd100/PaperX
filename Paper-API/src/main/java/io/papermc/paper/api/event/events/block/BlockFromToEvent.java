package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.block.BlockFace;
import io.papermc.paper.api.event.util.Param;

/**
 * Represents events with a source block and a destination block, currently
 * only applies to liquid (lava and water) and teleporting dragon eggs.
 * <p>
 * If a Block From To event is cancelled, the block will not move (the liquid
 * will not flow).
 */
public interface BlockFromToEvent extends CancellableBlockEvent {

    /**
     * Convenience method for getting the faced Block.
     *
     * @return The faced Block
     */
    @Param(1)
    Block toBlock();

    /**
     * Gets the BlockFace that the block is moving to.
     *
     * @return The BlockFace that the block is moving to
     */
    @Param(2)
    BlockFace face();

}
