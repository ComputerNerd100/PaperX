package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.event.util.Param;

/**
 * An event that's called when a block yields experience.
 */
public interface BlockExpEvent extends BlockEvent {

    /**
     * Gets the block involved in this event.
     *
     * @return The Block which block is involved in this event
     */
    @Param(0)
    Block block();

    /**
     * Get the experience dropped by the block after the event has processed
     *
     * @return The experience to drop
     */
    @Param(1)
    int exp();

}
