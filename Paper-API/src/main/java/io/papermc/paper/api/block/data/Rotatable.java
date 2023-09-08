package io.papermc.paper.api.block.data;

import io.papermc.paper.api.block.BlockFace;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * 'rotation' represents the current rotation of this block.
 */
public interface Rotatable extends BlockData {

    /**
     * Gets the value of the 'rotation' property.
     *
     * @return the 'rotation' value
     */
    @NonNull
    BlockFace getRotation();

    /**
     * Sets the value of the 'rotation' property.
     *
     * @param rotation the new 'rotation' value
     */
    void setRotation(@NonNull BlockFace rotation);
}
