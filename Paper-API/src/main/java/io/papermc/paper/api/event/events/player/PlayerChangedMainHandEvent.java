package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.MainHand;

/**
 * Called when a player changes their main hand in the client settings.
 */
public interface PlayerChangedMainHandEvent extends PlayerResultEvent {

    /**
     * Gets the new main hand of the player. The old hand is still momentarily
     * available via {@link Player#getMainHand()}.
     *
     * @return the new {@link MainHand} of the player
     */
    @Param(0)
    MainHand mainHand();
}
