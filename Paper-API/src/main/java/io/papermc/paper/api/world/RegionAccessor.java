package io.papermc.paper.api.world;

import io.papermc.paper.api.block.BlockState;
import io.papermc.paper.api.block.data.BlockData;
import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.entity.EntityType;
import io.papermc.paper.api.entity.LivingEntity;
import io.papermc.paper.api.entity.Mob;
import io.papermc.paper.api.event.events.entity.CreatureSpawnEvent;
import io.papermc.paper.api.location.Location;
import io.papermc.paper.api.material.Material;
import io.papermc.paper.api.material.TreeType;
import io.papermc.paper.api.namespace.Keyed;
import io.papermc.paper.api.namespace.NamespacedKey;
import io.papermc.paper.api.util.BoundingBox;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * A RegionAccessor gives access to getting, modifying and spawning {@link Biome}, {@link BlockState} and {@link Entity},
 * as well as generating some basic structures.
 */
public interface RegionAccessor extends Keyed {

    /**
     * Gets the {@link Biome} at the given {@link Location}.
     *
     * @param location the location of the biome
     * @return Biome at the given location
     * @see #getComputedBiome(int, int, int)
     */
    @NonNull
    Biome getBiome(@NonNull Location location);

    /**
     * Gets the {@link Biome} at the given coordinates.
     *
     * @param x X-coordinate of the block
     * @param y Y-coordinate of the block
     * @param z Z-coordinate of the block
     * @return Biome at the given coordinates
     * @see #getComputedBiome(int, int, int)
     */
    @NonNull
    Biome getBiome(int x, int y, int z);

    // Paper start
    /**
     * Gets the computed {@link Biome} at the given coordinates.
     *
     * <p>The computed Biome is the Biome as seen by clients for rendering
     * purposes and in the "F3" debug menu. This is computed by looking at the noise biome
     * at this and surrounding quarts and applying complex math operations.</p>
     *
     * <p>Most other Biome-related methods named getBiome, setBiome, and similar
     * operate on the "noise biome", which is stored per-quart, or in other words,
     * 1 Biome per 4x4x4 block region. This is how Biomes are currently generated and
     * stored on disk.</p>
     *
     * @param x X-coordinate of the block
     * @param y Y-coordinate of the block
     * @param z Z-coordinate of the block
     * @return Biome at the given coordinates
     */
    @NonNull
    Biome getComputedBiome(int x, int y, int z);
    // Paper end

    /**
     * Sets the {@link Biome} at the given {@link Location}.
     *
     * @param location the location of the biome
     * @param biome New Biome type for this block
     */
    void setBiome(@NonNull Location location, @NonNull Biome biome);

    /**
     * Sets the {@link Biome} for the given block coordinates
     *
     * @param x X-coordinate of the block
     * @param y Y-coordinate of the block
     * @param z Z-coordinate of the block
     * @param biome New Biome type for this block
     */
    void setBiome(int x, int y, int z, @NonNull Biome biome);

    /**
     * Gets the {@link BlockState} at the given {@link Location}.
     *
     * @param location The location of the block state
     * @return Block state at the given location
     */
    @NonNull
    BlockState getBlockState(@NonNull Location location);

    /**
     * Gets the {@link BlockState} at the given coordinates.
     *
     * @param x X-coordinate of the block state
     * @param y Y-coordinate of the block state
     * @param z Z-coordinate of the block state
     * @return Block state at the given coordinates
     */
    @NonNull
    BlockState getBlockState(int x, int y, int z);

    /**
     * Gets the {@link BlockData} at the given {@link Location}.
     *
     * @param location The location of the block data
     * @return Block data at the given location
     */
    @NonNull
    BlockData getBlockData(@NonNull Location location);

    /**
     * Gets the {@link BlockData} at the given coordinates.
     *
     * @param x X-coordinate of the block data
     * @param y Y-coordinate of the block data
     * @param z Z-coordinate of the block data
     * @return Block data at the given coordinates
     */
    @NonNull
    BlockData getBlockData(int x, int y, int z);

    /**
     * Gets the type of the block at the given {@link Location}.
     *
     * @param location The location of the block
     * @return Material at the given coordinates
     */
    @NonNull
    Material getType(@NonNull Location location);

    /**
     * Gets the type of the block at the given coordinates.
     *
     * @param x X-coordinate of the block
     * @param y Y-coordinate of the block
     * @param z Z-coordinate of the block
     * @return Material at the given coordinates
     */
    @NonNull
    Material getType(int x, int y, int z);

    /**
     * Sets the {@link BlockData} at the given {@link Location}.
     *
     * @param location The location of the block
     * @param blockData The block data to set the block to
     */
    void setBlockData(@NonNull Location location, @NonNull BlockData blockData);

    /**
     * Sets the {@link BlockData} at the given coordinates.
     *
     * @param x X-coordinate of the block
     * @param y Y-coordinate of the block
     * @param z Z-coordinate of the block
     * @param blockData The block data to set the block to
     */
    void setBlockData(int x, int y, int z, @NonNull BlockData blockData);

    /**
     * Sets the {@link Material} at the given {@link Location}.
     *
     * @param location The location of the block
     * @param material The type to set the block to
     */
    void setType(@NonNull Location location, @NonNull Material material);

    /**
     * Sets the {@link Material} at the given coordinates.
     *
     * @param x X-coordinate of the block
     * @param y Y-coordinate of the block
     * @param z Z-coordinate of the block
     * @param material The type to set the block to
     */
    void setType(int x, int y, int z, @NonNull Material material);

    /**
     * Creates a tree at the given {@link Location}
     *
     * @param location Location to spawn the tree
     * @param random Random to use to generate the tree
     * @param type Type of the tree to create
     * @return true if the tree was created successfully, otherwise false
     */
    boolean generateTree(@NonNull Location location, @NonNull Random random, @NonNull TreeType type);

    /**
     * Creates a tree at the given {@link Location}
     * <p>
     * The provided consumer gets called for every block which gets changed
     * as a result of the tree generation. When the consumer gets called no
     * modifications to the world are done yet. Which means, that calling
     * {@link #getBlockState(Location)} in the consumer will return the state
     * of the block before the generation.
     * <p>
     * Modifications done to the {@link BlockState} in the consumer are respected,
     * which means that it is not necessary to call {@link BlockState#update()}
     *
     * @param location Location to spawn the tree
     * @param random Random to use to generate the tree
     * @param type Type of the tree to create
     * @param stateConsumer The consumer which should get called for every block which gets changed
     * @return true if the tree was created successfully, otherwise false
     */
    boolean generateTree(@NonNull Location location, @NonNull Random random, @NonNull TreeType type, @Nullable Consumer<BlockState> stateConsumer);

    /**
     * Creates a tree at the given {@link Location}
     * <p>
     * The provided predicate gets called for every block which gets changed
     * as a result of the tree generation. When the predicate gets called no
     * modifications to the world are done yet. Which means, that calling
     * {@link #getBlockState(Location)} in the predicate will return the state
     * of the block before the generation.
     * <p>
     * If the predicate returns {@code true} the block gets set in the world.
     * If it returns {@code false} the block won't get set in the world.
     *
     * @param location Location to spawn the tree
     * @param random Random to use to generate the tree
     * @param type Type of the tree to create
     * @param statePredicate The predicate which should get used to test if a block should be set or not.
     * @return true if the tree was created successfully, otherwise false
     */
    boolean generateTree(@NonNull Location location, @NonNull Random random, @NonNull TreeType type, @Nullable Predicate<BlockState> statePredicate);

    /**
     * Creates a entity at the given {@link Location}
     *
     * @param location The location to spawn the entity
     * @param type The entity to spawn
     * @return Resulting Entity of this method
     */
    @NonNull
    Entity spawnEntity(@NonNull Location location, @NonNull EntityType type);

    /**
     * Creates a new entity at the given {@link Location}.
     *
     * @param loc the location at which the entity will be spawned.
     * @param type the entity type that determines the entity to spawn.
     * @param randomizeData whether or not the entity's data should be randomised
     *                      before spawning. By default entities are randomised
     *                      before spawning in regards to their equipment, age,
     *                      attributes, etc.
     *                      An example of this randomization would be the color of
     *                      a sheep, random enchantments on the equipment of mobs
     *                      or even a zombie becoming a chicken jockey.
     *                      If set to false, the entity will not be randomised
     *                      before spawning, meaning all their data will remain
     *                      in their default state and not further modifications
     *                      to the entity will be made.
     *                      Notably only entities that extend the
     *                      {@link Mob} interface provide
     *                      randomisation logic for their spawn.
     *                      This parameter is hence useless for any other type
     *                      of entity.
     * @return the spawned entity instance.
     */
    @NonNull
    public Entity spawnEntity(@NonNull Location loc, @NonNull EntityType type, boolean randomizeData);

    /**
     * Get a list of all entities in this RegionAccessor
     *
     * @return A List of all Entities currently residing in this world accessor
     */
    @NonNull
    List<Entity> getEntities();

    /**
     * Get a list of all living entities in this RegionAccessor
     *
     * @return A List of all LivingEntities currently residing in this world accessor
     */
    @NonNull
    List<LivingEntity> getLivingEntities();

    /**
     * Get a collection of all entities in this RegionAccessor matching the given
     * class/interface
     *
     * @param <T> an entity subclass
     * @param cls The class representing the type of entity to match
     * @return A List of all Entities currently residing in this world accessor
     *     that match the given class/interface
     */
    @NonNull
    <T extends Entity> Collection<T> getEntitiesByClass(@NonNull Class<T> cls);

    /**
     * Get a collection of all entities in this RegionAccessor matching any of the
     * given classes/interfaces
     *
     * @param classes The classes representing the types of entity to match
     * @return A List of all Entities currently residing in this world accessor
     *     that match one or more of the given classes/interfaces
     */
    @NonNull
    Collection<Entity> getEntitiesByClasses(@NonNull Class<?>... classes);

    /**
     * Spawn an entity of a specific class at the given {@link Location}
     *
     * @param location the {@link Location} to spawn the entity at
     * @param clazz the class of the {@link Entity} to spawn
     * @param <T> the class of the {@link Entity} to spawn
     * @return an instance of the spawned {@link Entity}
     * @throws IllegalArgumentException if either parameter is null or the
     *     {@link Entity} requested cannot be spawned
     */
    @NonNull
    <T extends Entity> T spawn(@NonNull Location location, @NonNull Class<T> clazz) throws IllegalArgumentException;

    /**
     * Spawn an entity of a specific class at the given {@link Location}, with
     * the supplied function run before the entity is added to the world.
     * <br>
     * Note that when the function is run, the entity will not be actually in
     * the world. Any operation involving such as teleporting the entity is undefined
     * until after this function returns.
     *
     * @param location the {@link Location} to spawn the entity at
     * @param clazz the class of the {@link Entity} to spawn
     * @param function the function to be run before the entity is spawned.
     * @param <T> the class of the {@link Entity} to spawn
     * @return an instance of the spawned {@link Entity}
     * @throws IllegalArgumentException if either parameter is null or the
     *     {@link Entity} requested cannot be spawned
     */
    @NonNull
    // Paper start
    public default <T extends Entity> T spawn(@NonNull Location location, @NonNull Class<T> clazz, @Nullable Consumer<T> function) throws IllegalArgumentException {
        return spawn(location, clazz, CreatureSpawnEvent.SpawnReason.CUSTOM, function);
    }

    @NonNull
    public default <T extends Entity> T spawn(@NonNull Location location, @NonNull Class<T> clazz, CreatureSpawnEvent.@NonNull SpawnReason reason) throws IllegalArgumentException {
        return spawn(location, clazz, reason, null);
    }

    @NonNull
    public default <T extends Entity> T spawn(@NonNull Location location, @NonNull Class<T> clazz, CreatureSpawnEvent.@NonNull SpawnReason reason, @Nullable Consumer<T> function) throws IllegalArgumentException {
        return spawn(location, clazz, function, reason);
    }

    @NonNull
    public default Entity spawnEntity(@NonNull Location loc, @NonNull EntityType type, CreatureSpawnEvent.@NonNull SpawnReason reason) {
        return spawn(loc, (Class<Entity>) type.getEntityClass(), reason, null);
    }

    @NonNull
    public default Entity spawnEntity(@NonNull Location loc, @NonNull EntityType type, CreatureSpawnEvent.@NonNull SpawnReason reason, @Nullable Consumer<Entity> function) {
        return spawn(loc, (Class<Entity>) type.getEntityClass(), reason, function);
    }

    @NonNull
    public <T extends Entity> T spawn(@NonNull Location location, @NonNull Class<T> clazz, @Nullable Consumer<T> function, CreatureSpawnEvent.@NonNull SpawnReason reason) throws IllegalArgumentException;

    /**
     * Creates a new entity at the given {@link Location} with the supplied
     * function run before the entity is added to the world.
     * <br>
     * Note that when the function is run, the entity will not be actually in
     * the world. Any operation involving such as teleporting the entity is undefined
     * until after this function returns.
     * The passed function however is run after the potential entity's spawn
     * randomization and hence already allows access to the values of the mob,
     * whether or not those were randomized, such as attributes or the entity
     * equipment.
     *
     * @param location      the location at which the entity will be spawned.
     * @param clazz         the class of the {@link Entity} that is to be spawned.
     * @param <T>           the generic type of the entity that is being created.
     * @param randomizeData whether or not the entity's data should be randomised
     *                      before spawning. By default entities are randomised
     *                      before spawning in regards to their equipment, age,
     *                      attributes, etc.
     *                      An example of this randomization would be the color of
     *                      a sheep, random enchantments on the equipment of mobs
     *                      or even a zombie becoming a chicken jockey.
     *                      If set to false, the entity will not be randomised
     *                      before spawning, meaning all their data will remain
     *                      in their default state and not further modifications
     *                      to the entity will be made.
     *                      Notably only entities that extend the
     *                      {@link Mob} interface provide
     *                      randomisation logic for their spawn.
     *                      This parameter is hence useless for any other type
     *                      of entity.
     * @param function      the function to be run before the entity is spawned.
     * @return the spawned entity instance.
     * @throws IllegalArgumentException if either the world or clazz parameter are null.
     */
    @NonNull
    public <T extends Entity> T spawn(@NonNull Location location, @NonNull Class<T> clazz, boolean randomizeData, @Nullable Consumer<T> function) throws IllegalArgumentException;

    /**
     * Gets the highest non-empty (impassable) coordinate at the given
     * coordinates.
     *
     * @param x X-coordinate of the blocks
     * @param z Z-coordinate of the blocks
     * @return Y-coordinate of the highest non-empty block
     */
    public int getHighestBlockYAt(int x, int z);

    /**
     * Gets the highest non-empty (impassable) coordinate at the given
     * {@link Location}.
     *
     * @param location Location of the blocks
     * @return Y-coordinate of the highest non-empty block
     */
    public int getHighestBlockYAt(@NonNull Location location);

    /**
     * Gets the highest coordinate corresponding to the {@link HeightMap} at the
     * given coordinates.
     *
     * @param x X-coordinate of the blocks
     * @param z Z-coordinate of the blocks
     * @param heightMap the heightMap that is used to determine the highest
     * point
     *
     * @return Y-coordinate of the highest block corresponding to the
     * {@link HeightMap}
     */
    public int getHighestBlockYAt(int x, int z, @NonNull HeightMap heightMap);

    /**
     * Gets the highest coordinate corresponding to the {@link HeightMap} at the
     * given {@link Location}.
     *
     * @param location Location of the blocks
     * @param heightMap the heightMap that is used to determine the highest
     * point
     * @return Y-coordinate of the highest block corresponding to the
     * {@link HeightMap}
     */
    public int getHighestBlockYAt(@NonNull Location location, @NonNull HeightMap heightMap);

    // Paper start
    /**
     * @return the current moon phase at the current time in the world
     */
    @NonNull
    MoonPhase getMoonPhase();

    /**
     * Get the world's key
     *
     * @return the world's key
     */
    @NonNull
    @Override
    NamespacedKey getKey();

    /**
     * Tell whether a line of sight exists between the given locations
     * @param from Location to start at
     * @param to target Location
     * @return whether a line of sight exists between {@code from} and {@code to}
     */
    public boolean lineOfSightExists(@NonNull Location from, @NonNull Location to);

    /**
     * Checks if the world collides with the given boundingbox.
     * This will check for any colliding hard entities (boats, shulkers) / worldborder / blocks.
     * Does not load chunks that are within the bounding box.
     *
     * @param boundingBox the box to check collisions in
     * @return collides or not
     */
    boolean hasCollisionsIn(@NonNull BoundingBox boundingBox);
}

