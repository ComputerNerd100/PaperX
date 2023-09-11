package io.papermc.paper.api.projectilesource;

import io.papermc.paper.api.block.Block;
import org.jetbrains.annotations.NotNull;

public interface BlockProjectileSource extends ProjectileSource {

    /**
     * Gets the block this projectile source belongs to.
     *
     * @return Block for the projectile source
     */
    @NotNull
    Block getBlock();
}