package io.papermc.paper.api.block.data.type;

import io.papermc.paper.api.block.data.Waterlogged;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * 'type' represents what state the slab is in - either top, bottom, or a double
 * slab occupying the full block.
 */
public interface Slab extends Waterlogged {

    /**
     * Gets the value of the 'type' property.
     *
     * @return the 'type' value
     */
    @NonNull
    Type getType();

    /**
     * Sets the value of the 'type' property.
     *
     * @param type the new 'type' value
     */
    void setType(@NonNull Type type);

    /**
     * The type of the slab.
     */
    enum Type {
        /**
         * The slab occupies the upper y half of the block.
         */
        TOP,
        /**
         * The slab occupies the lower y half of the block.
         */
        BOTTOM,
        /**
         * The slab occupies the entire block.
         */
        DOUBLE;
    }
}
