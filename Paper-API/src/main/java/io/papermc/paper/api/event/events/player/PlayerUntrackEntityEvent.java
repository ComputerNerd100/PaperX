package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;

/**
 * Is called when a {@link Player} untracks an {@link Entity}.
 */
public interface PlayerUntrackEntityEvent extends PlayerResultEvent {

    /**
     * Gets the entity that will be untracked
     * @return the entity untracked
     */
    @Param(0)
    Entity entity();
}
