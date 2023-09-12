package io.papermc.paper.api.world.generator;

import io.papermc.paper.api.Paper;
import io.papermc.paper.api.block.Biome;
import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.block.data.BlockData;
import io.papermc.paper.api.location.Location;
import io.papermc.paper.api.material.Material;
import io.papermc.paper.api.world.World;
import io.papermc.paper.api.world.WorldCreator;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.papermc.paper.api.world.World.Environment.*;

/**
 * A chunk generator is responsible for the initial shaping of an entire
 * chunk. For example, the nether chunk generator should shape netherrack and
 * soulsand.
 *
 * A chunk is generated in multiple steps, those steps are always in the same
 * order. Between those steps however an unlimited time may pass. This means, a
 * chunk may generated until the surface step and continue with the bedrock step
 * after one or multiple server restarts or even after multiple Minecraft
 * versions.
 *
 * The order of generation is as follows
 * <ol>
 * <li>{@link #generateNoise(WorldInfo, Random, int, int, ChunkData)}</li>
 * <li>{@link #generateSurface(WorldInfo, Random, int, int, ChunkData)}</li>
 * <li>{@link #generateBedrock(WorldInfo, Random, int, int, ChunkData)}</li>
 * <li>{@link #generateCaves(WorldInfo, Random, int, int, ChunkData)}</li>
 * </ol>
 *
 * Every method listed above as well as
 * {@link #getBaseHeight(WorldInfo, Random, int, int, HeightMap)}
 * <b>must</b> be completely thread safe and able to handle multiple concurrent
 * callers.
 *
 * Some aspects of world generation can be delegated to the Vanilla generator.
 * The following methods can be overridden to enable this:
 * <ul>
 * <li>{@link ChunkGenerator#shouldGenerateNoise()} or {@link ChunkGenerator#shouldGenerateNoise(WorldInfo, Random, int, int)}</li>
 * <li>{@link ChunkGenerator#shouldGenerateSurface()} or {@link ChunkGenerator#shouldGenerateSurface(WorldInfo, Random, int, int)}</li>
 * <li>{@link ChunkGenerator#shouldGenerateCaves()} or {@link ChunkGenerator#shouldGenerateCaves(WorldInfo, Random, int, int)}</li>
 * <li>{@link ChunkGenerator#shouldGenerateDecorations()} or {@link ChunkGenerator#shouldGenerateDecorations(WorldInfo, Random, int, int)}</li>
 * <li>{@link ChunkGenerator#shouldGenerateMobs()} or {@link ChunkGenerator#shouldGenerateMobs(WorldInfo, Random, int, int)}</li>
 * <li>{@link ChunkGenerator#shouldGenerateStructures()} or {@link ChunkGenerator#shouldGenerateStructures(WorldInfo, Random, int, int)}</li>
 * </ul>
 */
public abstract class ChunkGenerator {

    /**
     * Shapes the Chunk noise for the given coordinates.
     * <p>
     * Notes:
     * <p>
     * This method should <b>never</b> attempt to get the Chunk at the passed
     * coordinates, as doing so may cause an infinite loop.
     * <p>
     * This method should <b>never</b> modify the {@link ChunkData} at a later
     * point of time.
     * <p>
     * The Y-coordinate range should <b>never</b> be hardcoded, to get the
     * Y-coordinate range use the methods {@link ChunkData#getMinHeight()} and
     * {@link ChunkData#getMaxHeight()}.
     * <p>
     * If {@link #shouldGenerateNoise()} is set to true, the given
     * {@link ChunkData} contains already the Vanilla noise generation.
     *
     * @param worldInfo The world info of the world this chunk will be used for
     * @param random The random generator to use
     * @param chunkX The X-coordinate of the chunk
     * @param chunkZ The Z-coordinate of the chunk
     * @param chunkData To modify
     */
    public void generateNoise(@NonNull WorldInfo worldInfo, @NonNull Random random, int chunkX, int chunkZ, @NonNull ChunkData chunkData) {
    }

    /**
     * Shapes the Chunk surface for the given coordinates.
     * <p>
     * Notes:
     * <p>
     * This method should <b>never</b> attempt to get the Chunk at the passed
     * coordinates, as doing so may cause an infinite loop.
     * <p>
     * This method should <b>never</b> modify the {@link ChunkData} at a later
     * point of time.
     * <p>
     * The Y-coordinate range should <b>never</b> be hardcoded, to get the
     * Y-coordinate range use the methods {@link ChunkData#getMinHeight()} and
     * {@link ChunkData#getMaxHeight()}.
     * <p>
     * If {@link #shouldGenerateSurface()} is set to true, the given
     * {@link ChunkData} contains already the Vanilla surface generation.
     *
     * @param worldInfo The world info of the world this chunk will be used for
     * @param random The random generator to use
     * @param chunkX The X-coordinate of the chunk
     * @param chunkZ The Z-coordinate of the chunk
     * @param chunkData To modify
     */
    public void generateSurface(@NonNull WorldInfo worldInfo, @NonNull Random random, int chunkX, int chunkZ, @NonNull ChunkData chunkData) {
    }

    /**
     * Shapes the Chunk bedrock layer for the given coordinates.
     * <p>
     * Notes:
     * <p>
     * This method should <b>never</b> attempt to get the Chunk at the passed
     * coordinates, as doing so may cause an infinite loop.
     * <p>
     * This method should <b>never</b> modify the {@link ChunkData} at a later
     * point of time.
     * <p>
     * The Y-coordinate range should <b>never</b> be hardcoded, to get the
     * Y-coordinate range use the methods {@link ChunkData#getMinHeight()} and
     * {@link ChunkData#getMaxHeight()}.
     * <p>
     *
     * @param worldInfo The world info of the world this chunk will be used for
     * @param random The random generator to use
     * @param chunkX The X-coordinate of the chunk
     * @param chunkZ The Z-coordinate of the chunk
     * @param chunkData To modify
     */
    public void generateBedrock(@NonNull WorldInfo worldInfo, @NonNull Random random, int chunkX, int chunkZ, @NonNull ChunkData chunkData) {
    }

    /**
     * Shapes the Chunk caves for the given coordinates.
     * <p>
     * Notes:
     * <p>
     * This method should <b>never</b> attempt to get the Chunk at the passed
     * coordinates, as doing so may cause an infinite loop.
     * <p>
     * This method should <b>never</b> modify the {@link ChunkData} at a later
     * point of time.
     * <p>
     * The Y-coordinate range should <b>never</b> be hardcoded, to get the
     * Y-coordinate range use the methods {@link ChunkData#getMinHeight()} and
     * {@link ChunkData#getMaxHeight()}.
     * <p>
     * If {@link #shouldGenerateCaves()} is set to true, the given
     * {@link ChunkData} contains already the Vanilla cave generation.
     *
     * @param worldInfo The world info of the world this chunk will be used for
     * @param random The random generator to use
     * @param chunkX The X-coordinate of the chunk
     * @param chunkZ The Z-coordinate of the chunk
     * @param chunkData To modify
     */
    public void generateCaves(@NonNull WorldInfo worldInfo, @NonNull Random random, int chunkX, int chunkZ, @NonNull ChunkData chunkData) {
    }

    /**
     * Gets called when no {@link BiomeProvider} is set in
     * {@link WorldCreator} or via the server configuration files. It
     * is therefore possible that one plugin can provide the Biomes and another
     * one the generation.
     * <p>
     * Notes:
     * <p>
     * If <code>null</code> is returned, than Vanilla biomes are used.
     * <p>
     * This method only gets called once when the world is loaded. Returning
     * another {@link BiomeProvider} later one is not respected.
     *
     * @param worldInfo The world info of the world the biome provider will be
     * used for
     * @return BiomeProvider to use to fill the biomes of a chunk
     */
    @Nullable
    public BiomeProvider getDefaultBiomeProvider(@NonNull WorldInfo worldInfo) {
        return null;
    }

    /**
     * This method is similar to
     * {@link World#getHighestBlockAt(int, int, HeightMap)}. With the difference
     * being, that the highest y coordinate should be the block before any
     * surface, bedrock, caves or decoration is applied. Or in other words the
     * highest block when only the noise is present at the chunk.
     * <p>
     * Notes:
     * <p>
     * When this method is not overridden, the Vanilla base height is used.
     * <p>
     * This method should <b>never</b> attempt to get the Chunk at the passed
     * coordinates, or use the method
     * {@link World#getHighestBlockAt(int, int, HeightMap)}, as doing so may
     * cause an infinite loop.
     *
     * @param worldInfo The world info of the world this chunk will be used for
     * @param random The random generator to use
     * @param x The X-coordinate from world origin
     * @param z The Z-coordinate from world origin
     * @param heightMap From the highest block should be get
     * @return The y coordinate of the highest block at the given location
     */
    public int getBaseHeight(@NonNull WorldInfo worldInfo, @NonNull Random random, int x, int z, @NonNull HeightMap heightMap) {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Tests if the specified location is valid for a natural spawn position
     *
     * @param world The world we're testing on
     * @param x X-coordinate of the block to test
     * @param z Z-coordinate of the block to test
     * @return true if the location is valid, otherwise false
     */
    public boolean canSpawn(@NonNull World world, int x, int z) {
        Block highest = world.getBlockAt(x, world.getHighestBlockYAt(x, z), z);

        switch (world.getEnvironment()) {
            case NETHER:
                return true;
            case THE_END:
                return highest.getType() != Material.AIR && highest.getType() != Material.WATER && highest.getType() != Material.LAVA;
            case NORMAL:
            default:
                return highest.getType() == Material.SAND || highest.getType() == Material.GRAVEL;
        }
    }

    /**
     * Gets a list of default {@link BlockPopulator}s to apply to a given
     * world
     *
     * @param world World to apply to
     * @return List containing any amount of BlockPopulators
     */
    @NonNull
    public List<BlockPopulator> getDefaultPopulators(@NonNull World world) {
        return new ArrayList<BlockPopulator>();
    }

    /**
     * Gets a fixed spawn location to use for a given world.
     * <p>
     * A null value is returned if a world should not use a fixed spawn point,
     * and will instead attempt to find one randomly.
     *
     * @param world The world to locate a spawn point for
     * @param random Random generator to use in the calculation
     * @return Location containing a new spawn point, otherwise null
     */
    @Nullable
    public Location getFixedSpawnLocation(@NonNull World world, @NonNull Random random) {
        return null;
    }

    /**
     * Gets if the server should generate Vanilla noise.
     * <p>
     * The Vanilla noise is generated <b>before</b>
     * {@link #generateNoise(WorldInfo, Random, int, int, ChunkData)} is called.
     * <p>
     * This is method is not called (and has therefore no effect), if
     * {@link #shouldGenerateNoise(WorldInfo, Random, int, int)} is overridden.
     *
     * @return true if the server should generate Vanilla noise
     * @see #shouldGenerateNoise(WorldInfo, Random, int, int)
     */
    public boolean shouldGenerateNoise() {
        return false;
    }

    /**
     * Gets if the server should generate Vanilla noise.
     * <p>
     * The Vanilla noise is generated <b>before</b>
     * {@link #generateNoise(WorldInfo, Random, int, int, ChunkData)} is called.
     * <p>
     * Only this method is called if both this and
     * {@link #shouldGenerateNoise()} are overridden.
     *
     * @param worldInfo The world info of the world this chunk will be used for
     * @param random The random generator to use
     * @param chunkX The X-coordinate of the chunk
     * @param chunkZ The Z-coordinate of the chunk
     * @return true if the server should generate Vanilla noise
     * @see #shouldGenerateNoise()
     */
    public boolean shouldGenerateNoise(@NonNull WorldInfo worldInfo, @NonNull Random random, int chunkX, int chunkZ) {
        return shouldGenerateNoise();
    }

    /**
     * Gets if the server should generate Vanilla surface.
     * <p>
     * The Vanilla surface is generated <b>before</b>
     * {@link #generateSurface(WorldInfo, Random, int, int, ChunkData)} is
     * called.
     * <p>
     * This is method is not called (and has therefore no effect), if
     * {@link #shouldGenerateSurface(WorldInfo, Random, int, int)} is overridden.
     *
     * @return true if the server should generate Vanilla surface
     * @see #shouldGenerateSurface(WorldInfo, Random, int, int)
     */
    public boolean shouldGenerateSurface() {
        return false;
    }

    /**
     * Gets if the server should generate Vanilla surface.
     * <p>
     * The Vanilla surface is generated <b>before</b>
     * {@link #generateSurface(WorldInfo, Random, int, int, ChunkData)} is
     * called.
     * <p>
     * Only this method is called if both this and
     * {@link #shouldGenerateSurface()} are overridden.
     *
     * @param worldInfo The world info of the world this chunk will be used for
     * @param random The random generator to use
     * @param chunkX The X-coordinate of the chunk
     * @param chunkZ The Z-coordinate of the chunk
     * @return true if the server should generate Vanilla surface
     * @see #shouldGenerateSurface()
     */
    public boolean shouldGenerateSurface(@NonNull WorldInfo worldInfo, @NonNull Random random, int chunkX, int chunkZ) {
        return shouldGenerateSurface();
    }

    /**
     * Gets if the server should generate Vanilla caves.
     * <p>
     * The Vanilla caves are generated <b>before</b>
     * {@link #generateCaves(WorldInfo, Random, int, int, ChunkData)} is called.
     * <p>
     * This is method is not called (and has therefore no effect), if
     * {@link #shouldGenerateCaves(WorldInfo, Random, int, int)} is overridden.
     *
     * @return true if the server should generate Vanilla caves
     * @see #shouldGenerateCaves(WorldInfo, Random, int, int)
     */
    public boolean shouldGenerateCaves() {
        return false;
    }

    /**
     * Gets if the server should generate Vanilla caves.
     * <p>
     * The Vanilla caves are generated <b>before</b>
     * {@link #generateCaves(WorldInfo, Random, int, int, ChunkData)} is called.
     * <p>
     * Only this method is called if both this and
     * {@link #shouldGenerateCaves()} are overridden.
     *
     * @param worldInfo The world info of the world this chunk will be used for
     * @param random The random generator to use
     * @param chunkX The X-coordinate of the chunk
     * @param chunkZ The Z-coordinate of the chunk
     * @return true if the server should generate Vanilla caves
     * @see #shouldGenerateCaves()
     */
    public boolean shouldGenerateCaves(@NonNull WorldInfo worldInfo, @NonNull Random random, int chunkX, int chunkZ) {
        return shouldGenerateCaves();
    }

    /**
     * Gets if the server should generate Vanilla decorations after this
     * ChunkGenerator.
     * <p>
     * The Vanilla decoration are generated <b>before</b> any
     * {@link BlockPopulator} are called.
     * <p>
     * This is method is not called (and has therefore no effect), if
     * {@link #shouldGenerateDecorations(WorldInfo, Random, int, int)} is overridden.
     *
     * @return true if the server should generate Vanilla decorations
     * @see #shouldGenerateDecorations(WorldInfo, Random, int, int)
     */
    public boolean shouldGenerateDecorations() {
        return false;
    }

    /**
     * Gets if the server should generate Vanilla decorations after this
     * ChunkGenerator.
     * <p>
     * The Vanilla decoration are generated <b>before</b> any
     * {@link BlockPopulator} are called.
     * <p>
     * Only this method is called if both this and
     * {@link #shouldGenerateDecorations()} are overridden.
     *
     * @param worldInfo The world info of the world this chunk will be used for
     * @param random The random generator to use
     * @param chunkX The X-coordinate of the chunk
     * @param chunkZ The Z-coordinate of the chunk
     * @return true if the server should generate Vanilla decorations
     * @see #shouldGenerateDecorations()
     */
    public boolean shouldGenerateDecorations(@NonNull WorldInfo worldInfo, @NonNull Random random, int chunkX, int chunkZ) {
        return shouldGenerateDecorations();
    }

    /**
     * Gets if the server should generate Vanilla mobs after this
     * ChunkGenerator.
     * <p>
     * This is method is not called (and has therefore no effect), if
     * {@link #shouldGenerateMobs(WorldInfo, Random, int, int)} is overridden.
     *
     * @return true if the server should generate Vanilla mobs
     * @see #shouldGenerateMobs(WorldInfo, Random, int, int)
     */
    public boolean shouldGenerateMobs() {
        return false;
    }

    /**
     * Gets if the server should generate Vanilla mobs after this
     * ChunkGenerator.
     * <p>
     * Only this method is called if both this and
     * {@link #shouldGenerateMobs()} are overridden.
     *
     * @param worldInfo The world info of the world this chunk will be used for
     * @param random The random generator to use
     * @param chunkX The X-coordinate of the chunk
     * @param chunkZ The Z-coordinate of the chunk
     * @return true if the server should generate Vanilla mobs
     * @see #shouldGenerateMobs()
     */
    public boolean shouldGenerateMobs(@NonNull WorldInfo worldInfo, @NonNull Random random, int chunkX, int chunkZ) {
        return shouldGenerateMobs();
    }

    /**
     * Gets if the server should generate Vanilla structures after this
     * ChunkGenerator.
     * <p>
     * This is method is not called (and has therefore no effect), if
     * {@link #shouldGenerateStructures(WorldInfo, Random, int, int)} is overridden.
     *
     * @return true if the server should generate Vanilla structures
     * @see #shouldGenerateStructures(WorldInfo, Random, int, int)
     */
    public boolean shouldGenerateStructures() {
        return false;
    }
    
    /**
     * Create a ChunkData for use in a generator, that is populated by the vanilla generator for that world
     *
     * @param world the world to create the ChunkData for
     * @param x the x coordinate of the chunk
     * @param z the z coordinate of the chunk
     * @return a new ChunkData for the world
     *
     */
    @NonNull
    public ChunkData createVanillaChunkData(@NonNull World world, int x, int z) {
        return Paper.getServer().createVanillaChunkData(world, x, z);
    }

    /**
     * Gets if the server should generate Vanilla structures after this
     * ChunkGenerator.
     * <p>
     * Only this method is called if both this and
     * {@link #shouldGenerateStructures()} are overridden.
     *
     * @param worldInfo The world info of the world this chunk will be used for
     * @param random The random generator to use
     * @param chunkX The X-coordinate of the chunk
     * @param chunkZ The Z-coordinate of the chunk
     * @return true if the server should generate Vanilla structures
     * @see #shouldGenerateStructures()
     */
    public boolean shouldGenerateStructures(@NonNull WorldInfo worldInfo, @NonNull Random random, int chunkX, int chunkZ) {
        return shouldGenerateStructures();
    }

    /**
     * Data for a Chunk.
     */
    public interface ChunkData {
        /**
         * Get the minimum height for this ChunkData.
         * <p>
         * It is not guaranteed that this method will return the same value as
         * {@link World#getMinHeight()}.
         * <p>
         * Setting blocks below this height will do nothing.
         *
         * @return the minimum height
         */
        public int getMinHeight();

        /**
         * Get the maximum height for this ChunkData.
         * <p>
         * It is not guaranteed that this method will return the same value as
         * {@link World#getMaxHeight()}.
         * <p>
         * Setting blocks at or above this height will do nothing.
         *
         * @return the maximum height
         */
        public int getMaxHeight();

        /**
         * Get the biome at x, y, z within chunk being generated
         *
         * @param x the x location in the chunk from 0-15 inclusive
         * @param y the y location in the chunk from minHeight (inclusive) -
         * maxHeight (exclusive)
         * @param z the z location in the chunk from 0-15 inclusive
         * @return Biome value
         */
        @NonNull
        public Biome getBiome(int x, int y, int z);

        /**
         * Set the block at x,y,z in the chunk data to material.
         *
         * Note: setting blocks outside the chunk's bounds does nothing.
         *
         * @param x the x location in the chunk from 0-15 inclusive
         * @param y the y location in the chunk from minHeight (inclusive) - maxHeight (exclusive)
         * @param z the z location in the chunk from 0-15 inclusive
         * @param material the type to set the block to
         */
        public void setBlock(int x, int y, int z, @NonNull Material material);

        /**
         * Set the block at x,y,z in the chunk data to material.
         *
         * Setting blocks outside the chunk's bounds does nothing.
         *
         * @param x the x location in the chunk from 0-15 inclusive
         * @param y the y location in the chunk from minHeight (inclusive) - maxHeight (exclusive)
         * @param z the z location in the chunk from 0-15 inclusive
         * @param blockData the type to set the block to
         */
        public void setBlock(int x, int y, int z, @NonNull BlockData blockData);

        /**
         * Set a region of this chunk from xMin, yMin, zMin (inclusive)
         * to xMax, yMax, zMax (exclusive) to material.
         *
         * Setting blocks outside the chunk's bounds does nothing.
         *
         * @param xMin minimum x location (inclusive) in the chunk to set
         * @param yMin minimum y location (inclusive) in the chunk to set
         * @param zMin minimum z location (inclusive) in the chunk to set
         * @param xMax maximum x location (exclusive) in the chunk to set
         * @param yMax maximum y location (exclusive) in the chunk to set
         * @param zMax maximum z location (exclusive) in the chunk to set
         * @param material the type to set the blocks to
         */
        public void setRegion(int xMin, int yMin, int zMin, int xMax, int yMax, int zMax, @NonNull Material material);
        

        /**
         * Set a region of this chunk from xMin, yMin, zMin (inclusive) to xMax,
         * yMax, zMax (exclusive) to material.
         *
         * Setting blocks outside the chunk's bounds does nothing.
         *
         * @param xMin minimum x location (inclusive) in the chunk to set
         * @param yMin minimum y location (inclusive) in the chunk to set
         * @param zMin minimum z location (inclusive) in the chunk to set
         * @param xMax maximum x location (exclusive) in the chunk to set
         * @param yMax maximum y location (exclusive) in the chunk to set
         * @param zMax maximum z location (exclusive) in the chunk to set
         * @param blockData the type to set the blocks to
         */
        public void setRegion(int xMin, int yMin, int zMin, int xMax, int yMax, int zMax, @NonNull BlockData blockData);

        /**
         * Get the type of the block at x, y, z.
         *
         * Getting blocks outside the chunk's bounds returns air.
         *
         * @param x the x location in the chunk from 0-15 inclusive
         * @param y the y location in the chunk from minHeight (inclusive) - maxHeight (exclusive)
         * @param z the z location in the chunk from 0-15 inclusive
         * @return the type of the block or Material.AIR if x, y or z are outside the chunk's bounds
         */
        @NonNull
        public Material getType(int x, int y, int z);
        
        /**
         * Get the type and data of the block at x, y, z.
         *
         * Getting blocks outside the chunk's bounds returns air.
         *
         * @param x the x location in the chunk from 0-15 inclusive
         * @param y the y location in the chunk from minHeight (inclusive) - maxHeight (exclusive)
         * @param z the z location in the chunk from 0-15 inclusive
         * @return the data of the block or the BlockData for air if x, y or z are outside the chunk's bounds
         */
        @NonNull
        public BlockData getBlockData(int x, int y, int z);

        /**
         * Get the block data at x,y,z in the chunk data.
         *
         * Getting blocks outside the chunk's bounds returns 0.
         *
         * @param x the x location in the chunk from 0-15 inclusive
         * @param y the y location in the chunk from minHeight (inclusive) - maxHeight (exclusive)
         * @param z the z location in the chunk from 0-15 inclusive
         * @return the block data value or air if x, y or z are outside the chunk's bounds
         * @deprecated Uses magic values
         */
        @Deprecated
        public byte getData(int x, int y, int z);
    }
}

