package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a player takes action on a resource pack request.
 * @see Player#setResourcePack(String, String)
 * @see Player#setResourcePack(String, String, boolean)
 */
public interface PlayerResourcePackStatusEvent extends PlayerResultEvent {

    /**
     * Gets the status of this pack.
     *
     * @return the current status
     */
    @Param(0)
    Status status();

    /**
     * Status of the resource pack.
     */
    enum Status {
        /**
         * The resource pack has been successfully downloaded and applied to the
         * client.
         */
        SUCCESSFULLY_LOADED,
        /**
         * The client refused to accept the resource pack.
         */
        DECLINED,
        /**
         * The client accepted the pack, but download failed.
         */
        FAILED_DOWNLOAD,
        /**
         * The client accepted the pack and is beginning a download of it.
         */
        ACCEPTED
    }
}
