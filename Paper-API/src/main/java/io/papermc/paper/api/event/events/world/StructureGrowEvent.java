package io.papermc.paper.api.event.events.world;

import io.papermc.paper.api.block.BlockState;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.location.Location;
import io.papermc.paper.api.material.TreeType;

import java.util.List;

/**
 * Event that is called when an organic structure attempts to grow (Sapling {@literal ->}
 * Tree), (Mushroom {@literal ->} Huge Mushroom), naturally or using bonemeal.
 */
public interface StructureGrowEvent extends CancellableWorldEvent {

    /**
     * Gets the location of the structure.
     *
     * @return Location of the structure
     */
    @Param(1)
    Location location();

    /**
     * Gets the species type (birch, normal, pine, red mushroom, brown
     * mushroom)
     *
     * @return Structure species
     */
    @Param(2)
    TreeType treeType();

    /**
     * Checks if structure was grown using bonemeal.
     *
     * @return True if the structure was grown using bonemeal.
     */
    @Param(3)
    boolean bonemeal();

    /**
     * Gets the player that created the structure.
     *
     * @return Player that created the structure, null if was not created
     *     manually
     */
    @Param(4)
    Player player();

    /**
     * Gets a list of all blocks associated with the structure.
     *
     * @return list of all blocks associated with the structure.
     */
    @Param(5)
    List<BlockState> blocks();
}
