package io.papermc.paper.api.event.events.server;

import io.papermc.paper.api.event.Event;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when the server has finished ticking the main loop
 */
public interface ServerTickEndEvent extends Event {

    /**
     * @return What tick this was since start (first tick = 1)
     */
    @Param(0)
    int tickNumber();

    /**
     * @return Time in milliseconds of how long this tick took
     */
    @Param(1)
    double tickDuration();

    /**
     * @return Time in milliseconds of when this tick ended
     */
    @Param(2)
    long timeEnd();
}
