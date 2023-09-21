package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.block.tilestate.EndGateway;
import io.papermc.paper.api.event.util.Param;

/**
 * Fired any time an entity attempts to teleport in an end gateway
 */
public interface EntityTeleportEndGatewayEvent extends EntityTeleportEvent {

    /**
     * The gateway triggering the teleport
     *
     * @return EndGateway used
     */
    @Param(3)
    EndGateway gateway();
}
