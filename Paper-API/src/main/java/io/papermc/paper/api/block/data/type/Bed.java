package io.papermc.paper.api.block.data.type;

import io.papermc.paper.api.block.data.Bisected;
import io.papermc.paper.api.block.data.Directional;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Similar to {@link Bisected}, 'part' denotes which half of the bed this block
 * corresponds to.
 * <br>
 * 'occupied' property is a quick flag to check if a player is currently
 * sleeping in this bed block.
 */
public interface Bed extends Directional {

    /**
     * Gets the value of the 'part' property.
     *
     * @return the 'part' value
     */
    @NonNull
    Part getPart();

    /**
     * Sets the value of the 'part' property.
     *
     * @param part the new 'part' value
     */
    void setPart(@NonNull Part part);

    /**
     * Gets the value of the 'occupied' property.
     *
     * @return the 'occupied' value
     */
    boolean isOccupied();

    /**
     * Sets the value of the 'occupied' property.
     *
     * @param occupied the new 'occupied' value
     */
    void setOccupied(boolean occupied);

    /**
     * Horizontal half of a bed.
     */
    enum Part {

        /**
         * The head is the upper part of the bed containing the pillow.
         */
        HEAD,
        /**
         * The foot is the lower half of the bed.
         */
        FOOT
    }
}

