package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.BlockFace;
import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a bell is being rung.
 */
public interface BellRingEvent extends CancellableBlockEvent {

    /**
     * Get the direction in which the bell was rung.
     *
     * @return the direction
     */
    @Param(1)
    BlockFace blockFace();

    /**
     * Get the {@link Entity} that rang the bell (if there was one).
     *
     * @return the entity
     */
    @Param(2)
    Entity entity();

}
