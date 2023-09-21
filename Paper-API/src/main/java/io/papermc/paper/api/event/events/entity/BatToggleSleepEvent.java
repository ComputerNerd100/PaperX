package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Bat;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a bat attempts to sleep or wake up from its slumber.
 * <p>
 * If a Bat Toggle Sleep event is cancelled, the Bat will not toggle its sleep
 * state.
 */
public interface BatToggleSleepEvent extends CancellableEntityEvent {

    default Bat bat() {
        return (Bat) entity();
    }

    /**
     * Get whether or not the bat is attempting to awaken.
     *
     * @return true if trying to awaken, false otherwise
     */
    @Param(1)
    boolean awake();

}
