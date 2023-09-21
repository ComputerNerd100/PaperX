package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.recipe.MerchantRecipe;

/**
 * Called when a player trades with a standalone merchant GUI.
 */
public interface PlayerPurchaseEvent extends CancellablePlayerEvent {

    /**
     * @return whether or not the trade will count as a use of the trade
     */
    @Param(1)
    boolean increaseTradeUses();

    /**
     * @return will trade try to reward exp
     */
    @Param(2)
    boolean rewardExp();

    /**
     * Gets the associated trade with this event
     * @return the trade
     */
    @Param(3)
    MerchantRecipe trade();
}
