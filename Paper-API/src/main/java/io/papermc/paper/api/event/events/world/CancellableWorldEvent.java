package io.papermc.paper.api.event.events.world;

import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.world.World;

/**
 * Represents a world event that can be cancelled
 * <p>
 *     <b>
 *         Anything that implements/extends this interface cannon inherit {@link WorldResultEvent}
 *     </b>
 */
public interface CancellableWorldEvent extends WorldEvent, Cancellable {

    /**
     * Gets the world involved in this event
     * @return the world involved in this event
     */
    @Param(0)
    World world();
}
