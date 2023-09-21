package io.papermc.paper.api.event.events.inventory;

import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.events.block.BlockExpEvent;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.material.Material;

/**
 * This event is called when a player takes items out of the furnace
 */
public interface FurnaceExtractEvent extends BlockExpEvent {

    /**
     * Get the player that triggered the event
     *
     * @return the relevant player
     */
    @Param(2)
    Player player();

    /**
     * Get the Material of the item being retrieved
     *
     * @return the material of the item
     */
    @Param(3)
    Material itemType();

    /**
     * Get the item count being retrieved
     *
     * @return the amount of the item
     */
    @Param(4)
    int itemAmount();
}
