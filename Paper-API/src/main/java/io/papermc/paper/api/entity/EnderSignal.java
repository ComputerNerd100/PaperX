package io.papermc.paper.api.entity;

import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.location.Location;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents an EnderSignal, which is created upon throwing an ender eye.
 */
public interface EnderSignal extends Entity {

    /**
     * Get the location this EnderSignal is moving towards.
     *
     * @return the {@link Location} this EnderSignal is moving towards.
     */
    @NonNull
    Location getTargetLocation();

    /**
     * Set the {@link Location} this EnderSignal is moving towards.
     * <br>
     * When setting a new target location, the {@link #getDropItem()} resets to
     * a random value and the despawn timer gets set back to 0.
     *
     * @param location the new target location
     */
    void setTargetLocation(@NonNull Location location);

    /**
     * Set the {@link Location} this EnderSignal is moving towards.
     *
     * @param location the new target location
     * @param update true to reset the {@link #getDropItem()}
     *               to a random value and {@link #getDespawnTimer()} to 0
     */
    void setTargetLocation(@NonNull Location location, boolean update);

    /**
     * Gets if the EnderSignal should drop an item on death.<br>
     * If {@code true}, it will drop an item. If {@code false}, it will shatter.
     *
     * @return true if the EnderSignal will drop an item on death, or false if
     * it will shatter
     */
    boolean getDropItem();

    /**
     * Sets if the EnderSignal should drop an item on death; or if it should
     * shatter.
     *
     * @param drop true if the EnderSignal should drop an item on death, or
     * false if it should shatter.
     */
    void setDropItem(boolean drop);

    /**
     * Get the {@link ItemStack} to be displayed while in the air and to be
     * dropped on death.
     *
     * @return the item stack
     */
    @NonNull ItemStack getItem();

    /**
     * Set the {@link ItemStack} to be displayed while in the air and to be
     * dropped on death.
     *
     * @param item the item to set. If null, resets to the default eye of ender
     */
    void setItem(@Nullable ItemStack item);

    /**
     * Gets the amount of time this entity has been alive (in ticks).
     * <br>
     * When this number is greater than 80, it will despawn on the next tick.
     *
     * @return the number of ticks this EnderSignal has been alive.
     */
    int getDespawnTimer();

    /**
     * Set how long this entity has been alive (in ticks).
     * <br>
     * When this number is greater than 80, it will despawn on the next tick.
     *
     * @param timer how long (in ticks) this EnderSignal has been alive.
     */
    void setDespawnTimer(int timer);
}

