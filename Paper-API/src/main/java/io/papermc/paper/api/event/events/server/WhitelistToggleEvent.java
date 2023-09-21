package io.papermc.paper.api.event.events.server;

import io.papermc.paper.api.event.Event;
import io.papermc.paper.api.event.util.Param;

/**
 * This event is fired when whitelist is toggled
 */
public interface WhitelistToggleEvent extends Event {

    /**
     * Gets whether whitelist is going to be enabled or not
     *
     * @return Whether whitelist is going to be enabled or not
     */
    @Param(0)
    boolean enabled();
}
