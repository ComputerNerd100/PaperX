package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Called when a player is firing a bow and the server is choosing an arrow to use.
 */
public interface PlayerReadyArrowEvent extends CancellablePlayerEvent {

    /**
     * @return the player is using to fire the arrow
     */
    @Param(1)
    ItemStack bow();

    /**
     * @return the arrow that is attempting to be used
     */
    @Param(2)
    ItemStack arrow();
}
