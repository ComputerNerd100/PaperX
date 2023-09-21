package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.event.util.Param;

/**
 * Fired when a Slime decides to change its facing direction.
 * <p>
 * This event does not fire for the entity's actual movement. Only when it
 * is choosing to change direction.
 */
public interface SlimeChangeDirectionEvent extends SlimePathfindEvent {

    /**
     * Get the new chosen yaw
     *
     * @return Chosen yaw
     */
    @Param(1)
    float newYaw();
}
