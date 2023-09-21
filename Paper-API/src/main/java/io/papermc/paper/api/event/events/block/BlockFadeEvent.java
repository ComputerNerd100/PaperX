package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.BlockState;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a block fades, melts or disappears based on world conditions
 * <p>
 * Examples:
 * <ul>
 * <li>Snow melting due to being near a light source.
 * <li>Ice melting due to being near a light source.
 * <li>Fire burning out after time, without destroying fuel block.
 * <li>Coral fading to dead coral due to lack of water</li>
 * <li>Turtle Egg bursting when a turtle hatches</li>
 * </ul>
 * <p>
 * If a Block Fade event is cancelled, the block will not fade, melt or
 * disappear.
 */

public interface BlockFadeEvent extends CancellableBlockEvent {

    /**
     * Gets the state of the block that will be fading, melting or
     * disappearing.
     *
     * @return The block state of the block that will be fading, melting or
     *     disappearing
     */
    @Param(1)
    BlockState newState();

}
