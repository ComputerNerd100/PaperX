package io.papermc.paper.api.event.events.world;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.util.BoundingBox;
import io.papermc.paper.api.world.generator.structure.Structure;

/**
 * Called when a {@link Structure} is naturally generated in the world.
 */
public interface AsyncStructureSpawnEvent extends CancellableWorldEvent {

    /**
     * Get the structure reference that is generated.
     *
     * @return the structure
     */
    @Param(1)
    Structure structure();

    /**
     * Get the bounding box of the structure.
     *
     * @return the bounding box
     */
    @Param(2)
    BoundingBox boundingBox();

    /**
     * Get the x coordinate of the origin chunk of the structure.
     *
     * <b>Note, it is not safe to attempt to retrieve or interact with this
     * chunk. This event is informative only!</b>
     *
     * @return the chunk x coordinate
     */
    @Param(3)
    int chunkX();

    /**
     * Get the z coordinate of the origin chunk of the structure.
     *
     * <b>Note, it is not safe to attempt to retrieve or interact with this
     * chunk. This event is informative only!</b>
     *
     * @return the chunk z coordinate
     */
    @Param(4)
    int chunkZ();
}
