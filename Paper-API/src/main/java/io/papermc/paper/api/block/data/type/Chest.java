package io.papermc.paper.api.block.data.type;

import io.papermc.paper.api.block.data.Directional;
import io.papermc.paper.api.block.data.Waterlogged;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * 'type' represents which part of a double chest this block is, or if it is a
 * single chest.
 */
public interface Chest extends Directional, Waterlogged {

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
     * Type of this chest block.
     * <br>
     * NB: Left and right are relative to the chest itself, i.e opposite to what
     * a player placing the appropriate block would see.
     */
    enum Type {
        /**
         * The chest is not linked to any others and contains only one 27 slot
         * inventory.
         */
        SINGLE,
        /**
         * The chest is the left hand side of a double chest and shares a 54
         * block inventory with the chest to its right.
         */
        LEFT,
        /**
         * The chest is the right hand side of a double chest and shares a 54
         * block inventory with the chest to its left.
         */
        RIGHT
    }
}

