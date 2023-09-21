package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Slime;

/**
 * Fired when a Slime decides to start pathfinding.
 * <p>
 * This event does not fire for the entity's actual movement. Only when it
 * is choosing to start moving.
 */
public interface SlimePathfindEvent extends CancellableEntityEvent {

    /**
     * The Slime that is pathfinding.
     *
     * @return The Slime that is pathfinding.
     */
    default Slime getSlime() {
        return (Slime) entity();
    }
}
