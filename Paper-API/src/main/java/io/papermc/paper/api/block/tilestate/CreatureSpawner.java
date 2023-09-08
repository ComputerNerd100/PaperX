package io.papermc.paper.api.block.tilestate;


import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a captured state of a creature spawner.
 */
public interface CreatureSpawner extends TileState {

    /**
     * Get the spawner's creature type.
     *
     * @return The creature type or null if it not set.
     */
    @Nullable
    EntityType getSpawnedType();

    /**
     * Set the spawner's creature type.
     *
     * @param creatureType The creature type or null to clear.
     */
    void setSpawnedType(@Nullable EntityType creatureType);

    /**
     * Set the spawner mob type.
     *
     * @param creatureType The creature type's name or null to clear.
     * @deprecated magic value, use
     * {@link #setSpawnedType(org.bukkit.entity.EntityType)}.
     */
    @Deprecated
    void setCreatureTypeByName(@Nullable String creatureType);

    /**
     * Get the spawner's creature type.
     *
     * @return The creature type's name if is set.
     * @deprecated magic value, use {@link #getSpawnedType()}.
     */
    @Deprecated
    @Nullable
    String getCreatureTypeName();

    /**
     * Get the spawner's delay.
     * <br>
     * This is the delay, in ticks, until the spawner will spawn its next mob.
     *
     * @return The delay.
     */
    int getDelay();

    /**
     * Set the spawner's delay.
     * <br>
     * If set to -1, the spawn delay will be reset to a random value between
     * {@link #getMinSpawnDelay} and {@link #getMaxSpawnDelay()}.
     *
     * @param delay The delay.
     */
    void setDelay(int delay);

    /**
     * The minimum spawn delay amount (in ticks).
     * <br>
     * This value is used when the spawner resets its delay (for any reason).
     * It will choose a random number between {@link #getMinSpawnDelay()}
     * and {@link #getMaxSpawnDelay()} for its next {@link #getDelay()}.
     * <br>
     * Default value is 200 ticks.
     *
     * @return the minimum spawn delay amount
     */
    int getMinSpawnDelay();

    /**
     * Set the minimum spawn delay amount (in ticks).
     *
     * @param delay the minimum spawn delay amount
     * @see #getMinSpawnDelay()
     */
    void setMinSpawnDelay(int delay);

    /**
     * The maximum spawn delay amount (in ticks).
     * <br>
     * This value is used when the spawner resets its delay (for any reason).
     * It will choose a random number between {@link #getMinSpawnDelay()}
     * and {@link #getMaxSpawnDelay()} for its next {@link #getDelay()}.
     * <br>
     * This value <b>must</b> be greater than 0 and less than or equal to
     * {@link #getMaxSpawnDelay()}.
     * <br>
     * Default value is 800 ticks.
     *
     * @return the maximum spawn delay amount
     */
    int getMaxSpawnDelay();

    /**
     * Set the maximum spawn delay amount (in ticks).
     * <br>
     * This value <b>must</b> be greater than 0, as well as greater than or
     * equal to {@link #getMinSpawnDelay()}
     *
     * @param delay the new maximum spawn delay amount
     * @see #getMaxSpawnDelay()
     */
    void setMaxSpawnDelay(int delay);

    /**
     * Get how many mobs attempt to spawn.
     * <br>
     * Default value is 4.
     *
     * @return the current spawn count
     */
    int getSpawnCount();

    /**
     * Set how many mobs attempt to spawn.
     *
     * @param spawnCount the new spawn count
     */
    void setSpawnCount(int spawnCount);

    /**
     * Set the new maximum amount of similar entities that are allowed to be
     * within spawning range of this spawner.
     * <br>
     * If more than the maximum number of entities are within range, the spawner
     * will not spawn and try again with a new {@link #getDelay()}.
     * <br>
     * Default value is 16.
     *
     * @return the maximum number of nearby, similar, entities
     */
    int getMaxNearbyEntities();

    /**
     * Set the maximum number of similar entities that are allowed to be within
     * spawning range of this spawner.
     * <br>
     * Similar entities are entities that are of the same {@link EntityType}
     *
     * @param maxNearbyEntities the maximum number of nearby, similar, entities
     */
    void setMaxNearbyEntities(int maxNearbyEntities);

    /**
     * Get the maximum distance(squared) a player can be in order for this
     * spawner to be active.
     * <br>
     * If this value is less than or equal to 0, this spawner is always active
     * (given that there are players online).
     * <br>
     * Default value is 16.
     *
     * @return the maximum distance(squared) a player can be in order for this
     * spawner to be active.
     */
    int getRequiredPlayerRange();

    /**
     * Set the maximum distance (squared) a player can be in order for this
     * spawner to be active.
     * <br>
     * Setting this value to less than or equal to 0 will make this spawner
     * always active (given that there are players online).
     *
     * @param requiredPlayerRange the maximum distance (squared) a player can be
     * in order for this spawner to be active.
     */
    void setRequiredPlayerRange(int requiredPlayerRange);

    /**
     * Get the radius around which the spawner will attempt to spawn mobs in.
     * <br>
     * This area is square, includes the block the spawner is in, and is
     * centered on the spawner's x,z coordinates - not the spawner itself.
     * <br>
     * It is 2 blocks high, centered on the spawner's y-coordinate (its bottom);
     * thus allowing mobs to spawn as high as its top surface and as low
     * as 1 block below its bottom surface.
     * <br>
     * Default value is 4.
     *
     * @return the spawn range
     */
    int getSpawnRange();

    /**
     * Set the new spawn range.
     * <br>
     *
     * @param spawnRange the new spawn range
     * @see #getSpawnRange()
     */
    void setSpawnRange(int spawnRange);

    // Paper start
    /**
     * Check if spawner is activated (a player is close enough)
     *
     * @return True if a player is close enough to activate it
     */
    boolean isActivated();

    /**
     * Resets the spawn delay timer within the min/max range
     */
    void resetTimer();

    /**
     * Sets the {@link EntityType} to {@link EntityType#DROPPED_ITEM} and sets the data to the given
     * {@link org.bukkit.inventory.ItemStack ItemStack}.
     * <p>
     * {@link #setSpawnCount(int)} does not dictate the amount of items in the stack spawned, but rather how many
     * stacks should be spawned.
     *
     * @param itemStack The item to spawn. Must not {@link org.bukkit.Material#isAir be air}.
     * @see #setSpawnedType(EntityType)
     */
    void setSpawnedItem(@NonNull ItemStack itemStack);
    // Paper end
}
