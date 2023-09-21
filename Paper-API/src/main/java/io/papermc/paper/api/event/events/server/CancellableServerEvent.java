package io.papermc.paper.api.event.events.server;

import io.papermc.paper.api.event.type.Cancellable;

/**
 * Represents a server event that can be cancelled.
 */
public interface CancellableServerEvent extends ServerEvent, Cancellable {
}
