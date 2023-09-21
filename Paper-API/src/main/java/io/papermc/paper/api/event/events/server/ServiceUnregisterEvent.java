package io.papermc.paper.api.event.events.server;

/**
 * This event is called when a service is unregistered.
 * <p>
 * Warning: The order in which register and unregister events are called
 * should not be relied upon.
 */
public interface ServiceUnregisterEvent extends ServiceEvent {
}
