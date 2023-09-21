package io.papermc.paper.api.event.events.hanging;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.block.BlockFace;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.EquipmentSlot;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Triggered when a hanging entity is created in the world
 */
public interface HangingPlaceEvent extends HangingEvent, Cancellable {

    /**
     * Returns the player placing the hanging entity
     *
     * @return the player placing the hanging entity
     */
    @Param(1)
    Player player();

    /**
     * Returns the block that the hanging entity was placed on
     *
     * @return the block that the hanging entity was placed on
     */
    @Param(2)
    Block block();

    /**
     * Returns the face of the block that the hanging entity was placed on
     *
     * @return the face of the block that the hanging entity was placed on
     */
    @Param(3)
    BlockFace blockFace();

    /**
     * Returns the hand that was used to place the hanging entity, or null
     * if a player did not place the hanging entity.
     *
     * @return the hand
     */
    @Param(4)
    EquipmentSlot hand();

    /**
     * Gets the item from which the hanging entity originated
     *
     * @return the item from which the hanging entity originated
     */
    @Param(5)
    ItemStack itemStack();
}
