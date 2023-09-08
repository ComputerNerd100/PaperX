package io.papermc.paper.api.block.data.type;

import io.papermc.paper.api.block.data.Directional;

/**
 * 'eye' denotes whether this end portal frame has been activated by having an
 * eye of ender placed in it.
 */
public interface EndPortalFrame extends Directional {

    /**
     * Gets the value of the 'eye' property.
     *
     * @return the 'eye' value
     */
    boolean hasEye();

    /**
     * Sets the value of the 'eye' property.
     *
     * @param eye the new 'eye' value
     */
    void setEye(boolean eye);
}
