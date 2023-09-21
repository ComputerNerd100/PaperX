package io.papermc.paper.api.event.events.server;

import io.papermc.paper.api.event.Event;
import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.profile.PlayerProfile;

/**
 * This event gets called when the whitelist status of a player is changed
 */
public interface WhitelistStateUpdateEvent extends Event, Cancellable {

    /**
     * Gets the player profile whose whitelist status is being changed
     *
     * @return the player profile whose status is being changed
     */
    @Param(0)
    PlayerProfile playerProfile();

    /**
     * Gets the status change of the player profile
     *
     * @return the whitelist status
     */
    @Param(1)
    WhitelistStatus status();

    /**
     * Enum for the whitelist status changes
     */
    enum WhitelistStatus {
        ADDED, REMOVED
    }
}
