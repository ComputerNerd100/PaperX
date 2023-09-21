package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when an {@link Entity} enters a block and is stored in that block.
 * <p>
 * This event is called for bees entering a bee hive.
 * <br>
 * It is not called when a silverfish "enters" a stone block. For that listen to
 * the {@link EntityChangeBlockEvent}.
 */
public interface EntityEnterBlockEvent extends CancellableEntityEvent {

    /**
     * Get the block the entity will enter.
     *
     * @return the block
     */
    @Param(1)
    Block block();
}
