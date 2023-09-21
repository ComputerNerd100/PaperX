package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.event.util.Param;

/**
 * Called when a redstone current changes
 */
public interface BlockRedstoneEvent extends BlockResultEvent {

    /**
     * Gets the old current of this block
     *
     * @return The previous current
     */
    @Param(0)
    int oldCurrent();

    /**
     * Gets the new current of this block
     *
     * @return The new current
     */
    @Param(1)
    int newCurrent();
}
