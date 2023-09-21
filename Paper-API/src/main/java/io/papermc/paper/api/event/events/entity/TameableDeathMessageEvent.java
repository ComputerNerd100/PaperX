package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Tameable;
import io.papermc.paper.api.event.util.Param;
import net.kyori.adventure.text.Component;

/**
 * Called when a {@link Tameable} dies and sends a death message.
 */
public interface TameableDeathMessageEvent extends CancellableEntityEvent {
    default Tameable tameable() {
        return (Tameable) this.entity();
    }

    /**
     * Get the death message that appears to the owner of the tameable.
     *
     * @return Death message to appear
     */
    @Param(1)
    Component deathMessage();
}
