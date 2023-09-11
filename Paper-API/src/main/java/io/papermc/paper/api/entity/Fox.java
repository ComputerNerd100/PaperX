package io.papermc.paper.api.entity;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * What does the fox say?
 */
public interface Fox extends Animals, Sittable {

    /**
     * Gets the current type of this fox.
     *
     * @return Type of the fox.
     */
    @NonNull Type getFoxType();

    /**
     * Sets the current type of this fox.
     *
     * @param type New type of this fox.
     */
    void setFoxType(@NonNull Type type);

    /**
     * Checks if this animal is crouching
     *
     * @return true if crouching
     */
    boolean isCrouching();

    /**
     * Sets if this animal is crouching.
     *
     * @param crouching true if crouching
     */
    void setCrouching(boolean crouching);

    /**
     * Sets if this animal is sleeping.
     *
     * @param sleeping true if sleeping
     */
    void setSleeping(boolean sleeping);

    /**
     * Gets the first trusted player.
     *
     * @return the owning AnimalTamer, or null if not owned
     */
    @Nullable AnimalTamer getFirstTrustedPlayer();

    /**
     * Set the first trusted player.
     * <p>
     * The first trusted player may only be removed after the second.
     *
     * @param player the AnimalTamer to be trusted
     */
    void setFirstTrustedPlayer(@Nullable AnimalTamer player);

    /**
     * Gets the second trusted player.
     *
     * @return the owning AnimalTamer, or null if not owned
     */
    @Nullable AnimalTamer getSecondTrustedPlayer();

    /**
     * Set the second trusted player.
     * <p>
     * The second trusted player may only be added after the first.
     *
     * @param player the AnimalTamer to be trusted
     */
    void setSecondTrustedPlayer(@Nullable AnimalTamer player);

    /**
     * Gets whether the fox is faceplanting the ground
     *
     * @return Whether the fox is faceplanting the ground
     */
    boolean isFaceplanted();

    /**
     * Represents the various different fox types there are.
     */
    enum Type {
        RED,
        SNOW
    }

    // Paper start - Add more fox behavior API
    /**
     * Sets if the fox is interested.
     *
     * @param interested is interested
     */
    void setInterested(boolean interested);

    /**
     * Gets if the fox is interested.
     *
     * @return fox is interested
     */
    boolean isInterested();

    /**
     * Sets if the fox is leaping.
     *
     * @param leaping is leaping
     */
    void setLeaping(boolean leaping);

    /**
     * Gets if the fox is leaping.
     *
     * @return fox is leaping
     */
    boolean isLeaping();

    /**
     * Sets if the fox is defending.
     *
     * @param defending is defending
     */
    void setDefending(boolean defending);

    /**
     * Gets if the fox is defending.
     *
     * @return fox is defending
     */
    boolean isDefending();

    /**
     * Sets if the fox face planted.
     *
     * @param faceplanted face planted
     */
    void setFaceplanted(boolean faceplanted);
    // Paper end - Add more fox behavior API
}
