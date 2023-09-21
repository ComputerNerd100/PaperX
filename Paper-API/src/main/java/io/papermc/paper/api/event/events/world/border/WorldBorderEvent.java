package io.papermc.paper.api.event.events.world.border;

import io.papermc.paper.api.event.events.world.WorldEvent;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.world.World;
import io.papermc.paper.api.world.WorldBorder;

/**
 * Represents a world border event
 */
public interface WorldBorderEvent extends WorldEvent {

    /**
     * Gets the world that this event is involved with
     * @return the world that this event is involved with
     */
    @Param(0)
    World world();

    /**
     * Gets the world border involved in this event
     * @return the world border involved in this event
     */
    @Param(1)
    WorldBorder worldBorder();
}
