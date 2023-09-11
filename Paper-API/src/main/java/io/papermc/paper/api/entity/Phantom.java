package io.papermc.paper.api.entity;

import io.papermc.paper.api.location.Location;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.UUID;

/**
 * Represents a phantom.
 */
public interface Phantom extends Flying, Enemy {

    /**
     * @return The size of the phantom
     */
    public int getSize();

    /**
     * @param sz The new size of the phantom.
     */
    public void setSize(int sz);

    /**
     * Get the UUID of the entity that caused this phantom to spawn
     *
     * @return UUID
     */
    @Nullable
    public UUID getSpawningEntity();

    /**
     * Check if this phantom will burn in the sunlight
     *
     * @return True if phantom will burn in sunlight
     */
    public boolean shouldBurnInDay();

    /**
     * Set if this phantom should burn in the sunlight
     *
     * @param shouldBurnInDay True to burn in sunlight
     */
    public void setShouldBurnInDay(boolean shouldBurnInDay);

    /**
     * Gets the location that this phantom circles around when not attacking a player
     * This will be changed after attacking a player.
     *
     * @return circling location
     */
    @NonNull
    Location getAnchorLocation();

    /**
     * Sets the location that this phantom circles around when not attacking a player
     *
     * @param location circling location (world is ignored, will always use the entity's world)
     */
    void setAnchorLocation(@NonNull Location location);
}

