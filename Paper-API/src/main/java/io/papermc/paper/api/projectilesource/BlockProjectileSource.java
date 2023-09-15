package io.papermc.paper.api.projectilesource;

import io.papermc.paper.api.block.Block;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface BlockProjectileSource extends ProjectileSource {

    /**
     * Gets the block this projectile source belongs to.
     *
     * @return Block for the projectile source
     */
    @NonNull
    Block getBlock();
}