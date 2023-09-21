package io.papermc.paper.api.event.events.server;

import io.papermc.paper.api.event.util.Param;

/**
 * This event is called when either the server startup or reload has completed.
 */
public interface ServerLoadEvent extends ServerEvent {

    /**
     * Gets the context in which the server was loaded.
     *
     * @return the context in which the server was loaded
     */
    @Param(0)
    LoadType type();

    /**
     * Represents the context in which the enclosing event has been completed.
     */
    enum LoadType {
        STARTUP, RELOAD;
    }
}
