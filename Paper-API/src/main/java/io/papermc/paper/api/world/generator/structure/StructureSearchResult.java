package io.papermc.paper.api.world.generator.structure;

import io.papermc.paper.api.location.Location;
import io.papermc.paper.api.world.World;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Holds the result of searching for a structure.
 *
 * @see World#locateNearestStructure(Location, Structure, int, boolean)
 * @see World#locateNearestStructure(Location, StructureType, int, boolean)
 */
public interface StructureSearchResult {

    /**
     * Return the structure which was found.
     *
     * @return the found structure.
     */
    @NonNull
    Structure getStructure();

    /**
     * Return the location of the structure.
     *
     * @return the location the structure was found.
     */
    @NonNull
    Location getLocation();
}

