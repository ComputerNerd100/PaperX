package io.papermc.paper.api.block.container;

import io.papermc.paper.api.Nameable;
import io.papermc.paper.api.inventory.LootableBlockInventory;
import io.papermc.paper.api.projectilesource.BlockProjectileSource;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents a captured state of a dispenser.
 */
public interface Dispenser extends Container, Nameable, LootableBlockInventory { // Paper

    /**
     * Gets the BlockProjectileSource object for the dispenser.
     * <p>
     * If the block represented by this state is no longer a dispenser, this
     * will return null.
     *
     * @return a BlockProjectileSource if valid, otherwise null
     * @throws IllegalStateException if this block state is not placed
     */
    @Nullable
    BlockProjectileSource getBlockProjectileSource();

    /**
     * Attempts to dispense the contents of the dispenser.
     * <p>
     * If the block represented by this state is no longer a dispenser, this
     * will return false.
     *
     * @return true if successful, otherwise false
     * @throws IllegalStateException if this block state is not placed
     */
    boolean dispense();
}
