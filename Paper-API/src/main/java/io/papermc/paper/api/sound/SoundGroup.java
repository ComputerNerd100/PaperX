package io.papermc.paper.api.sound;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a group of sounds for blocks that are played when various actions
 * happen (ie stepping, breaking, hitting, etc).
 */
public interface SoundGroup {

    /**
     * Get the volume these sounds are played at.
     *
     * Note that this volume does not always represent the actual volume
     * received by the client.
     *
     * @return volume
     */
    float getVolume();

    /**
     * Gets the pitch these sounds are played at.
     *
     * Note that this pitch does not always represent the actual pitch received
     * by the client.
     *
     * @return pitch
     */
    float getPitch();

    /**
     * Gets the corresponding breaking sound for this group.
     *
     * @return the break sound
     */
    @NonNull Sound getBreakSound();

    /**
     * Gets the corresponding step sound for this group.
     *
     * @return the step sound
     */
    @NonNull Sound getStepSound();

    /**
     * Gets the corresponding place sound for this group.
     *
     * @return the place sound
     */
    @NonNull Sound getPlaceSound();

    /**
     * Gets the corresponding hit sound for this group.
     *
     * @return the hit sound
     */
    @NonNull Sound getHitSound();

    /**
     * Gets the corresponding fall sound for this group.
     *
     * @return the fall sound
     */
    @NonNull Sound getFallSound();
}

