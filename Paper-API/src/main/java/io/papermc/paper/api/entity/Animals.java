package io.papermc.paper.api.entity;

import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.material.Material;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.UUID;

/**
 * Represents an Animal.
 */
public interface Animals extends Breedable {

    /**
     * Get the UUID of the entity that caused this entity to enter the
     * {@link #canBreed()} state.
     *
     * @return uuid if set, or null
     */
    @Nullable
    UUID getBreedCause();

    /**
     * Set the UUID of the entity that caused this entity to enter the
     * {@link #canBreed()} state.
     *
     * @param uuid new uuid, or null
     */
    void setBreedCause(@Nullable UUID uuid);

    /**
     * Get whether or not this entity is in love mode and will produce
     * offspring with another entity in love mode. Will return true if
     * and only if {@link #getLoveModeTicks()} is greater than 0.
     *
     * @return true if in love mode, false otherwise
     */
    boolean isLoveMode();

    /**
     * Get the amount of ticks remaining for this entity in love mode.
     * If the entity is not in love mode, 0 will be returned.
     *
     * @return the remaining love mode ticks
     */
    int getLoveModeTicks();

    /**
     * Set the amount of ticks for which this entity should be in love mode.
     * Setting the love mode ticks to 600 is the equivalent of a player
     * feeding the entity their breeding item of choice.
     *
     * @param ticks the love mode ticks. Must be positive
     */
    void setLoveModeTicks(int ticks);

    /**
     * Check if the provided ItemStack is the correct item used for breeding
     * this entity.
     *
     * @param stack ItemStack to check.
     * @return if the provided ItemStack is the correct food item for this
     * entity.
     */
    boolean isBreedItem(@NonNull ItemStack stack);

    /**
     * Check if the provided ItemStack is the correct item used for breeding
     * this entity..
     *
     * @param material Material to check.
     * @return if the provided ItemStack is the correct food item for this
     * entity.
     */
    boolean isBreedItem(@NonNull Material material);
}

