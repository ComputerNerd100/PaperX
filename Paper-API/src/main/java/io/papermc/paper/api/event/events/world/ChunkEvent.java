package io.papermc.paper.api.event.events.world;

import io.papermc.paper.api.event.events.vehicle.VehicleResultEvent;
import io.papermc.paper.api.event.type.ResultEvent;
import io.papermc.paper.api.world.Chunk;

/**
 * Represents a chunk event that returns a result
 */
public interface ChunkEvent extends WorldEvent, ResultEvent<Chunk> {
    default Chunk chunk() {
        return this.result();
    }
    default void setChunk(Chunk chunk) {
        rawResult().set(chunk);
    }
}
