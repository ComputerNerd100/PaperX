package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a players experience changes naturally
 */
public interface PlayerExpChangeEvent extends PlayerResultEvent {

    /**
     * Get the source that provided the experience.
     *
     * @return The source of the experience
     */
    @Param(0)
    Entity source();

    /**
     * Get the amount of experience the player will receive
     *
     * @return The amount of experience
     */
    @Param(1)
    int exp();
}
