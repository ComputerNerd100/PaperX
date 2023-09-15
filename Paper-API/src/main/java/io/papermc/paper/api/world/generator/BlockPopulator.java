package io.papermc.paper.api.world.generator;

import io.papermc.paper.api.block.BlockState;
import io.papermc.paper.api.world.World;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Random;

/**
 * A block populator is responsible for generating a small area of blocks.
 * <p>
 * For example, generating glowstone inside the nether or generating dungeons
 * full of treasure
 * <p>
 * A BlockPopulator can be used in combination with a custom {@link ChunkGenerator}
 * by returning it in the method {@link ChunkGenerator#getDefaultPopulators(World)}
 * or by adding it manually to the worlds populator list returned by {@link World#getPopulators()}.
 * <p>
 * When adding a BlockPopulator manually to a world it is recommended to do so during
 * the {@link WorldInitEvent}.
 */
public abstract class BlockPopulator {

    /**
     * Populates an area of blocks at or around the given chunk.
     * <p>
     * Notes:
     * <p>
     * This method should <b>never</b> attempt to get the Chunk at the passed
     * coordinates, as doing so may cause an infinite loop
     * <p>
     * This method should <b>never</b> modify a {@link LimitedRegion} at a later
     * point of time.
     * <p>
     * This method <b>must</b> be completely thread safe and able to handle
     * multiple concurrent callers.
     * <p>
     * No physics are applied, whether or not it is set to true in
     * {@link BlockState#update(boolean, boolean)}
     * <p>
     * <b>Only</b> use the {@link BlockState} returned by
     * {@link LimitedRegion},
     * <b>never</b> use methods from a {@link World} to modify the chunk.
     *
     * @param worldInfo The world info of the world to generate in
     * @param random The random generator to use
     * @param chunkX The X-coordinate of the chunk
     * @param chunkZ The Z-coordinate of the chunk
     * @param limitedRegion The chunk region to populate
     */
    public void populate(@NonNull WorldInfo worldInfo, @NonNull Random random, int chunkX, int chunkZ, @NonNull LimitedRegion limitedRegion) {
    }
}

