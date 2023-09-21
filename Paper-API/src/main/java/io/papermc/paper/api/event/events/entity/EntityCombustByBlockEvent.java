package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a block causes an entity to combust.
 */
public interface EntityCombustByBlockEvent extends EntityCombustEvent {

    /**
     * The combuster can be lava or a block that is on fire.
     * <p>
     * WARNING: block may be null.
     *
     * @return the Block that set the combustee alight.
     */
    @Param(2)
    Block combuster();
}
