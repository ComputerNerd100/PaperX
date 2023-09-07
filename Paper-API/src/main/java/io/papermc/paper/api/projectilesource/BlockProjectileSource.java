package io.papermc.paper.api.projectilesource;

import org.jetbrains.annotations.NotNull;

public interface BlockProjectileSource extends ProjectileSource {

    /**
     * Gets the block this projectile source belongs to.
     *
     * @return Block for the projectile source
     */
    @NotNull
    public Block getBlock();
}