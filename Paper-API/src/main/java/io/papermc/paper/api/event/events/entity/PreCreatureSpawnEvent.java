package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.EntityType;
import io.papermc.paper.api.event.Event;
import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.location.Location;

/**
 * WARNING: This event only fires for a limited number of cases, and not for every case that CreatureSpawnEvent does.
 *
 * You should still listen to CreatureSpawnEvent as a backup, and only use this event as an "enhancement".
 * The intent of this event is to improve server performance, so it fires even if the spawning might fail later, for
 * example when the entity would be unable to spawn due to limited space or lighting.
 *
 * Currently: NATURAL and SPAWNER based reasons. Please submit a Pull Request for future additions.
 * Also, Plugins that replace Entity Registrations with their own custom entities might not fire this event.
 */
public interface PreCreatureSpawnEvent extends Event, Cancellable {

    /**
     * @return The location this creature is being spawned at
     */
    @Param(0)
    Location location();

    /**
     * @return The type of creature being spawned
     */
    @Param(1)
    EntityType type();

    /**
     * @return Reason this creature is spawning (ie, NATURAL vs SPAWNER)
     */
    @Param(2)
    CreatureSpawnEvent.SpawnReason reason();

    /**
     * @return If the spawn process should be aborted vs trying more attempts
     */
    @Param(3)
    boolean shouldAbortSpawn();
}
