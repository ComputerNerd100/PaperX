package io.papermc.paper.api.entity;

import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.sound.Sound;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents an entity that can be bucketed.
 */
public interface Bucketable extends Entity {

    /**
     * Gets if this entity originated from a bucket.
     *
     * @return originated from bucket
     */
    boolean isFromBucket();

    /**
     * Sets if this entity originated from a bucket.
     *
     * @param fromBucket is from a bucket
     */
    void setFromBucket(boolean fromBucket);

    /**
     * Gets the base itemstack of this entity in a bucket form.
     *
     * @return bucket form
     */
    @NonNull
    ItemStack getBaseBucketItem();

    /**
     * Gets the sound that is played when this entity
     * is picked up in a bucket.
     * @return bucket pickup sound
     */
    @NonNull
    Sound getPickupSound();
}

