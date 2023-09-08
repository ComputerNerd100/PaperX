package io.papermc.paper.api.block.data;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * 'face' represents the face to which a lever or button is stuck.
 * <br>
 * This is used in conjunction with {@link Directional} to compute the
 * orientation of these blocks.
 */
public interface FaceAttachable extends BlockData {

    /**
     * Gets the value of the 'face' property.
     *
     * @return the 'face' value
     */
    @NonNull
    AttachedFace getAttachedFace();

    /**
     * Sets the value of the 'face' property.
     *
     * @param face the new 'face' value
     */
    void setAttachedFace(@NonNull AttachedFace face);

    /**
     * The face to which a switch type block is stuck.
     */
    public enum AttachedFace {
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

