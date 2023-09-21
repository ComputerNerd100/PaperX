package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.block.BlockFace;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.EquipmentSlot;

/**
 * Triggered when an entity is created in the world by a player "placing" an item
 * on a block.
 * <br>
 * Note that this event is currently only fired for four specific placements:
 * armor stands, boats, minecarts, and end crystals.
 */
public interface EntityPlaceEvent extends CancellableEntityEvent {

    /**
     * Returns the player placing the entity
     *
     * @return the player placing the entity
     */
    @Param(1)
    Player player();

    /**
     * Returns the block that the entity was placed on
     *
     * @return the block that the entity was placed on
     */
    @Param(2)
    Block block();

    /**
     * Returns the face of the block that the entity was placed on
     *
     * @return the face of the block that the entity was placed on
     */
    @Param(3)
    BlockFace blockFace();

    /**
     * Get the hand used to place the entity.
     *
     * @return the hand
     */
    @Param(4)
    EquipmentSlot hand();
}
