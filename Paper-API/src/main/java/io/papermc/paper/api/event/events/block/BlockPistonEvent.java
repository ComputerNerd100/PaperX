package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.BlockFace;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a piston block is triggered
 */
public interface BlockPistonEvent extends CancellableBlockEvent {

    /**
     * Return the direction in which the piston will operate.
     *
     * @return direction of the piston
     */
    @Param(1)
    BlockFace direction();

}
