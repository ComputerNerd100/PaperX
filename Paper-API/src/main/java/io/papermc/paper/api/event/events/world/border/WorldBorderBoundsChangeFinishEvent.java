package io.papermc.paper.api.event.events.world.border;

import io.papermc.paper.api.event.util.Param;

/**
 * Called when a moving world border has finished its move.
 */
public interface WorldBorderBoundsChangeFinishEvent extends WorldBorderEvent {

    /**
     * Gets the old size of the worldborder.
     *
     * @return the old size
     */
    @Param(2)
    double oldSize();

    /**
     * Gets the new size of the worldborder.
     *
     * @return the new size
     */
    @Param(3)
    double newSize();

    /**
     * Gets the duration this worldborder took to make the change.
     * <p>
     * Can be 0 if handlers for {@link WorldBorderCenterChangeEvent} set the duration to 0.
     *
     * @return the duration of the transition
     */
    @Param(4)
    double duration();
}
