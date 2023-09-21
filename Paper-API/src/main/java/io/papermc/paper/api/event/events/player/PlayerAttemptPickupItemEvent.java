package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Item;
import io.papermc.paper.api.event.util.Param;

/**
 * Thrown when a player attempts to pick an item up from the ground
 */
public interface PlayerAttemptPickupItemEvent extends CancellablePlayerEvent {

    /**
     * Gets the Item attempted by the player.
     *
     * @return Item
     */
    @Param(1)
    Item item();

    /**
     * Gets the amount that will remain on the ground, if any
     *
     * @return amount that will remain on the ground
     */
    @Param(2)
    int remaining();

    /**
     * Gets if the item will fly at the player
     *
     * @return True if the item will fly at the player
     */
    @Param(3)
    boolean flyAtPlayer();
}
