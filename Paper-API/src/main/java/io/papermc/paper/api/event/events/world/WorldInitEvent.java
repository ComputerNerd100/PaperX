package io.papermc.paper.api.event.events.world;

/**
 * Called when a World is initializing.
 * <p>
 * To get every world it is recommended to add following to the plugin.yml.
 * <pre>load: STARTUP</pre>
 */
public interface WorldInitEvent extends WorldResultEvent {
}
