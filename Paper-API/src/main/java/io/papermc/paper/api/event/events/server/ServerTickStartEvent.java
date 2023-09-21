package io.papermc.paper.api.event.events.server;

import io.papermc.paper.api.event.Event;
import io.papermc.paper.api.event.util.Param;

public interface ServerTickStartEvent extends Event {

    /**
     * @return What tick this is going be since start (first tick = 1)
     */
    @Param(0)
    int tickNumber();
}
