package io.papermc.paper.api.event.events.inventory;

import io.papermc.paper.api.event.util.Param;

/**
 * This event is called whenever a player clicks a new trade on the trades
 * sidebar.
 * <p>
 * This event allows the user to get the index of the trade, letting them get
 * the MerchantRecipe via the Merchant.
 */
public interface TradeSelectEvent extends InventoryInteractEvent {

    /**
     * Used to get the index of the trade the player clicked on.
     *
     * @return The index of the trade clicked by the player
     */
    @Param(2)
    int index();
}
