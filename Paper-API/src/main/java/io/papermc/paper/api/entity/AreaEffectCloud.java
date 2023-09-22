package io.papermc.paper.api.entity;

import io.papermc.paper.api.block.color.Color;
import io.papermc.paper.api.particle.Particle;
import io.papermc.paper.api.projectilesource.ProjectileSource;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;
import java.util.UUID;

/**
 * Represents an area effect cloud which will imbue a potion effect onto
 * entities which enter it.
 */
public interface AreaEffectCloud extends Entity {

    /**
     * Gets the duration which this cloud will exist for (in ticks).
     *
     * @return cloud duration
     */
    int getDuration();

    /**
     * Sets the duration which this cloud will exist for (in ticks).
     *
     * @param duration cloud duration
     */
    void setDuration(int duration);

    /**
     * Gets the time which an entity has to be exposed to the cloud before the
     * effect is applied.
     *
     * @return wait time
     */
    int getWaitTime();

    /**
     * Sets the time which an entity has to be exposed to the cloud before the
     * effect is applied.
     *
     * @param waitTime wait time
     */
    void setWaitTime(int waitTime);

    /**
     * Gets the time that an entity will be immune from subsequent exposure.
     *
     * @return reapplication delay
     */
    int getReapplicationDelay();

    /**
     * Sets the time that an entity will be immune from subsequent exposure.
     *
     * @param delay reapplication delay
     */
    void setReapplicationDelay(int delay);

    /**
     * Gets the amount that the duration of this cloud will decrease by when it
     * applies an effect to an entity.
     *
     * @return duration on use delta
     */
    int getDurationOnUse();

    /**
     * Sets the amount that the duration of this cloud will decrease by when it
     * applies an effect to an entity.
     *
     * @param duration duration on use delta
     */
    void setDurationOnUse(int duration);

    /**
     * Gets the initial radius of the cloud.
     *
     * @return radius
     */
    float getRadius();

    /**
     * Sets the initial radius of the cloud.
     *
     * @param radius radius
     */
    void setRadius(float radius);

    /**
     * Gets the amount that the radius of this cloud will decrease by when it
     * applies an effect to an entity.
     *
     * @return radius on use delta
     */
    float getRadiusOnUse();

    /**
     * Sets the amount that the radius of this cloud will decrease by when it
     * applies an effect to an entity.
     *
     * @param radius radius on use delta
     */
    void setRadiusOnUse(float radius);

    /**
     * Gets the amount that the radius of this cloud will decrease by each tick.
     *
     * @return radius per tick delta
     */
    float getRadiusPerTick();

    /**
     * Gets the amount that the radius of this cloud will decrease by each tick.
     *
     * @param radius per tick delta
     */
    void setRadiusPerTick(float radius);

    /**
     * Gets the particle which this cloud will be composed of
     *
     * @return particle the set particle type
     */
    @NonNull
    Particle getParticle();

    /**
     * Sets the particle which this cloud will be composed of
     *
     * @param particle the new particle type
     */
    void setParticle(@NonNull Particle particle);

    /**
     * Sets the particle which this cloud will be composed of
     *
     * @param <T> type of particle data (see {@link Particle#getDataType()}
     * @param particle the new particle type
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    <T> void setParticle(@NonNull Particle particle, @Nullable T data);

    /**
     * Sets the underlying potion data
     *
     * @param data PotionData to set the base potion state to
     */
    void setBasePotionData(@NonNull PotionData data);

    /**
     * Returns the potion data about the base potion
     *
     * @return a PotionData object
     */
    @NonNull
    PotionData getBasePotionData();

    /**
     * Checks for the presence of custom potion effects.
     *
     * @return true if custom potion effects are applied
     */
    boolean hasCustomEffects();

    /**
     * Gets an immutable list containing all custom potion effects applied to
     * this cloud.
     * <p>
     * Plugins should check that hasCustomEffects() returns true before calling
     * this method.
     *
     * @return the immutable list of custom potion effects
     */
    @NonNull
    List<PotionEffect> getCustomEffects();

    /**
     * Adds a custom potion effect to this cloud.
     *
     * @param effect the potion effect to add
     * @param overwrite true if any existing effect of the same type should be
     * overwritten
     * @return true if the effect was added as a result of this call
     */
    boolean addCustomEffect(@NonNull PotionEffect effect, boolean overwrite);

    /**
     * Removes a custom potion effect from this cloud.
     *
     * @param type the potion effect type to remove
     * @return true if the an effect was removed as a result of this call
     */
    boolean removeCustomEffect(@NonNull PotionEffectType type);

    /**
     * Checks for a specific custom potion effect type on this cloud.
     *
     * @param type the potion effect type to check for
     * @return true if the potion has this effect
     */
    boolean hasCustomEffect(@Nullable PotionEffectType type);

    /**
     * Removes all custom potion effects from this cloud.
     */
    void clearCustomEffects();

    /**
     * Gets the color of this cloud. Will be applied as a tint to its particles.
     *
     * @return cloud color
     */
    @NonNull
    Color getColor();

    /**
     * Sets the color of this cloud. Will be applied as a tint to its particles.
     *
     * @param color cloud color
     */
    void setColor(@NonNull Color color);

    /**
     * Retrieve the original source of this cloud.
     *
     * @return the {@link ProjectileSource} that threw the LingeringPotion
     */
    @Nullable ProjectileSource getSource();

    /**
     * Set the original source of this cloud.
     *
     * @param source the {@link ProjectileSource} that threw the LingeringPotion
     */
    void setSource(@Nullable ProjectileSource source);

    /**
     * Get the entity UUID for the owner of this area effect cloud.
     *
     * @return the entity owner uuid or null
     */
    @Nullable UUID getOwnerUniqueId();

    /**
     * Sets the entity UUID for the owner of this area effect cloud.
     *
     * @param ownerUuid the entity owner uuid or null to clear
     */
    void setOwnerUniqueId(@Nullable UUID ownerUuid);
}

