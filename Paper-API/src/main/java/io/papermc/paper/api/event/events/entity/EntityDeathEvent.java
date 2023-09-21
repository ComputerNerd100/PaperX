package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.LivingEntity;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.sound.Sound;
import io.papermc.paper.api.sound.SoundCategory;

import java.util.List;

/**
 * Thrown whenever a LivingEntity dies
 */
public interface EntityDeathEvent extends CancellableEntityEvent {
    default LivingEntity livingEntity() {
        return (LivingEntity) entity();
    }

    /**
     * Gets all the items which will drop when the entity dies
     *
     * @return Items to drop when the entity dies
     */
    @Param(1)
    List<ItemStack> drops();

    /**
     * Gets how much EXP should be dropped from this death.
     * <p>
     * This does not indicate how much EXP should be taken from the entity in
     * question, merely how much should be created after its death.
     *
     * @return Amount of EXP to drop.
     */
    @Param(2)
    int dropExp();

    /**
     * Get the amount of health that the entity should revive with after cancelling the event.
     * Set to the entity's max health by default.
     *
     * @return The amount of health
     */
    @Param(3)
    double reviveHealth();

    /**
     * Whether or not the death sound should play when the entity dies. If the event is cancelled it does not play!
     *
     * @return Whether or not the death sound should play. Event is called with this set to false if the entity is silent.
     */
    @Param(4)
    boolean shouldPlayDeathSound();

    /**
     * Get the sound that the entity makes when dying
     *
     * @return The sound that the entity makes
     */
    @Param(5)
    Sound deathSound();

    /**
     * Get the sound category that the death sound should play in
     *
     * @return The sound category
     */
    @Param(6)
    SoundCategory deathSoundCategory();

    /**
     * Get the volume that the death sound will play at.
     *
     * @return The volume the death sound will play at
     */
    @Param(7)
    float deathSoundVolume();

    /**
     * Get the pitch that the death sound will play with.
     *
     * @return The pitch the death sound will play with
     */
    @Param(8)
    float deathSoundPitch();
}
