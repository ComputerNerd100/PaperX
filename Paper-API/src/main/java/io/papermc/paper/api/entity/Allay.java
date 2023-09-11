package io.papermc.paper.api.entity;

import io.papermc.paper.api.inventory.InventoryHolder;
import io.papermc.paper.api.location.Location;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * An Allay.
 */
public interface Allay extends Creature, InventoryHolder {

    /**
     * Gets if the allay can duplicate.
     * <br>
     * <b>Note:</b> Duplication is based when the
     * {@link #getDuplicationCooldown} its lower than zero.
     *
     * @return if the allay can duplicate itself.
     */
    boolean canDuplicate();

    /**
     * Sets if the allay can duplicate.
     * <br>
     * <b>Note:</b> this value can be overridden later by
     * {@link #getDuplicationCooldown} if is lower than zero. You can also use
     * {@link #setDuplicationCooldown} to allow the allay to duplicate
     *
     * @param canDuplicate if the allay can duplicate itself
     */
    void setCanDuplicate(boolean canDuplicate);

    /**
     * Gets the cooldown for duplicating the allay.
     *
     * @return the time in ticks when allay can duplicate
     */
    long getDuplicationCooldown();

    /**
     * Sets the cooldown before the allay can duplicate again.
     *
     * @param cooldown the cooldown, use a negative number to deny allay to
     * duplicate again.
     */
    void setDuplicationCooldown(long cooldown);

    /**
     * Reset the cooldown for duplication.
     *
     * This will set the cooldown ticks to the same value as is set after an
     * Allay has duplicated.
     */
    void resetDuplicationCooldown();

    /**
     * Gets if the allay is dancing.
     *
     * @return {@code True} if it is dancing, false otherwise.
     */
    boolean isDancing();

    /**
     * Causes the allay to start dancing because of the provided jukebox
     * location.
     *
     * @param location the location of the jukebox
     *
     * @throws IllegalArgumentException if the block at the location is not a
     * jukebox
     */
    void startDancing(@NonNull Location location);

    /**
     * Force sets the dancing status of the allay.
     * <br>
     * <b>Note:</b> This method forces the allay to dance, ignoring any nearby
     * jukebox being required.
     */
    void startDancing();

    /**
     * Makes the allay stop dancing.
     */
    void stopDancing();

    /**
     * This make the current allay duplicate itself without dance or item
     * necessary.
     * <b>Note:</b> this will fire a {@link CreatureSpawnEvent}
     *
     * @return the new entity {@link Allay} or null if the spawn was cancelled
     */
    @Nullable
    Allay duplicateAllay();

    /**
     * Gets the jukebox the allay is set to dance to.
     *
     * @return the location of the jukebox to dance if it exists
     */
    @Nullable
    Location getJukebox();
}

