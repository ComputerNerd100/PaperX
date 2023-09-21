package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;

/**
 * Event that is fired when a player uses the pick item functionality (middle-clicking a block to get the appropriate
 * item). However, note that this event will only trigger if an item has to be moved from the inventory to the hotbar.
 * After the handling of this event, the contents of the source and the target slot will be swapped and the currently
 * selected hotbar slot of the player will be set to the target slot.
 * <p>
 * Note: This event will not be fired for players in creative mode.
 */
public interface PlayerPickItemEvent extends CancellablePlayerEvent {

    /**
     * Returns the slot the item that is being picked goes into.
     *
     * @return hotbar slot (0-8 inclusive)
     */
    @Param(1)
    int targetSlot();

    /**
     * Returns the slot in which the item that will be put into the players hotbar is located.
     *
     * @return player inventory slot (0-35 inclusive)
     */
    @Param(2)
    int sourceSlot();
}
