package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a visible entity is hidden from a player.
 * <br>
 * This event is only called when the entity's visibility status is actually
 * changed.
 * <br>
 * This event is called regardless of if the entity was within tracking range.
 *
 * @see Player#hideEntity(Plugin, Entity)
 * @apiNote draft API
 */
public interface PlayerHideEntityEvent extends PlayerResultEvent {

    /**
     * Gets the entity which has been hidden from the player.
     *
     * @return the hidden entity
     */
    @Param(0)
    Entity entity();
}
