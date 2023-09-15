package io.papermc.paper.api.world.generator;

import io.papermc.paper.api.block.BlockState;
import io.papermc.paper.api.block.data.BlockData;
import io.papermc.paper.api.location.Location;
import io.papermc.paper.api.util.vector.Vector;
import io.papermc.paper.api.world.RegionAccessor;
import io.papermc.paper.api.world.World;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

/**
 * A limited region is used in world generation for features which are
 * going over a chunk. For example, trees or ores.
 *
 * Use {@link #getBuffer()} to know how much you can go beyond the central
 * chunk. The buffer zone may or may not be already populated.
 *
 * The coordinates are <b>absolute</b> from the world origin.
 */
public interface LimitedRegion extends RegionAccessor {

    /**
     * Gets the buffer around the central chunk which is accessible.
     * The returned value is in normal world coordinate scale.
     * <p>
     * For example: If the method returns 16 you have a working area of 48x48.
     *
     * @return The buffer in X and Z direction
     */
    int getBuffer();

    /**
     * Checks if the given {@link Location} is in the region.
     *
     * @param location the location to check
     * @return true if the location is in the region, otherwise false.
     */
    boolean isInRegion(@NonNull Location location);

    /**
     * Checks if the given coordinates are in the region.
     *
     * @param x X-coordinate to check
     * @param y Y-coordinate to check
     * @param z Z-coordinate to check
     * @return true if the coordinates are in the region, otherwise false.
     */
    boolean isInRegion(int x, int y, int z);

    /**
     * Gets a list of all tile entities in the limited region including the
     * buffer zone.
     *
     * @return a list of tile entities.
     */
    @NonNull
    List<BlockState> getTileEntities();


    // Paper start
    /**
     * Sets the block at a vector location to the provided {@link BlockData}.
     *
     * @param vector {@link Vector} representing the position of the block to set.
     * @param data   {@link BlockData} to set the block at the provided coordinates to.
     */
    default void setBlockData(@NonNull Vector vector, @NonNull BlockData data) {
        setBlockData(vector.getBlockX(), vector.getBlockY(), vector.getBlockZ(), data);
    }

    /**
     * Sets the {@link BlockState} at a location.
     *
     * @param x X coordinate.
     * @param y Y coordinate.
     * @param z Z coordinate.
     * @param state The block state.
     */
    void setBlockState(int x, int y, int z, @NonNull BlockState state);

    /**
     * Sets the {@link BlockState} at a location.
     *
     * @param location Location to set block state.
     * @param state The block state.
     */
    default void setBlockState(@NonNull Vector location, @NonNull BlockState state) {
        setBlockState(location.getBlockX(), location.getBlockY(), location.getBlockZ(), state);
    }

    /**
     * Gets the {@link BlockState} at a location.
     *
     * @param location Location to get block state from.
     * @return The block state.
     */
    @NonNull
    default BlockState getBlockState(@NonNull Vector location) {
        return getBlockState(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    /**
     * Schedules a block update at (x, y, z).
     *
     * @param x X coordinate
     * @param y Y coordinate
     * @param z Z coordinate
     */
    void scheduleBlockUpdate(int x, int y, int z);

    /**
     * Schedules a block update at a vector location.
     *
     * @param location {@link Vector} representing the position of the block to update.
     */
    default void scheduleBlockUpdate(@NonNull Vector location) {
        scheduleBlockUpdate(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    /**
     * Schedules a fluid update at (x, y, z).
     *
     * @param x X coordinate
     * @param y Y coordinate
     * @param z Z coordinate
     */
    void scheduleFluidUpdate(int x, int y, int z);

    /**
     * Schedules a fluid update at a vector location.
     *
     * @param location {@link Vector} representing the position of the block to update.
     */
    default void scheduleFluidUpdate(@NonNull Vector location) {
        scheduleFluidUpdate(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    /**
     * Gets the {@link World} object this region represents.
     * <p>
     * Do <b>not</b> attempt to read from/write to this world! Doing so during generation <b>will cause a deadlock!</b>
     *
     * @return The {@link World} object that this region represents.
     */
    @NonNull
    World getWorld();

    /**
     * Gets the {@link BlockData} of the block at the provided coordinates.
     *
     * @param vector {@link Vector} representing the position of the block to get.
     * @return {@link BlockData} at the coordinates
     */
    @NonNull
    default BlockData getBlockData(@NonNull Vector vector) {
        return getBlockData(vector.getBlockX(), vector.getBlockY(), vector.getBlockZ());
    }

    /**
     * Gets the X-coordinate of the chunk in the center of the region.
     *
     * @return The center chunk's X coordinate.
     */
    int getCenterChunkX();

    /**
     * Gets the X-coordinate of the block in the center of the region.
     *
     * @return The center chunk's X coordinate.
     */
    default int getCenterBlockX() {
        return getCenterChunkX() << 4;
    }

    /**
     * Gets the Z-coordinate of the chunk in the center of the region.
     *
     * @return The center chunk's Z coordinate.
     */
    int getCenterChunkZ();

    /**
     * Gets the Z-coordinate of the block in the center of the region.
     *
     * @return The center chunk's Z coordinate.
     */
    default int getCenterBlockZ() {
        return getCenterChunkZ() << 4;
    }
    // Paper end
}

