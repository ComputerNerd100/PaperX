package io.papermc.paper.api.block.data.type;

import io.papermc.paper.api.block.data.Directional;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * 'type' represents the type of piston which this (technical) block corresponds
 * to.
 */
public interface TechnicalPiston extends Directional {

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
     * Different piston variants.
     */
    enum Type {
        /**
         * A normal piston which does not pull connected blocks backwards on
         * retraction.
         */
        NORMAL,
        /**
         * A sticky piston which will also retract connected blocks.
         */
        STICKY
    }
}
