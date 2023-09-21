package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.PufferFish;
import io.papermc.paper.api.event.util.Param;

/**
 * Called just before a {@link PufferFish} inflates or deflates.
 */
public interface PufferFishStateChangeEvent extends CancellableEntityEvent {
    default PufferFish pufferfish() {
        return (PufferFish) this.entity();
    }

    /**
     * Get the <strong>new</strong> puff state of the {@link PufferFish}.
     * <p>
     * This is what the {@link PufferFish}'s new puff state will be after this event if it isn't cancelled.<br>
     * Refer to {@link PufferFish#getPuffState()} to get the current puff state.
     * @return The <strong>new</strong> puff state, 0 being not inflated, 1 being slightly inflated and 2 being fully inflated
     */
    @Param(1)
    int newPuffState();
}
