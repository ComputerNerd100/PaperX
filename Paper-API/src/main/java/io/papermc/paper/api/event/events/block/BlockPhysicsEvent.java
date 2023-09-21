package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.block.data.BlockData;
import io.papermc.paper.api.event.util.Param;

/**
 * Thrown when a block physics check is called.
 * <br>
 * This event is a high frequency event, it may be called thousands of times per
 * a second on a busy server. Plugins are advised to listen to the event with
 * caution and only perform lightweight checks when using it.
 * <br>
 * In addition to this, cancelling the event is liable to leave the world in an
 * inconsistent state. For example if you use the event to leave a block
 * floating in mid air when that block has a requirement to be attached to
 * something, there is no guarantee that the floating block will persist across
 * server restarts or map upgrades.
 * <br>
 * Plugins should also note that where possible this event may only called for
 * the "root" block of physics updates in order to limit event spam. Physics
 * updates that cause other blocks to change their state may not result in an
 * event for each of those blocks (usually adjacent). If you are concerned about
 * monitoring these changes then you should check adjacent blocks yourself.
 */
public interface BlockPhysicsEvent extends CancellableBlockEvent {

    /**
     * Gets the BlockData of the block that changed, causing this event.
     * This is the BlockData of {@link #block()} at the time of the event.
     *
     * @return Changed block's BlockData
     */
    @Param(1)
    BlockData changed();

    /**
     * Gets the source block that triggered this event.
     *
     * Note: This will default to block if not set.
     *
     * @return The source block
     */
    @Param(2)
    Block sourceBlock();

}
