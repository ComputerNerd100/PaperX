package io.papermc.paper.api.world.generator;

import io.papermc.paper.api.world.World;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

/**
 * Holds various information of a World
 */
public interface WorldInfo {

    /**
     * Gets the unique name of this world
     *
     * @return Name of this world
     */
    @NonNull
    String getName();

    /**
     * Gets the Unique ID of this world
     *
     * @return Unique ID of this world.
     */
    @NonNull
    UUID getUID();

    /**
     * Gets the {@link World.Environment} type of this world
     *
     * @return This worlds Environment type
     */
    World.@NonNull Environment getEnvironment();

    /**
     * Gets the Seed for this world.
     *
     * @return This worlds Seed
     */
    long getSeed();

    /**
     * Gets the minimum height of this world.
     * <p>
     * If the min height is 0, there are only blocks from y=0.
     *
     * @return Minimum height of the world
     */
    int getMinHeight();

    /**
     * Gets the maximum height of this world.
     * <p>
     * If the max height is 100, there are only blocks from y=0 to y=99.
     *
     * @return Maximum height of the world
     */
    int getMaxHeight();

    /**
     * Get the vanilla {@link BiomeProvider} for this world.
     *
     * @return vanilla biome provider
     */
    @NonNull BiomeProvider vanillaBiomeProvider();
}

