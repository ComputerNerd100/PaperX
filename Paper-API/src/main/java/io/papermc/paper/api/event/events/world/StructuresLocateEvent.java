package io.papermc.paper.api.event.events.world;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.location.Location;
import io.papermc.paper.api.math.Position;
import io.papermc.paper.api.world.World;
import io.papermc.paper.api.world.generator.structure.Structure;
import io.papermc.paper.api.world.generator.structure.StructureType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Called <b>before</b> a set of configured structures is located.
 * This happens when:
 * <ul>
 *     <li>The /locate command is used.<br></li>
 *     <li>An Eye of Ender is used.</li>
 *     <li>An Explorer/Treasure Map is activated.</li>
 *     <li>A dolphin swims to a treasure location.</li>
 *     <li>A trade is done with a villager for a map.</li>
 *     <li>{@link World#locateNearestStructure(Location, StructureType, int, boolean)} is invoked.</li>
 *     <li>{@link World#locateNearestStructure(Location, Structure, int, boolean)} is invoked.</li>
 * </ul>
 */
public interface StructuresLocateEvent extends CancellableWorldEvent {

    /**
     * Gets the {@link Location} from which the search is to be conducted.
     *
     * @return {@link Location} where search begins
     */
    @Param(1)
    Location origin();

    /**
     * Gets the {@link Location} and {@link Structure} set as the result, if it was defined.
     * <p>
     * Returns {@code null} if it has not been set.
     * Since this event fires <i>before</i> the search is done, the actual result is unknown at this point.
     *
     * @return The result location and structure, if it has been set. null if it has not.
     * @see World#locateNearestStructure(Location, StructureType, int, boolean)
     */
    @Param(2)
    Result result();

    /**
     * Gets an unmodifiable list of Structures that are valid targets for the search.
     *
     * @return an unmodifiable list of Structures
     */
    @Param(3)
    List<Structure> structures();

    /**
     * Gets the search radius in which to attempt locating the structure.
     * <p>
     * This radius may not always be obeyed during the structure search!
     *
     * @return the search radius (in chunks)
     */
    @Param(4)
    int radius();

    /**
     * Gets whether to search exclusively for unexplored structures.
     * <p>
     * As with the search radius, this value is not always obeyed.
     *
     * @return Whether to search for only unexplored structures.
     */
    @Param(5)
    boolean findUnexplored();

    record Result(@NotNull Position pos, @NotNull Structure structure) {
    }
}
