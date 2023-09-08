package io.papermc.paper.api.block.data.type;

import io.papermc.paper.api.block.data.BlockData;

/**
 * 'unstable' indicates whether this TNT will explode on punching.
 */
public interface TNT extends BlockData {

    /**
     * Gets the value of the 'unstable' property.
     *
     * @return the 'unstable' value
     */
    boolean isUnstable();

    /**
     * Sets the value of the 'unstable' property.
     *
     * @param unstable the new 'unstable' value
     */
    void setUnstable(boolean unstable);
}