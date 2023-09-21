package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.block.tilestate.CreatureSpawner;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when an entity is spawned into a world by a spawner.
 * <p>
 * If a Spawner Spawn event is cancelled, the entity will not spawn.
 */
public interface SpawnerSpawnEvent extends EntitySpawnEvent {

    /**
     * Get the spawner that spawned the entity
     * @return the spawner
     */
    @Param(1)
    CreatureSpawner spawner();
}
