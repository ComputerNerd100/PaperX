package io.papermc.paper.api.world.generator;

import io.papermc.paper.api.world.Biome;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

/**
 * Class for providing biomes.
 */
public interface BiomeProvider {

    /**
     * Return the Biome which should be present at the provided location.
     * <p>
     * Notes:
     * <p>
     * This method <b>must</b> be completely thread safe and able to handle
     * multiple concurrent callers.
     * <p>
     * This method should only return biomes which are present in the list
     * returned by {@link #getBiomes(WorldInfo)}
     * <p>
     * This method should <b>never</b> return {@link Biome#CUSTOM}.
     *
     * @param worldInfo The world info of the world the biome will be used for
     * @param x The X-coordinate from world origin
     * @param y The Y-coordinate from world origin
     * @param z The Z-coordinate from world origin
     * @return Biome for the given location
     */
    @NonNull
    Biome getBiome(@NonNull WorldInfo worldInfo, int x, int y, int z);

    /**
     * Return the Biome which should be present at the provided location.
     * <p>
     * Notes:
     * <p>
     * This method <b>must</b> be completely thread safe and able to handle
     * multiple concurrent callers.
     * <p>
     * This method should only return biomes which are present in the list
     * returned by {@link #getBiomes(WorldInfo)}
     * <p>
     * This method should <b>never</b> return {@link Biome#CUSTOM}.
     * Only this method is called if both this and
     * {@link #getBiome(WorldInfo, int, int, int)} are overridden.
     *
     * @param worldInfo The world info of the world the biome will be used for
     * @param x The X-coordinate from world origin
     * @param y The Y-coordinate from world origin
     * @param z The Z-coordinate from world origin
     * @param biomeParameterPoint The parameter point that is provided by default
     *                       for this location (contains temperature, humidity,
     *                       continentalness, erosion, depth and weirdness)
     * @return Biome for the given location
     * @see #getBiome(WorldInfo, int, int, int)
     */
    @NonNull
    Biome getBiome(@NonNull WorldInfo worldInfo, int x, int y, int z, @NonNull BiomeParameterPoint biomeParameterPoint);

    /**
     * Returns a list with every biome the {@link BiomeProvider} will use for
     * the given world.
     * <p>
     * Notes:
     * <p>
     * This method only gets called once, when the world is loaded. Returning
     * another list or modifying the values from the initial returned list later
     * one, are not respected.
     * <p>
     * This method should <b>never</b> return a list which contains
     * {@link Biome#CUSTOM}.
     *
     * @param worldInfo The world info of the world the list will be used for
     * @return A list with every biome the {@link BiomeProvider} uses
     */
    @NonNull
    List<Biome> getBiomes(@NonNull WorldInfo worldInfo);
}