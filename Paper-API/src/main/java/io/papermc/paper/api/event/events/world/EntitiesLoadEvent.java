package io.papermc.paper.api.event.events.world;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;

import java.util.List;

/**
 * Called when entities are loaded.
 *
 * The provided chunk may or may not be loaded.
 */
public interface EntitiesLoadEvent extends ChunkEvent {

    /**
     * Get the entities which are being loaded.
     *
     * @return unmodifiable list of loaded entities.
     */
    @Param(0)
    List<Entity> entities();
}
