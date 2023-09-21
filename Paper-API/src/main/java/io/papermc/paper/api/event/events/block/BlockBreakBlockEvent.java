package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

import java.util.List;

/**
 * Called when a block forces another block to break and drop items.
 * <p>
 * Currently called for piston's and liquid flows.
 */
public interface BlockBreakBlockEvent extends BlockResultEvent {

    /**
     * Get the drops of this event
     *
     * @return the drops
     */
    @Param(0)
    List<ItemStack> drops();
    @Param(1)
    Block source();

}
