package io.papermc.paper.api.entity;

import io.papermc.paper.api.location.Location;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents a wandering trader NPC
 */
public interface WanderingTrader extends AbstractVillager {

    /**
     * Gets the despawn delay before this {@link WanderingTrader} is forcibly
     * despawned.
     *
     * If this is less than or equal to 0, then the trader will not be
     * despawned.
     *
     * @return The despawn delay before this {@link WanderingTrader} is forcibly
     * despawned
     */
    int getDespawnDelay();

    /**
     * Sets the despawn delay before this {@link WanderingTrader} is forcibly
     * despawned.
     *
     * If this is less than or equal to 0, then the trader will not be
     * despawned.
     *
     * @param despawnDelay The new despawn delay before this
     * {@link WanderingTrader} is forcibly despawned
     */
    void setDespawnDelay(int despawnDelay);

    /**
     * Set if the Wandering Trader can and will drink an invisibility potion.
     * @param bool whether the mob will drink
     */
    void setCanDrinkPotion(boolean bool);

    /**
     * Get if the Wandering Trader can and will drink an invisibility potion.
     * @return whether the mob will drink
     */
    boolean canDrinkPotion();

    /**
     * Set if the Wandering Trader can and will drink milk.
     * @param bool whether the mob will drink
     */
    void setCanDrinkMilk(boolean bool);

    /**
     * Get if the Wandering Trader can and will drink milk.
     * @return whether the mob will drink
     */
    boolean canDrinkMilk();

    /**
     * Gets the location that this wandering trader is currently
     * wandering towards.
     * <p>
     * This will return null if the wandering trader has finished
     * wandering towards the given location.
     *
     * @return the location currently wandering towards, or null if not wandering
     */
    @Nullable
    Location getWanderingTowards();

    /**
     * Sets the location that this wandering trader is currently wandering towards.
     * <p>
     * This can be set to null to prevent the wandering trader from wandering further.
     *
     * @param location location to wander towards (world is ignored, will always use the entity's world)
     */
    void setWanderingTowards(@Nullable Location location);
}

