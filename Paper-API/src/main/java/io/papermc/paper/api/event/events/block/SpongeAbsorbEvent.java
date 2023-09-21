package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.BlockState;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.material.Material;

import java.util.List;

/**
 * Called when a sponge absorbs water from the world.
 * <br>
 * The world will be in its previous state, and {@link #block()} will
 * represent the changes to be made to the world, if the event is not cancelled.
 * <br>
 * As this is a physics based event it may be called multiple times for "the
 * same" changes.
 */
public interface SpongeAbsorbEvent extends CancellableBlockEvent {

    /**
     * Get a list of all blocks to be removed by the sponge.
     * <br>
     * This list is mutable and contains the blocks in their removed state, i.e.
     * having a type of {@link Material#AIR}.
     *
     * @return list of the to be removed blocks.
     */
    @Param(1)
    List<BlockState> blocks();

}
