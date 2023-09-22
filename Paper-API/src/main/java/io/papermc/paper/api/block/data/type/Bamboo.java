package io.papermc.paper.api.block.data.type;


import io.papermc.paper.api.block.data.Ageable;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * 'leaves' represents the size of the leaves on this bamboo block.
 */
public interface Bamboo extends Ageable, Sapling {

    /**
     * Gets the value of the 'leaves' property.
     *
     * @return the 'leaves' value
     */
    @NonNull
    Leaves getLeaves();

    /**
     * Sets the value of the 'leaves' property.
     *
     * @param leaves the new 'leaves' value
     */
    void setLeaves(@NonNull Leaves leaves);

    /**
     * Bamboo leaf size.
     */
    enum Leaves {

        /**
         * No leaves.
         */
        NONE,
        /**
         * Small leaves.
         */
        SMALL,
        /**
         * Large leaves.
         */
        LARGE
    }
}
