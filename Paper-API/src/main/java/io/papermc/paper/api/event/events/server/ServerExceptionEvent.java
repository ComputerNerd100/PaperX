package io.papermc.paper.api.event.events.server;

import io.papermc.paper.api.event.Event;
import io.papermc.paper.api.event.util.Param;

/**
 * Called whenever an exception is thrown in a recoverable section of the server.
 */
public interface ServerExceptionEvent extends Event {

    /**
     * Gets the wrapped exception that was thrown.
     *
     * @return Exception thrown
     */
    @Param(0)
    ServerException exception();

}
