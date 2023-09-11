package io.papermc.paper.api.entity;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;


/**
 * Represents a fishing hook.
 */
public interface FishHook extends Projectile {

    /**
     * Get the minimum number of ticks one has to wait for a fish appearing.
     * <p>
     * The default is 100 ticks (5 seconds).<br>
     * Note that this is before applying lure.
     *
     * @return Minimum number of ticks one has to wait for a fish appearing
     */
    int getMinWaitTime();

    /**
     * Set the minimum number of ticks one has to wait for a fish appearing.
     * <p>
     * The default is 100 ticks (5 seconds).<br>
     * Note that this is before applying lure.
     *
     * @param minWaitTime Minimum number of ticks one has to wait for a fish
     * appearing
     */
    void setMinWaitTime(int minWaitTime);

    /**
     * Get the maximum number of ticks one has to wait for a fish appearing.
     * <p>
     * The default is 600 ticks (30 seconds).<br>
     * Note that this is before applying lure.
     *
     * @return Maximum number of ticks one has to wait for a fish appearing
     */
    int getMaxWaitTime();

    /**
     * Set the maximum number of ticks one has to wait for a fish appearing.
     * <p>
     * The default is 600 ticks (30 seconds).<br>
     * Note that this is before applying lure.
     *
     * @param maxWaitTime Maximum number of ticks one has to wait for a fish
     * appearing
     */
    void setMaxWaitTime(int maxWaitTime);

    /**
     * Set both the minimum (default 100) and maximum (default 600) amount
     * of ticks one has to wait for a fish appearing.
     *
     * @param min minimum ticks for a fish to appear
     * @param max maximum ticks for a fish to appear
     */
    void setWaitTime(int min, int max);

    /**
     * Get the minimum number of ticks one has to wait for a fish to bite
     * after appearing.
     * <p>
     * The default is 20 ticks (1 second).<br>
     * Lure does not affect this value.
     * This will also effect the radius (0.1 * lureTime) of where
     * the fish will appear.
     *
     * @return Minimum number of ticks one has to wait for a fish to bite
     */
    int getMinLureTime();

    /**
     * Set the minimum number of ticks one has to wait for a fish to bite
     * after appearing.
     * <p>
     * The default is 20 ticks (1 second).<br>
     * Lure does not affect this value.
     * This will also effect the radius (0.1 * lureTime) of where
     * the fish will appear.
     *
     * @param minLureTime Minimum number of ticks one has to wait for a fish
     * to bite
     */
    void setMinLureTime(int minLureTime);

    /**
     * Get the maximum number of ticks one has to wait for a fish to bite
     * after appearing.
     * <p>
     * The default is 80 ticks (4 second).<br>
     * Lure does not affect this value.
     * This will also effect the radius (0.1 * lureTime) of where
     * the fish will appear.
     *
     * @return Maximum number of ticks one has to wait for a fish to bite
     */
    int getMaxLureTime();

    /**
     * Set the maximum number of ticks one has to wait for a fish to bite
     * after appearing.
     * <p>
     * The default is 80 ticks (4 second).<br>
     * Lure does not affect this value.
     * This will also effect the radius (0.1 * lureTime) of where
     * the fish will appear.
     *
     * @param maxLureTime Maximum number of ticks one has to wait for a fish
     * to bite
     */
    void setMaxLureTime(int maxLureTime);

    /**
     * Set both the minimum (default 20) and maximum (default 80) amount
     * of ticks one has to wait for a fish to bite after appearing.
     *
     * @param min minimum ticks to wait for a bite
     * @param max maximum ticks to wait for a bite
     */
    void setLureTime(int min, int max);

    /**
     * Get the minimum angle (in degrees, 0 being positive Z 90 being negative
     * X) of where a fish will appear after the wait time.
     * <p>
     * The default is 0 degrees.
     *
     * @return Minimum angle of where a fish will appear
     */
    float getMinLureAngle();

    /**
     * Set the minimum angle (in degrees, 0 being positive Z 90 being negative
     * X) of where a fish will appear after the wait time.
     * <p>
     * The default is 0 degrees.
     *
     * @param minLureAngle Minimum angle of where a fish may appear
     */
    void setMinLureAngle(float minLureAngle);

    /**
     * Get the maximum angle (in degrees, 0 being positive Z 90 being negative
     * X) of where a fish will appear after the wait time.
     * <p>
     * The default is 360 degrees.
     *
     * @return Maximum angle of where a fish will appear
     */
    float getMaxLureAngle();

    /**
     * Set the maximum angle (in degrees, 0 being positive Z 90 being negative
     * X) of where a fish will appear after the wait time.
     * <p>
     * The default is 360 degrees.
     *
     * @param maxLureAngle Maximum angle of where a fish may appear
     */
    void setMaxLureAngle(float maxLureAngle);

    /**
     * Set both the minimum (default 0) and maximum (default 360) angle of where
     * a fish will appear after the wait time.
     *
     * 0 degrees is positive Z, 90 degrees is negative X.
     *
     * @param min minimum angle in degrees
     * @param max maximum angle in degrees
     */
    void setLureAngle(float min, float max);

    /**
     * Get whether the lure enchantment should be applied to reduce the wait
     * time.
     * <p>
     * The default is true.<br>
     * Lure reduces the wait time by 100 ticks (5 seconds) for each level of the
     * enchantment.
     *
     * @return Whether the lure enchantment should be applied to reduce the wait
     * time
     */
    boolean getApplyLure();

    /**
     * Set whether the lure enchantment should be applied to reduce the wait
     * time.
     * <p>
     * The default is true.<br>
     * Lure reduces the wait time by 100 ticks (5 seconds) for each level of the
     * enchantment.
     *
     * @param applyLure Whether the lure enchantment should be applied to reduce
     * the wait time
     */
    void setApplyLure(boolean applyLure);

    /**
     * Check whether or not this fish hook is in open water.
     * <p>
     * Open water is defined by a 5x4x5 area of water, air and lily pads. If in
     * open water, treasure items may be caught.
     *
     * @return true if in open water, false otherwise
     */
    boolean isInOpenWater();

    /**
     * Get the entity hooked by this fish hook.
     *
     * @return the hooked entity. null if none
     */
    @Nullable Entity getHookedEntity();

    /**
     * Set the entity hooked by this fish hook.
     *
     * @param entity the entity to set, or null to unhook
     */
    void setHookedEntity(@Nullable Entity entity);

    /**
     * Pull the hooked entity to the caster of this fish hook. If no entity is
     * hooked, this method has no effect.
     *
     * @return true if pulled, false if no entity is hooked
     */
    boolean pullHookedEntity();

    /**
     * Whether or not wait and lure time will be impacted by direct sky access.
     *
     * True by default, causes a 50% time increase on average.
     *
     * @return skylight access influences catch rate
     */
    boolean isSkyInfluenced();

    /**
     * Set whether or not wait and lure time will be impacted by direct sky
     * access.
     *
     * True by default, causes a 50% time increase on average.
     *
     * @param skyInfluenced if this hook is influenced by skylight access
     */
    void setSkyInfluenced(boolean skyInfluenced);

    /**
     * Whether or not wait and lure time will be impacted by rain.
     *
     * True by default, causes a 25% time decrease on average.
     *
     * @return rain influences catch rate
     */
    boolean isRainInfluenced();

    /**
     * Set whether or not wait and lure time will be impacted by rain.
     *
     * True by default, causes a 25% time decrease on average.
     *
     * @param rainInfluenced if this hook is influenced by rain
     */
    void setRainInfluenced(boolean rainInfluenced);

    /**
     * Get the current state of this fish hook.
     *
     * @return the fish hook state
     */
    @NonNull HookState getState();

    /**
     * Represents a state in which a fishing hook may be.
     */
    enum HookState {

        /**
         * The fishing hook has been cast and is either in the air or resting
         * against a block on the ground.
         */
        UNHOOKED,
        /**
         * The fishing hook has hooked an entity.
         */
        HOOKED_ENTITY,
        /**
         * The fishing hook is bobbing in the water, waiting for a bite.
         */
        BOBBING
    }

    /**
     * Get the number of ticks the hook needs to wait for a fish to bite.
     *
     * @return Number of ticks
     */
    int getWaitTime();

    /**
     * Sets the number of ticks the hook needs to wait for a fish to bite.
     *
     * @param ticks Number of ticks
     */
    void setWaitTime(int ticks);
}

