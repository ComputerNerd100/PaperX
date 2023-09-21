package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.location.Location;

/**
 * Called before an entity is spawned into a world by a spawner.
 *
 * This only includes the spawner's location and not the full BlockState snapshot for performance reasons.
 * If you really need it you have to get the spawner yourself.
 */
public interface PreSpawnerSpawnEvent extends PreCreatureSpawnEvent {
    @Param(4)
    Location spawnerLocation();
}
