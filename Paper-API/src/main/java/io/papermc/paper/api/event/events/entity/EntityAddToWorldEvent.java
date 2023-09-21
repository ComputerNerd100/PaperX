package io.papermc.paper.api.event.events.entity;

/**
 * Fired any time an entity is being added to the world for any reason.
 *
 * Not to be confused with {@link CreatureSpawnEvent}
 * This will fire anytime a chunk is reloaded too.
 */
public interface EntityAddToWorldEvent extends EntityResultEvent {
}
