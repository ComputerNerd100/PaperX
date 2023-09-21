package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.data.BlockData;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.EquipmentSlot;

/**
 * Called when we try to place a block, to see if we can build it here or not.
 * <p>
 * Note:
 * <ul>
 * <li>The Block returned by block() is the block we are trying to place
 *     on, not the block we are trying to place.
 * </ul>
 */
public interface BlockCanBuildEvent extends BlockResultEvent {

    /**
     * Gets whether or not the block can be built here.
     * <p>
     * By default, returns Minecraft's answer on whether the block can be
     * built here or not.
     *
     * @return boolean whether or not the block can be built
     */
    @Param(0)
    boolean buildable();

    /**
     * Gets the BlockData that we are trying to place.
     *
     * @return The BlockData that we are trying to place
     */
    @Param(1)
    BlockData blockData();

    /**
     * Gets the player who placed the block involved in this event.
     * <br>
     * May be null for legacy calls of the event.
     *
     * @return The Player who placed the block involved in this event
     */
    @Param(2)
    Player player();

    /**
     * Gets the hand the player will use to place the block
     *
     * @return the EquipmentSlot representing the players hand.
     */
    @Param(3)
    EquipmentSlot hand();

}
