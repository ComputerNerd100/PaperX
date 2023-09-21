package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.BlockState;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.events.world.StructureGrowEvent;
import io.papermc.paper.api.event.util.Param;

import java.util.List;

/**
 * Called with the block changes resulting from a player fertilizing a given
 * block with bonemeal. Will be called after the applicable
 * {@link StructureGrowEvent}.
 */
public interface BlockFertilizeEvent extends CancellableBlockEvent {

    /**
     * Gets the player that triggered the fertilization.
     *
     * @return triggering player, or null if not applicable
     */
    @Param(1)
    Player player();

    /**
     * Gets a list of all blocks changed by the fertilization.
     *
     * @return list of all changed blocks
     */
    @Param(2)
    List<BlockState> blocks();

}
