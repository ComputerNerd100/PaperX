package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.block.BlockFace;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.EquipmentSlot;
import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.material.Material;

/**
 * Called when a player interacts with a Bucket
 */
public interface PlayerBucketEvent extends CancellablePlayerEvent {

    /**
     * Get the resulting item in hand after the bucket event
     *
     * @return ItemStack hold in hand after the event.
     */
    @Param(1)
    ItemStack itemStack();

    /**
     * Gets the block involved in this event.
     *
     * @return The Block which block is involved in this event
     */
    @Param(2)
    Block block();

    /**
     * Return the block clicked
     *
     * @return the clicked block
     */
    @Param(3)
    Block blockClicked();

    /**
     * Get the face on the clicked block
     *
     * @return the clicked face
     */
    @Param(4)
    BlockFace blockFace();

    /**
     * Returns the bucket used in this event
     *
     * @return the used bucket
     */
    @Param(5)
    Material bucket();

    /**
     * Get the hand that was used in this event.
     *
     * @return the hand
     */
    @Param(6)
    EquipmentSlot hand();
}
