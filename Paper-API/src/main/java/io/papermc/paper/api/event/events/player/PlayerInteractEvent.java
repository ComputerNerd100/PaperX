package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.block.BlockFace;
import io.papermc.paper.api.event.events.block.Action;
import io.papermc.paper.api.event.events.block.BlockCanBuildEvent;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.EquipmentSlot;
import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.util.vector.Vector;

/**
 * Represents an event that is called when a player interacts with an object or
 * air, potentially fired once for each hand. The hand can be determined using
 * {@link #hand()}.
 * <p>
 * This event will fire as cancelled if the vanilla behavior is to do nothing
 * (e.g interacting with air). For the purpose of avoiding doubt, this means
 * that the event will only be in the cancelled state if it is fired as a result
 * of some prediction made by the server where no subsequent code will run,
 * rather than when the subsequent interaction activity (e.g. placing a block in
 * an illegal position ({@link BlockCanBuildEvent}) will fail.
 */
public interface PlayerInteractEvent extends CancellablePlayerEvent {

    /**
     * Returns the item in hand represented by this event
     *
     * @return ItemStack the item used
     */
    @Param(1)
    ItemStack item();

    /**
     * Returns the action type
     *
     * @return Action returns the type of interaction
     */
    @Param(2)
    Action action();

    /**
     * Returns the clicked block
     *
     * @return Block returns the block clicked with this item.
     */
    @Param(3)
    Block blockClicked();

    /**
     * Returns the face of the block that was clicked
     *
     * @return BlockFace returns the face of the block that was clicked
     */
    @Param(4)
    BlockFace blockFace();

    /**
     * This controls the action to take with the block (if any) that was
     * clicked on. This event gets processed for all blocks, but most don't
     * have a default action
     *
     * @return the action to take with the interacted block
     */
    @Param(5)
    Result useClickedBlock();

    /**
     * This controls the action to take with the item the player is holding.
     * This includes both blocks and items (such as flint and steel or
     * records). When this is set to default, it will be allowed if no action
     * is taken on the interacted block.
     *
     * @return the action to take with the item in hand
     */
    @Param(6)
    Result useItemInHand();

    /**
     * The hand used to perform this interaction. May be null in the case of
     * {@link Action#PHYSICAL}.
     *
     * @return the hand used to interact. May be null.
     */
    @Param(7)
    EquipmentSlot hand();
}
