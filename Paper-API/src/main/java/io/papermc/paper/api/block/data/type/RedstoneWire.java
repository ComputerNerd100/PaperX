package io.papermc.paper.api.block.data.type;

import io.papermc.paper.api.block.BlockFace;
import io.papermc.paper.api.block.data.AnaloguePowerable;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Set;

/**
 * 'north', 'east', 'south', 'west' represent the types of connections this
 * redstone wire has to adjacent blocks.
 */
public interface RedstoneWire extends AnaloguePowerable {

    /**
     * Checks the type of connection on the specified face.
     *
     * @param face to check
     * @return connection type
     */
    @NonNull
    Connection getFace(@NonNull BlockFace face);

    /**
     * Sets the type of connection on the specified face.
     *
     * @param face to set
     * @param connection the connection type
     */
    void setFace(@NonNull BlockFace face, @NonNull Connection connection);

    /**
     * Gets all of this faces which may be set on this block.
     *
     * @return all allowed faces
     */
    @NonNull
    Set<BlockFace> getAllowedFaces();

    /**
     * The way in which a redstone wire can connect to an adjacent block face.
     */
    enum Connection {
        /**
         * The wire travels up the side of the block adjacent to this face.
         */
        UP,
        /**
         * The wire travels flat from this face and into the adjacent block.
         */
        SIDE,
        /**
         * The wire does not connect in this direction.
         */
        NONE;
    }
}

