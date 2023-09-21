package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.block.tilestate.EndGateway;
import io.papermc.paper.api.event.util.Param;

/**
 * Fired when a teleport is triggered for an End Gateway
 */
public interface PlayerTeleportEndGatewayEvent extends PlayerTeleportEvent {

    /**
     * The gateway triggering the teleport
     *
     * @return EndGateway used
     */
    @Param(4)
    EndGateway gateway();
}
