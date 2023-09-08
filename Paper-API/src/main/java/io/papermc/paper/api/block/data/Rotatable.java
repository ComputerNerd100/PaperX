package io.papermc.paper.api.block.data;

import io.papermc.paper.api.block.BlockFace;
import org.jetbrains.annotations.NotNull;

/**
 * 'rotation' represents the current rotation of this block.
 */
public interface Rotatable extends BlockData {

    /**
     * Gets the value of the 'rotation' property.
     *
     * @return the 'rotation' value
     */
    @NotNull
    BlockFace getRotation();

    /**
     * Sets the value of the 'rotation' property.
     *
     * @param rotation the new 'rotation' value
     */
    void setRotation(@NotNull BlockFace rotation);
}
