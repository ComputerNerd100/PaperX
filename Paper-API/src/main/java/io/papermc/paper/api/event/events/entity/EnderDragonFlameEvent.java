package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.AreaEffectCloud;
import io.papermc.paper.api.entity.EnderDragon;
import io.papermc.paper.api.event.util.Param;

/**
 * Fired when an EnderDragon spawns an AreaEffectCloud by shooting flames
 */
public interface EnderDragonFlameEvent extends CancellableEntityEvent {

    /**
     * The enderdragon involved in this event
     */
    default EnderDragon enderDragon() {
        return (EnderDragon) this.entity();
    }

    /**
     * @return The area effect cloud spawned in this collision
     */
    @Param(1)
    AreaEffectCloud areaEffectCloud();
}
