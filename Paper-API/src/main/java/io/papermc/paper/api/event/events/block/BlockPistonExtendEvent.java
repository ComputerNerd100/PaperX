package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.event.util.Param;

import java.util.List;

/**
 * Called when a piston extends
 */
public interface BlockPistonExtendEvent extends BlockPistonEvent {

    /**
     * Get an immutable list of the blocks which will be moved by the
     * extending.
     *
     * @return Immutable list of the moved blocks.
     */
    @Param(2)
    List<Block> blocks();

}
