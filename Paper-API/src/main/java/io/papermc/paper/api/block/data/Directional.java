package io.papermc.paper.api.block.data;

import io.papermc.paper.api.block.BlockFace;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Set;

/**
 * 'facing' represents the face towards which the block is pointing.
 * <br>
 * Some blocks may not be able to face in all directions, use
 * {@link #getFaces()} to get all possible directions for this block.
 */
public interface Directional extends BlockData {

    /**
     * Gets the value of the 'facing' property.
     *
     * @return the 'facing' value
     */
    @NonNull
    BlockFace getFacing();

    /**
     * Sets the value of the 'facing' property.
     *
     * @param facing the new 'facing' value
     */
    void setFacing(@NonNull BlockFace facing);

    /**
     * Gets the faces which are applicable to this block.
     *
     * @return the allowed 'facing' values
     */
    @NonNull
    Set<BlockFace> getFaces();
}

