package io.papermc.paper.api.event.events.packet;

import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.events.world.ChunkEvent;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.world.Chunk;

/**
 * Is called when a {@link Player} receives a {@link Chunk}
 * <p>
 * Can for example be used for spawning a fake entity when the player receives a chunk.
 *
 * Should only be used for packet/clientside related stuff.
 * Not intended for modifying server side state.
 */
public interface PlayerChunkLoadEvent extends ChunkEvent {

    /**
     * Get the player that received the chunk load packet.
     * @return the player
     */
    @Param(0)
    Player player();
}
