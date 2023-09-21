package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;

/**
 * Represents a player related event that can be cancelled.
 * <p>
 *     <b>
 *         Anything the implements/extends this interface cannot inherit {@link PlayerResultEvent}
 *     </b>
 */
public interface CancellablePlayerEvent extends PlayerEvent, Cancellable {

    /**
     * Get the player involved in this event.
     * @return the player
     */
    @Param(0)
    Player player();
}
