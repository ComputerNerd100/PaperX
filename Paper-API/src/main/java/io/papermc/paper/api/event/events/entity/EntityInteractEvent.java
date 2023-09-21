package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when an entity interacts with an object
 */
public interface EntityInteractEvent extends CancellableEntityEvent {

    /**
     * Returns the involved block
     *
     * @return the block clicked with this item.
     */
    @Param(1)
    Block block();
}
