package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.event.type.ResultEvent;

/**
 * Represents an event that results in a block.
 *
 * <b>
 *     Anything that implements/extends this interface cannot inherit {@link CancellableBlockEvent}
 * </b>
 */
public interface BlockResultEvent extends BlockEvent, ResultEvent<Block> {

    default Block block() {
        return result();
    }

    default void block(Block block) {
        rawResult().set(block);
    }
}
