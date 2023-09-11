package io.papermc.paper.api.entity;

import io.papermc.paper.api.block.color.Colorable;

/**
 * Represents a Sheep.
 */
public interface Sheep extends Animals, Colorable, Shearable { // Paper - Shear API

    /**
     * @return Whether the sheep is sheared.
     */
    boolean isSheared();

    /**
     * @param flag Whether to shear the sheep
     */
    void setSheared(boolean flag);
}

