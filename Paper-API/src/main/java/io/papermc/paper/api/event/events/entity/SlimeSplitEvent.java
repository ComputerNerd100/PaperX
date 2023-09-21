package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Slime;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a Slime splits into smaller Slimes upon death
 */
public interface SlimeSplitEvent extends CancellableEntityEvent {
    default Slime slime() {
        return (Slime) entity();
    }

    /**
     * Gets the amount of smaller slimes to spawn
     *
     * @return the amount of slimes to spawn
     */
    @Param(1)
    int count();
}
