package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.AbstractVillager;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.recipe.MerchantRecipe;

/**
 * Called whenever a villager acquires a new trade.
 */
public interface VillagerAcquireTradeEvent extends CancellableEntityEvent {

    /**
     * Get the villager that acquired the new trade.
     * @return the villager
     */
    default AbstractVillager villager() {
        return (AbstractVillager) entity();
    }

    /**
     * Get the recipe to be acquired.
     *
     * @return the new recipe
     */
    @Param(1)
    MerchantRecipe recipe();
}
