package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Strider;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a {@link Strider}'s temperature has changed as a result of
 * entering or exiting blocks it considers warm.
 */
public interface StriderTemperatureChangeEvent extends CancellableEntityEvent {
    default Strider strider() {
        return (Strider) entity();
    }

    /**
     * Get the Strider's new shivering state.
     *
     * @return the new shivering state
     */
    @Param(1)
    boolean shivering();
}
