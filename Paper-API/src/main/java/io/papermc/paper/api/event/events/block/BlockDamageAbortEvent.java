package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Called when a player stops damaging a Block.
 * @see BlockDamageEvent
 */
public interface BlockDamageAbortEvent extends BlockResultEvent {

    /**
     * Gets the player that stopped damaging the block involved in this event.
     *
     * @return The player that stopped damaging the block
     */
    @Param(0)
    Player player();

    /**
     * Gets the ItemStack for the item currently in the player's hand.
     *
     * @return The ItemStack for the item currently in the player's hand
     */
    @Param(1)
    ItemStack itemInHand();
}
