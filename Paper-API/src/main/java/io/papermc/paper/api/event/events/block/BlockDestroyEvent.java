package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.data.BlockData;
import io.papermc.paper.api.event.util.Param;

/**
 * Fired anytime the server intends to 'destroy' a block through some triggering reason.
 * This does not fire anytime a block is set to air, but only with more direct triggers such
 * as physics updates, pistons, Entities changing blocks, commands set to "Destroy".
 *
 * This event is associated with the game playing a sound effect at the block in question, when
 * something can be described as "intend to destroy what is there",
 *
 * Events such as leaves decaying, pistons retracting (where the block is moving), does NOT fire this event.
 *
 */
public interface BlockDestroyEvent extends CancellableBlockEvent {

    /**
     * @return The new state of this block (Air, or a Fluid type)
     */
    @Param(1)
    BlockData newState();
    /**
     * @return If the server is going to drop the block in question with this destroy event
     */
    @Param(2)
    boolean willDrop();
    /**
     * @return If the server is going to play the sound effect for this destruction
     */
    @Param(3)
    boolean playEffect();

}
