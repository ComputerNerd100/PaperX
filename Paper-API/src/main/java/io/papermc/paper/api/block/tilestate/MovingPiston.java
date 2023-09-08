package io.papermc.paper.api.block.tilestate;

import io.papermc.paper.api.block.BlockFace;
import io.papermc.paper.api.block.data.BlockData;
import org.jetbrains.annotations.NotNull;

public interface MovingPiston extends TileState {

    /**
     * Gets the block that is being pushed
     *
     * @return the pushed block
     */
    @NotNull
    BlockData getMovingBlock();

    /**
     * The direction that the current moving piston
     * is pushing/pulling a block in.
     *
     * @return the direction
     */
    @NotNull
    BlockFace getDirection();

    /**
     * Gets if the piston is extending or not.
     * Returns false if the piston is retracting.
     *
     * @return is extending or not
     */
    boolean isExtending();

    /**
     * Returns if this moving piston represents the main piston head
     * from the original piston.
     *
     * @return is the piston head or not
     */
    boolean isPistonHead();

}
