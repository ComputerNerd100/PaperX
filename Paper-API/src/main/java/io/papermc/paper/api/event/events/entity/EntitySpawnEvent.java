package io.papermc.paper.api.event.events.entity;

/**
 * Called when an entity is spawned into a world.
 * <p>
 * If an Entity Spawn event is cancelled, the entity will not spawn.
 */
public interface EntitySpawnEvent extends CancellableEntityEvent {
}
