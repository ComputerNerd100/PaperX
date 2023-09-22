package io.papermc.paper.api.world;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.block.BlockState;
import io.papermc.paper.api.block.data.BlockData;
import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.location.Location;
import io.papermc.paper.api.persistance.PersistentDataHolder;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collection;

/**
 * Represents a chunk of blocks.
 *
 * If the chunk is not yet fully generated and data is requested from the chunk,
 * then the chunk will only be generated as far as it needs to provide the
 * requested data.
 */
public interface Chunk extends PersistentDataHolder {

    /**
     * Gets the X-coordinate of this chunk
     *
     * @return X-coordinate
     */
    int getX();

    /**
     * Gets the Z-coordinate of this chunk
     *
     * @return Z-coordinate
     */
    int getZ();

    /**
     * @return The Chunks X and Z coordinates packed into a long
     */
    default long getChunkKey() {
        return getChunkKey(getX(), getZ());
    }

    /**
     * @param loc Location to get chunk key
     * @return Location's chunk coordinates packed into a long
     */
    static long getChunkKey(@NonNull Location loc) {
        return getChunkKey((int) Math.floor(loc.getX()) >> 4, (int) Math.floor(loc.getZ()) >> 4);
    }

    /**
     * @param x X Coordinate
     * @param z Z Coordinate
     * @return Chunk coordinates packed into a long
     */
    static long getChunkKey(int x, int z) {
        return (long) x & 0xffffffffL | ((long) z & 0xffffffffL) << 32;
    }

    /**
     * Gets the world containing this chunk
     *
     * @return Parent World
     */
    @NonNull
    World getWorld();

    /**
     * Gets a block from this chunk
     *
     * @param x 0-15
     * @param y world minHeight (inclusive) - world maxHeight (exclusive)
     * @param z 0-15
     * @return the Block
     */
    @NonNull
    Block getBlock(int x, int y, int z);

    /**
     * Capture thread-safe read-only snapshot of chunk data
     *
     * @return ChunkSnapshot
     */
    @NonNull
    ChunkSnapshot getChunkSnapshot();

    /**
     * Capture thread-safe read-only snapshot of chunk data
     *
     * @param includeMaxblocky - if true, snapshot includes per-coordinate
     *     maximum Y values
     * @param includeBiome - if true, snapshot includes per-coordinate biome
     *     type
     * @param includeBiomeTempRain - if true, snapshot includes per-coordinate
     *     raw biome temperature and rainfall
     * @return ChunkSnapshot
     */
    @NonNull
    ChunkSnapshot getChunkSnapshot(boolean includeMaxblocky, boolean includeBiome, boolean includeBiomeTempRain);

    /**
     * Checks if entities in this chunk are loaded.
     *
     * @return True if entities are loaded.
     */
    boolean isEntitiesLoaded();

    /**
     * Get a list of all entities in the chunk.
     * This will force load any entities, which are not loaded.
     *
     * @return The entities.
     */
    @NonNull
    Entity[] getEntities();

    /**
     * Get a list of all tile entities in the chunk.
     *
     * @return The tile entities.
     */
    @NonNull
    default BlockState[] getTileEntities() {
        return getTileEntities(true);
    }

    /**
     * Get a list of all tile entities in the chunk.
     *
     * @param useSnapshot Take snapshots or direct references
     * @return The tile entities.
     */
    @NonNull
    BlockState[] getTileEntities(boolean useSnapshot);

    /**
     * Get a list of all tile entities that match a given predicate in the chunk.
     *
     * @param blockPredicate The predicate of blocks to return tile entities for
     * @param useSnapshot Take snapshots or direct references
     * @return The tile entities.
     */
    @NonNull
    Collection<BlockState> getTileEntities(java.util.function.@NonNull Predicate<Block> blockPredicate, boolean useSnapshot);

    /**
     * Checks if the chunk is fully generated.
     *
     * @return True if it is fully generated.
     */
    boolean isGenerated();

    /**
     * Checks if the chunk is loaded.
     *
     * @return True if it is loaded.
     */
    boolean isLoaded();

    /**
     * Loads the chunk.
     *
     * @param generate Whether or not to generate a chunk if it doesn't
     *     already exist
     * @return true if the chunk has loaded successfully, otherwise false
     */
    boolean load(boolean generate);

    /**
     * Loads the chunk.
     *
     * @return true if the chunk has loaded successfully, otherwise false
     */
    boolean load();

    /**
     * Unloads and optionally saves the Chunk
     *
     * @param save Controls whether the chunk is saved
     * @return true if the chunk has unloaded successfully, otherwise false
     */
    boolean unload(boolean save);

    /**
     * Unloads and optionally saves the Chunk
     *
     * @return true if the chunk has unloaded successfully, otherwise false
     */
    boolean unload();

    /**
     * Checks if this chunk can spawn slimes without being a swamp biome.
     *
     * @return true if slimes are able to spawn in this chunk
     */
    boolean isSlimeChunk();

    /**
     * Gets whether the chunk at the specified chunk coordinates is force
     * loaded.
     * <p>
     * A force loaded chunk will not be unloaded due to lack of player activity.
     *
     * @return force load status
     * @see World#isChunkForceLoaded(int, int)
     */
    boolean isForceLoaded();

    /**
     * Sets whether the chunk at the specified chunk coordinates is force
     * loaded.
     * <p>
     * A force loaded chunk will not be unloaded due to lack of player activity.
     *
     * @param forced force load status
     * @see World#setChunkForceLoaded(int, int, boolean)
     */
    void setForceLoaded(boolean forced);

    /**
     * Adds a plugin ticket for this chunk, loading this chunk if it is not
     * already loaded.
     * <p>
     * A plugin ticket will prevent a chunk from unloading until it is
     * explicitly removed. A plugin instance may only have one ticket per chunk,
     * but each chunk can have multiple plugin tickets.
     * </p>
     *
     * @param plugin Plugin which owns the ticket
     * @return {@code true} if a plugin ticket was added, {@code false} if the
     * ticket already exists for the plugin
     * @throws IllegalStateException If the specified plugin is not enabled
     * @see World#addPluginChunkTicket(int, int, Plugin)
     */
    boolean addPluginChunkTicket(@NonNull Plugin plugin);

    /**
     * Removes the specified plugin's ticket for this chunk
     * <p>
     * A plugin ticket will prevent a chunk from unloading until it is
     * explicitly removed. A plugin instance may only have one ticket per chunk,
     * but each chunk can have multiple plugin tickets.
     * </p>
     *
     * @param plugin Plugin which owns the ticket
     * @return {@code true} if the plugin ticket was removed, {@code false} if
     * there is no plugin ticket for the chunk
     * @see World#removePluginChunkTicket(int, int, Plugin)
     */
    boolean removePluginChunkTicket(@NonNull Plugin plugin);

    /**
     * Retrieves a collection specifying which plugins have tickets for this
     * chunk. This collection is not updated when plugin tickets are added or
     * removed to this chunk.
     * <p>
     * A plugin ticket will prevent a chunk from unloading until it is
     * explicitly removed. A plugin instance may only have one ticket per chunk,
     * but each chunk can have multiple plugin tickets.
     * </p>
     *
     * @return unmodifiable collection containing which plugins have tickets for
     * this chunk
     * @see World#getPluginChunkTickets(int, int)
     */
    @NonNull
    Collection<Plugin> getPluginChunkTickets();

    /**
     * Gets the amount of time in ticks that this chunk has been inhabited.
     *
     * Note that the time is incremented once per tick per player within mob
     * spawning distance of this chunk.
     *
     * @return inhabited time
     */
    long getInhabitedTime();

    /**
     * Sets the amount of time in ticks that this chunk has been inhabited.
     *
     * @param ticks new inhabited time
     */
    void setInhabitedTime(long ticks);

    /**
     * Tests if this chunk contains the specified block.
     *
     * @param block block to test
     * @return if the block is contained within
     */
    boolean contains(@NonNull BlockData block);

    /**
     * Tests if this chunk contains the specified biome.
     *
     * @param biome biome to test
     * @return if the biome is contained within
     */
    boolean contains(@NonNull Biome biome);

    /**
     * Gets the load level of this chunk, which determines what game logic is
     * processed.
     *
     * @return the load level
     */
    @NonNull
    LoadLevel getLoadLevel();

    /**
     * An enum to specify the load level of a chunk.
     */
    enum LoadLevel {

        /**
         * No game logic is processed, world generation may still occur.
         */
        INACCESSIBLE,
        /**
         * Most game logic is not processed, including entities and redstone.
         */
        BORDER,
        /**
         * All game logic except entities is processed.
         */
        TICKING,
        /**
         * All game logic is processed.
         */
        ENTITY_TICKING,
        /**
         * This chunk is not loaded.
         */
        UNLOADED
    }
}

