package io.papermc.paper.api.block.structure;

import io.papermc.paper.api.block.tilestate.Structure;

/**
 * Represents how a {@link Structure} can be rotated.
 */
public enum StructureRotation {

    /**
     * No rotation.
     */
    NONE,
    /**
     * Rotated clockwise 90 degrees.
     */
    CLOCKWISE_90,
    /**
     * Rotated clockwise 180 degrees.
     */
    CLOCKWISE_180,
    /**
     * Rotated counter clockwise 90 degrees.
     * <br>
     * Equivalent to rotating clockwise 270 degrees.
     */
    COUNTERCLOCKWISE_90;
}
