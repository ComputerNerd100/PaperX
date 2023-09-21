package io.papermc.paper.api.event.events.world;

import io.papermc.paper.api.event.util.Param;

/**
 * Called when a chunk is unloaded
 */
public interface ChunkUnloadEvent extends ChunkEvent {

    /**
     * Return whether this chunk will be saved to disk.
     *
     * @return chunk save status
     */
    @Param(0)
    boolean saveChunk();
}
