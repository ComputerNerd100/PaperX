package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Creeper;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a Creeper is ignited either by a
 * flint and steel, {@link Creeper#ignite()} or
 * {@link Creeper#setIgnited(boolean)}.
 */
public interface CreeperIgniteEvent extends CancellableEntityEvent {
    default Creeper creeper() {
        return (Creeper) this.entity();
    }
    @Param(1)
    boolean ignited();
}
