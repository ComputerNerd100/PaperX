package io.papermc.paper.api.event.events.world;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.world.generator.BlockPopulator;

/**
 * Called when a chunk is loaded
 */
public interface ChunkLoadEvent extends ChunkEvent {

    /**
     * Gets if this chunk was newly created or not.
     * <p>
     * <b>Note:</b> Do not use this to generated blocks in a newly generated chunk.
     * Use a {@link BlockPopulator} instead.
     *
     * @return true if the chunk is new, otherwise false
     */
    @Param(0)
    boolean newChunk();
}
