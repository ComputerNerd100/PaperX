package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a phantom is spawned for an exhausted player
 */
public interface PhantomPreSpawnEvent extends PreCreatureSpawnEvent {

    /**
     * Get the entity this phantom is spawning for
     *
     * @return Entity
     */
    @Param(4)
    Entity entity();
}
