package io.papermc.paper.api.event.events.server;

import io.papermc.paper.api.event.util.Param;

/**
 * Called when resources such as datapacks are reloaded (e.g. /minecraft:reload)
 * <p>
 *     Intended for use to re-register custom recipes, advancements that may be lost during a reload like this.
 * </p>
 */
public interface ServerResourcesReloadedEvent extends ServerEvent {

    /**
     * Gets the cause of the resource reload.
     *
     * @return the reload cause
     */
    @Param(0)
    Cause cause();

    enum Cause {
        COMMAND,
        PLUGIN,
    }
}
