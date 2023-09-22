package io.papermc.paper.api.block.data.type;

import io.papermc.paper.api.block.data.Bisected;
import io.papermc.paper.api.block.data.Directional;
import io.papermc.paper.api.block.data.Waterlogged;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * 'shape' represents the texture and bounding box shape of these stairs.
 */
public interface Stairs extends Bisected, Directional, Waterlogged {

    /**
     * Gets the value of the 'shape' property.
     *
     * @return the 'shape' value
     */
    @NonNull
    Shape getShape();

    /**
     * Sets the value of the 'shape' property.
     *
     * @param shape the new 'shape' value
     */
    void setShape(@NonNull Shape shape);

    /**
     * The shape of a stair block - used for constructing corners.
     */
    enum Shape {
        /**
         * Regular stair block.
         */
        STRAIGHT,
        /**
         * Inner corner stair block with higher left side.
         */
        INNER_LEFT,
        /**
         * Inner corner stair block with higher right side.
         */
        INNER_RIGHT,
        /**
         * Outer corner stair block with higher left side.
         */
        OUTER_LEFT,
        /**
         * Outer corner stair block with higher right side.
         */
        OUTER_RIGHT
    }
}

