package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.block.BlockState;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when an entity is damaged by a block
 * <p>
 * For explosions, the Block returned by {@link #damager()} has
 * already been cleared. See {@link #damagerBlockState()} for a snapshot
 * of the block if it has already been changed.
 */
public interface EntityDamageByBlockEvent extends EntityDamageEvent {

    /**
     * Returns the block that damaged the player.
     *
     * @return Block that damaged the player
     */
    @Param(2)
    Block damager();

    /**
     * Get a capture of the block that directly caused
     * the damage, like a bed or respawn anchor. This
     * block state is not placed so {@link BlockState#isPlaced}
     * will be false.
     * <p>
     * Can be null if the block wasn't changed before the event
     *
     * @return the damager block state or null if not applicable
     */
    @Param(3)
    BlockState damagerBlockState();
}
