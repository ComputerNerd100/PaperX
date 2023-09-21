package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.block.BlockState;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.EquipmentSlot;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Called when a block is placed by a player.
 * <p>
 * If a Block Place event is cancelled, the block will not be placed.
 */
public interface BlockPlaceEvent extends CancellableBlockEvent {

    /**
     * Gets the value whether the player would be allowed to build here.
     * Defaults to false if the server was going to stop them (such as, the
     * player is in Spawn). Note that this is an entirely different check
     * than BLOCK_CANBUILD, as this refers to a player, not universe-physics
     * rule like cactus on dirt.
     *
     * @return boolean whether the server would allow a player to build here
     */
    @Param(1)
    boolean canBuild();

    /**
     * Gets the block that this block was placed against
     *
     * @return Block the block that the new block was placed against
     */
    @Param(2)
    Block placedAgainst();

    /**
     * Gets the BlockState for the block which was replaced. Material type air
     * mostly.
     *
     * @return The BlockState for the block which was replaced.
     */
    @Param(3)
    BlockState replacedBlockState();

    /**
     * Gets the item in the player's hand when they placed the block.
     *
     * @return The ItemStack for the item in the player's hand when they
     *     placed the block
     */
    @Param(4)
    ItemStack itemInHand();

    /**
     * Gets the player who placed the block involved in this event.
     *
     * @return The Player who placed the block involved in this event
     */
    @Param(5)
    Player player();

    /**
     * Gets the hand which placed the block
     * @return Main or off-hand, depending on which hand was used to place the block
     */
    @Param(6)
    EquipmentSlot hand();

}
