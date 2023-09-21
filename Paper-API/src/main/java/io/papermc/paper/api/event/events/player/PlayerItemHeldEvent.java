package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;

/**
 * Fired when a player changes their currently held item
 */
public interface PlayerItemHeldEvent extends CancellablePlayerEvent {

    /**
     * Gets the previous held slot index
     *
     * @return Previous slot index
     */
    @Param(1)
    int previous();

    /**
     * Gets the new held slot index
     *
     * @return New slot index
     */
    @Param(2)
    int current();
}
