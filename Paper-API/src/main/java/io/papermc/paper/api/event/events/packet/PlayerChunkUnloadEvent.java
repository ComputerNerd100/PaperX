package io.papermc.paper.api.event.events.packet;

import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.events.world.ChunkEvent;
import io.papermc.paper.api.event.util.Param;

/**
 * Is called when a {@link Player} receives a chunk unload packet.
 *
 * Should only be used for packet/clientside related stuff.
 * Not intended for modifying server side.
 */
public interface PlayerChunkUnloadEvent extends ChunkEvent {

    /**
     * Get the player that received the chunk unload packet.
     * @return the player
     */
    @Param(0)
    Player player();
}
