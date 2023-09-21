package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.BlockState;
import io.papermc.paper.api.entity.Item;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;

import java.util.List;

/**
 * Called if a block broken by a player drops an item.
 *
 * If the block break is cancelled, this event won't be called.
 *
 * If dropItems in BlockBreakEvent is set to false, this event won't be
 * called.
 *
 * This event will also be called if the player breaks a multi block structure,
 * for example a torch on top of a stone. Both items will have an event call.
 *
 * The Block is already broken as this event is called, so #getBlock() will be
 * AIR in most cases. Use #getBlockState() for more Information about the broken
 * block.
 */
public interface BlockDropItemEvent extends CancellableBlockEvent {

    /**
     * Gets the Player that is breaking the block involved in this event.
     *
     * @return The Player that is breaking the block involved in this event
     */
    @Param(1)
    Player player();

    /**
     * Gets the BlockState of the block involved in this event before it was
     * broken.
     *
     * @return The BlockState of the block involved in this event
     */
    @Param(2)
    BlockState blockState();

    /**
     * Gets list of the Item drops caused by the block break.
     *
     * This list is mutable - removing an item from it will cause it to not
     * drop. Adding to the list is allowed.
     *
     * @return The Item the block caused to drop
     */
    @Param(3)
    List<Item> items();

}
