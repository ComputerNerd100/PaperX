package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.AbstractVillager;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a player trades with a villager or wandering trader
 */
public interface PlayerTradeEvent extends PlayerPurchaseEvent {

    /**
     * Gets the Villager or Wandering trader associated with this event
     * @return the villager or wandering trader
     */
    @Param(4)
    AbstractVillager villager();
}
