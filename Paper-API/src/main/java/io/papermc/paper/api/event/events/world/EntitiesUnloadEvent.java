package io.papermc.paper.api.event.events.world;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;

import java.util.List;

/**
 * Called when entities are unloaded.
 *
 * The provided chunk may or may not be loaded.
 */
public interface EntitiesUnloadEvent extends ChunkEvent {

    /**
     * Get the entities which are being unloaded.
     *
     * @return unmodifiable list of unloaded entities.
     */
    @Param(0)
    List<Entity> entities();
}
