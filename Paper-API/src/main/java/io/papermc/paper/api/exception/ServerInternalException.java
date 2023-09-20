package io.papermc.paper.api.exception;

import io.papermc.paper.api.Paper;
import io.papermc.paper.api.event.events.server.ServerExceptionEvent;

import java.util.logging.Level;

/**
 * Thrown when the internal server throws a recoverable exception.
 */
public class ServerInternalException extends ServerException {

    public ServerInternalException(String message) {
        super(message);
    }

    public ServerInternalException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerInternalException(Throwable cause) {
        super(cause);
    }

    protected ServerInternalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public static void reportInternalException(Throwable cause) {
        try {
            Paper.getPluginManager().callEvent(new ServerExceptionEvent(new ServerInternalException(cause)));
            ;
        } catch (Throwable t) {
            Paper.getLogger().log(Level.WARNING, "Exception posting ServerExceptionEvent", t); // Don't want to rethrow!
        }
    }
}
