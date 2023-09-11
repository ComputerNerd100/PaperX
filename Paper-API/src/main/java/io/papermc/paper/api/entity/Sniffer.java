package io.papermc.paper.api.entity;

import io.papermc.paper.api.location.Location;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collection;

/**
 * Represents a Sniffer.
 */
public interface Sniffer extends Animals {

    /**
     * Gets the locations explored by the sniffer.
     *
     * @return a collection of locations
     */
    @NonNull Collection<Location> getExploredLocations();

    /**
     * Remove a location of the explored locations.
     *
     * @param location the location to remove
     * @see #getExploredLocations()
     */
    void removeExploredLocation(@NonNull Location location);

    /**
     * Add a location to the explored locations.
     * <br>
     * <b>Note:</b> the location must be in the sniffer's current world for this
     * method to have any effect.
     *
     * @param location the location to add
     * @see #getExploredLocations()
     */
    void addExploredLocation(@NonNull Location location);

    /**
     * Get the current state of the sniffer.
     *
     * @return the state of the sniffer
     */
    Sniffer.@NonNull State getState();

    /**
     * Set a new state for the sniffer.
     * <br>
     * This will also make the sniffer make the transition to the new state.
     *
     * @param state the new state
     */
    void setState(Sniffer.@NonNull State state);

    /**
     * Try to get a possible location where the sniffer can dig.
     *
     * @return a {@link Location} if found or null
     */
    @Nullable Location findPossibleDigLocation();

    /**
     * Gets whether the sniffer can dig in the current {@link Location} below
     * its head.
     *
     * @return {@code true} if can dig or {@code false} otherwise
     */
    boolean canDig();

    /**
     * Represents the current state of the Sniffer.
     */
    enum State {
        IDLING,
        FEELING_HAPPY,
        SCENTING,
        SNIFFING,
        SEARCHING,
        DIGGING,
        RISING
    }
}

