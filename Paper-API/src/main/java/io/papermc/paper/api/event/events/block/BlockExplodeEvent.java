package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.block.BlockState;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.util.game.GameRule;

import java.util.List;

/**
 * Called when a block explodes interacting with blocks. The
 * event isn't called if the {@link GameRule#MOB_GRIEFING}
 * is disabled as no block interaction will occur.
 * <p>
 * The {@link Block} returned by this event is not necessarily
 * the block that caused the explosion, just the block at the location where
 * the explosion originated. See {@link #explodedBlockState()}
 */
public interface BlockExplodeEvent extends CancellableBlockEvent {

    /**
     * Returns the list of blocks that would have been removed or were removed
     * from the explosion event.
     *
     * @return All blown-up blocks
     */
    @Param(1)
    List<Block> blocks();

    /**
     * Returns the percentage of blocks to drop from this explosion
     *
     * @return The yield.
     */
    @Param(2)
    float yield();

    /**
     * Get a capture of the block that directly caused
     * the explosion, like a bed or respawn anchor. This
     * block state is not placed so {@link BlockState#isPlaced}
     * will be false.
     * <p>
     * Can be null if no block directly caused the explosion.
     *
     * @return the exploded block state or null if not applicable
     */
    @Param(3)
    BlockState explodedBlockState();

}
