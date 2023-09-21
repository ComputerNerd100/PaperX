package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Firework;

/**
 * Called when a firework explodes.
 */
public interface FireworkExplodeEvent extends CancellableEntityEvent {
    default Firework firework() {
        return (Firework) entity();
    }
}
