package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.block.banner.PatternType;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.LoomInventory;

/**
 * Called when a player selects a banner patten in a loom inventory.
 */
public interface PlayerLoomPatternSelectEvent extends CancellablePlayerEvent {

    /**
     * Gets the loom inventory involved.
     *
     * @return the loom inventory
     */
    @Param(1)
    LoomInventory loomInventory();

    /**
     * Gets the pattern type selected.
     *
     * @return the pattern type
     */
    @Param(2)
    PatternType patternType();
}
