package io.papermc.paper.api.event.events.world;

import io.papermc.paper.api.world.generator.BlockPopulator;

/**
 * Thrown when a newly generated chunk has finished being populated.
 * <p>
 * <b>Note:</b> Do not use this to generated blocks in a newly generated chunk.
 * Use a {@link BlockPopulator} instead.
 */
public interface ChunkPopulateEvent extends ChunkEvent {
}
