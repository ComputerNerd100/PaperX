package io.papermc.paper.api.block.data.type;

import io.papermc.paper.api.block.data.Directional;
import io.papermc.paper.api.block.data.FaceAttachable;
import io.papermc.paper.api.block.data.Powerable;
import org.jetbrains.annotations.NotNull;

public interface Switch extends Directional, FaceAttachable, Powerable {

    /**
     * Gets the value of the 'face' property.
     *
     * @return the 'face' value
     * @deprecated use {@link #getAttachedFace()}
     */
    @NotNull
    @Deprecated
    Face getFace();

    /**
     * Sets the value of the 'face' property.
     *
     * @param face the new 'face' value
     * @deprecated use {@link #setAttachedFace(AttachedFace)}
     */
    @Deprecated
    void setFace(@NotNull Face face);

    /**
     * The face to which a switch type block is stuck.
     *
     * @deprecated use {@link AttachedFace}
     */
    @Deprecated
    enum Face {
        /**
         * The switch is mounted to the floor and pointing upwards.
         */
        FLOOR,
        /**
         * The switch is mounted to the wall.
         */
        WALL,
        /**
         * The switch is mounted to the ceiling and pointing downwards.
         */
        CEILING;
    }
}

