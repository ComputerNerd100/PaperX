package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.AbstractVillager;
import io.papermc.paper.api.entity.Villager;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.recipe.MerchantRecipe;

/**
 * Called when a {@link Villager} is about to restock one of its trades.
 * <p>
 * If this event passes, the villager will reset the
 * {@link MerchantRecipe#getUses() uses} of the affected {@link #recipe()}
 * MerchantRecipe} to <code>0</code>.
 */
public interface VillagerReplenishTradeEvent extends CancellableEntityEvent {
    default AbstractVillager villager() {
        return (AbstractVillager) entity();
    }

    /**
     * Get the recipe to replenish.
     *
     * @return the replenished recipe
     */
    @Param(1)
    MerchantRecipe recipe();
}
