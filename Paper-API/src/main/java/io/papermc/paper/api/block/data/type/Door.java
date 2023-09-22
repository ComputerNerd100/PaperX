package io.papermc.paper.api.block.data.type;

import io.papermc.paper.api.block.data.Bisected;
import io.papermc.paper.api.block.data.Directional;
import io.papermc.paper.api.block.data.Openable;
import io.papermc.paper.api.block.data.Powerable;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * 'hinge' indicates which hinge this door is attached to and will rotate around
 * when opened.
 */
public interface Door extends Bisected, Directional, Openable, Powerable {

    /**
     * Gets the value of the 'hinge' property.
     *
     * @return the 'hinge' value
     */
    @NonNull
    Hinge getHinge();

    /**
     * Sets the value of the 'hinge' property.
     *
     * @param hinge the new 'hinge' value
     */
    void setHinge(@NonNull Hinge hinge);

    /**
     * The hinge of a door.
     */
    enum Hinge {
        /**
         * Door is attached to the left side.
         */
        LEFT,
        /**
         * Door is attached to the right side.
         */
        RIGHT
    }
}
