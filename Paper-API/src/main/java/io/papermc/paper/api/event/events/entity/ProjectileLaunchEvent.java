package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Projectile;

/**
 * Called when a projectile is launched.
 */
public interface ProjectileLaunchEvent extends EntitySpawnEvent {
    default Projectile projectile() {
        return (Projectile) entity();
    }
}
