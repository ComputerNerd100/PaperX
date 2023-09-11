package io.papermc.paper.api.entity;

import io.papermc.paper.api.block.BlockFace;
import io.papermc.paper.api.block.color.Colorable;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface Shulker extends Golem, Colorable, Enemy {

    /**
     * Gets the peek state of the shulker between 0.0 and 1.0.
     *
     * @return the peek state of the shulker between 0.0 and 1.0
     */
    float getPeek();

    /**
     * Sets the peek state of the shulker, should be in between 0.0 and 1.0.
     *
     * @param value peek state of the shulker, should be in between 0.0 and 1.0
     * @throws IllegalArgumentException thrown if the value exceeds the valid
     * range in between of 0.0 and 1.0
     */
    void setPeek(float value);

    /**
     * Gets the face to which the shulker is attached.
     *
     * @return the face to which the shulker is attached
     */
    @NonNull BlockFace getAttachedFace();

    /**
     * Sets the face to which the shulker is attached.
     *
     * @param face the face to attach the shulker to
     */
    void setAttachedFace(@NonNull BlockFace face);
}

