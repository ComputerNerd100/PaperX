package io.papermc.paper.api.block.data.type;

import io.papermc.paper.api.block.data.Directional;
import io.papermc.paper.api.block.data.Powerable;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * 'attachment' denotes how the bell is attached to its block.
 */
public interface Bell extends Directional, Powerable {

    /**
     * Gets the value of the 'attachment' property.
     *
     * @return the 'attachment' value
     */
    @NonNull
    Attachment getAttachment();

    /**
     * Sets the value of the 'attachment' property.
     *
     * @param attachment the new 'attachment' value
     */
    void setAttachment(@NonNull Attachment attachment);

    /**
     * What the bell is attached to.
     */
    enum Attachment {

        /**
         * Placed on floor.
         */
        FLOOR,
        /**
         * Placed on ceiling.
         */
        CEILING,
        /**
         * Placed on one wall.
         */
        SINGLE_WALL,
        /**
         * Placed between two walls.
         */
        DOUBLE_WALL;
    }
}
