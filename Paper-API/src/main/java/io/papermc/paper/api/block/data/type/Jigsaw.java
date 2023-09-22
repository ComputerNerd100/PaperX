package io.papermc.paper.api.block.data.type;

import io.papermc.paper.api.block.data.BlockData;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * 'orientation' is the direction the block is facing.
 */
public interface Jigsaw extends BlockData {

    /**
     * Gets the value of the 'orientation' property.
     *
     * @return the 'orientation' value
     */
    @NonNull
    Orientation getOrientation();

    /**
     * Sets the value of the 'orientation' property.
     *
     * @param orientation the new 'orientation' value
     */
    void setOrientation(@NonNull Orientation orientation);

    /**
     * The directions the Jigsaw can be oriented.
     */
    enum Orientation {

        DOWN_EAST,
        DOWN_NORTH,
        DOWN_SOUTH,
        DOWN_WEST,
        UP_EAST,
        UP_NORTH,
        UP_SOUTH,
        UP_WEST,
        WEST_UP,
        EAST_UP,
        NORTH_UP,
        SOUTH_UP
    }
}
