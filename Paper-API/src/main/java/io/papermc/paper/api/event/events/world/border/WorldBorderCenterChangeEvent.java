package io.papermc.paper.api.event.events.world.border;

import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.location.Location;

/**
 * Called when a world border's center is changed.
 */
public interface WorldBorderCenterChangeEvent extends WorldBorderEvent, Cancellable {

    /**
     * Gets the original center location of the world border.
     *
     * @return the old center
     */
    @Param(2)
    Location oldCenter();

    /**
     * Gets the new center location for the world border.
     *
     * @return the new center
     */
    @Param(3)
    Location newCenter();
}
