package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a hidden entity is shown to a player.
 * <br>
 * This event is only called when the entity's visibility status is actually
 * changed.
 * <br>
 * This event is called regardless of whether the entity was within tracking
 * range.
 *
 * @see Player#showEntity(Plugin, Entity)
 * @apiNote draft API
 */
public interface PlayerShowEntityEvent extends PlayerResultEvent {

    /**
     * Gets the entity which has been shown to the player.
     *
     * @return the shown entity
     */
    @Param(0)
    Entity entity();
}
