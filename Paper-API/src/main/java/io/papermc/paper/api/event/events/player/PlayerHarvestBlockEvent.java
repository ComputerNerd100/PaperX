package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.event.events.block.BlockBreakEvent;
import io.papermc.paper.api.event.events.block.BlockDropItemEvent;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.EquipmentSlot;
import io.papermc.paper.api.inventory.ItemStack;

import java.util.List;

/**
 * This event is called whenever a player harvests a block.
 * <br>
 * A 'harvest' is when a block drops an item (usually some sort of crop) and
 * changes state, but is not broken in order to drop the item.
 * <br>
 * This event is not called for when a block is broken, to handle that, listen
 * for {@link BlockBreakEvent} and
 * {@link BlockDropItemEvent}.
 */
public interface PlayerHarvestBlockEvent extends CancellablePlayerEvent {

    /**
     * Gets the block that is being harvested.
     *
     * @return The block that is being harvested
     */
    @Param(1)
    Block harvestedBlock();

    /**
     * Get the hand used to harvest the block.
     *
     * @return the hand
     */
    @Param(2)
    EquipmentSlot hand();

    /**
     * Gets a list of items that are being harvested from this block.
     *
     * @return A list of items that are being harvested from this block
     */
    @Param(3)
    List<ItemStack> itemsHarvested();
}
