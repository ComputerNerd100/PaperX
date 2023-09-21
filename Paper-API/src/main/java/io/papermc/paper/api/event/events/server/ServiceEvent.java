package io.papermc.paper.api.event.events.server;

import io.papermc.paper.api.event.util.Param;

/**
 * An event relating to a registered service. This is called in a {@link
 * ServicesManager}
 */
public interface ServiceEvent extends ServerEvent {
    @Param(0)
    RegisteredServiceProvider<?> provider();
}
