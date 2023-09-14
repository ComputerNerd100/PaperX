package io.papermc.paper.api.block.data.type;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * 'tilt' indicates how far the leaf is tilted.
 */
public interface BigDripleaf extends Dripleaf {

    /**
     * Gets the value of the 'tilt' property.
     *
     * @return the 'tilt' value
     */
    @NonNull
    Tilt getTilt();

    /**
     * Sets the value of the 'tilt' property.
     *
     * @param tilt the new 'tilt' value
     */
    void setTilt(@NonNull Tilt tilt);

    /**
     * The tilt of a leaf.
     */
    enum Tilt {
        /**
         * No tilt.
         */
        NONE,
        /**
         * Unstable tilt.
         */
        UNSTABLE,
        /**
         * Partial tilt.
         */
        PARTIAL,
        /**
         * Pinball.
         */
        FULL;
    }
}

