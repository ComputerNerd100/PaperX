package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.type.ResultEvent;

/**
 * Represents a PlayerEvent that has a result.
 * <p>
 *     <b>
 *         Anything the implements/extends this interface cannot inherit {@link CancellablePlayerEvent}
 *     </b>
 * </p>
 */
public interface PlayerResultEvent extends PlayerEvent, ResultEvent<Player> {
    default Player player() {
        return this.result();
    }
    default void setPlayer(Player player) {
        this.rawResult().set(player);
    }
}
