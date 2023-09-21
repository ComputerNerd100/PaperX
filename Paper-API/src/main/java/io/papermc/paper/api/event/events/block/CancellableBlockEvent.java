package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;

/**
 * Represents an event that results in a block that can be cancelled.
 * <p>
 *      <b>
 *          Anything that implements/extends this interface cannot inherit {@link BlockResultEvent}
 *      </b>
 * </p>
 */
public interface CancellableBlockEvent extends BlockEvent, Cancellable {

    @Param(0)
    Block block();

}
