package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.EquipmentSlot;
import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.material.Material;

/**
 * This event is called whenever a player captures an entity in a bucket.
 */
public interface PlayerBucketEntityEvent extends CancellablePlayerEvent {

    /**
     * Gets the {@link Entity} being put into the bucket.
     *
     * @return The {@link Entity} being put into the bucket
     */
    @Param(1)
    Entity entity();

    /**
     * Gets the bucket used to capture the {@link Entity}.
     *
     * This refers to the bucket clicked with, eg {@link Material#WATER_BUCKET}.
     *
     * @return The used bucket
     */
    @Param(2)
    ItemStack originalBucket();

    /**
     * Gets the bucket that the {@link Entity} will be put into.
     *
     * This refers to the bucket with the entity, eg
     * {@link Material#PUFFERFISH_BUCKET}.
     *
     * @return The bucket that the {@link Entity} will be put into
     */
    @Param(3)
    ItemStack entityBucket();

    /**
     * Get the hand that was used to bucket the entity.
     *
     * @return the hand
     */
    @Param(4)
    EquipmentSlot hand();
}
