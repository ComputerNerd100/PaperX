package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.BlockFace;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Called when a block is damaged by a player.
 * <p>
 * If a Block Damage event is cancelled, the block will not be damaged.
 * @see BlockDamageAbortEvent
 */
public interface BlockDamageEvent extends CancellableBlockEvent {

    /**
     * Gets the player damaging the block involved in this event.
     *
     * @return The player damaging the block involved in this event
     */
    @Param(1)
    Player player();

    /**
     * Gets if the block is set to instantly break when damaged by the player.
     *
     * @return true if the block should instantly break when damaged by the
     *     player
     */
    @Param(2)
    boolean instaBreak();

    /**
     * Gets the ItemStack for the item currently in the player's hand.
     *
     * @return The ItemStack for the item currently in the player's hand
     */
    @Param(3)
    ItemStack itemInHand();

    /**
     * Gets the BlockFace the player is interacting with.
     *
     * @return The BlockFace clicked to damage the block
     */
    @Param(4)
    BlockFace blockFace();

}
