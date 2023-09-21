package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.util.game.GameEvent;

/**
 * Called when a Sculk sensor receives a game event and hence might activate.
 *
 * Will be called cancelled if the block's default behavior is to ignore the
 * event.
 */
public interface BlockReceiveGameEvent extends CancellableBlockEvent {

    /**
     * Get the underlying event.
     *
     * @return the event
     */
    @Param(1)
    GameEvent event();

    /**
     * Get the entity which triggered this event, if present.
     *
     * @return triggering entity or null
     */
    @Param(2)
    Entity entity();

}
