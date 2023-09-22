package io.papermc.paper.api.util;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collection;

/**
 * A shape made out of voxels.
 *
 * For example, used to represent the detailed collision shape of blocks.
 */
public interface VoxelShape {

    /**
     * Converts this shape into a collection of {@link BoundingBox} equivalent
     * to the shape: a bounding box intersects with this block shape if it
     * intersects with any of the shape's bounding boxes.
     *
     * @return shape converted to bounding boxes
     */
    @NonNull Collection<BoundingBox> getBoundingBoxes();

    /**
     * Checks if the given bounding box intersects this block shape.
     *
     * @param other bounding box to test
     * @return true if other overlaps this, false otherwise
     */
    boolean overlaps(@NonNull BoundingBox other);
}

