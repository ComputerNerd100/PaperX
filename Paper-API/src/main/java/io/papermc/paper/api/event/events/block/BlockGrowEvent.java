package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.BlockState;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a block grows naturally in the world.
 * <p>
 * Examples:
 * <ul>
 * <li>Wheat
 * <li>Sugar Cane
 * <li>Cactus
 * <li>Watermelon
 * <li>Pumpkin
 * <li>Turtle Egg
 * </ul>
 * <p>
 * If a Block Grow event is cancelled, the block will not grow.
 */
public interface BlockGrowEvent extends CancellableBlockEvent {

    /**
     * Gets the state of the block where it will form or spread to.
     *
     * @return The block state for this events block
     */
    @Param(1)
    BlockState newState();

}
