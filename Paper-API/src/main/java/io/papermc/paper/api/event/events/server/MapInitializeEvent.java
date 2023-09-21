package io.papermc.paper.api.event.events.server;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.map.MapView;

/**
 * Called when a map is initialized.
 */
public interface MapInitializeEvent extends ServerEvent {

    /**
     * Gets the map initialized in this event.
     *
     * @return Map for this event
     */
    @Param(0)
    MapView mapView();
}
