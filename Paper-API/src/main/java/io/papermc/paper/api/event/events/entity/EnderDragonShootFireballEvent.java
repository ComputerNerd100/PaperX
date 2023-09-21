package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.DragonFireball;
import io.papermc.paper.api.entity.EnderDragon;
import io.papermc.paper.api.event.util.Param;

/**
 * Fired when an EnderDragon shoots a fireball
 */
public interface EnderDragonShootFireballEvent extends CancellableEntityEvent {

    /**
     * The enderdragon shooting the fireball
     */
    default EnderDragon enderDragon() {
        return (EnderDragon) this.entity();
    }

    /**
     * @return The fireball being shot
     */
    @Param(1)
    DragonFireball fireball();
}
