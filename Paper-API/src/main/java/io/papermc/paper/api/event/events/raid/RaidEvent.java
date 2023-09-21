package io.papermc.paper.api.event.events.raid;

import io.papermc.paper.api.event.events.world.WorldEvent;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.util.Raid;
import io.papermc.paper.api.world.World;

/**
 * Represents events related to raids.
 */
public interface RaidEvent extends WorldEvent {

    /**
     * Returns the raid related to this event.
     * @return the raid
     */
    @Param(0)
    Raid raid();

    /**
     * Returns the world related to this event.
     * @return the world
     */
    @Param(1)
    World world();
}
