package io.papermc.paper.api.block.data.type;

import io.papermc.paper.api.block.data.Directional;
import io.papermc.paper.api.block.data.Lightable;
import io.papermc.paper.api.block.data.Waterlogged;

/**
 * 'signal_fire' denotes whether the fire is extra smokey due to having a hay
 * bale placed beneath it.
 */
public interface Campfire extends Directional, Lightable, Waterlogged {

    /**
     * Gets the value of the 'signal_fire' property.
     *
     * @return the 'signal_fire' value
     */
    boolean isSignalFire();

    /**
     * Sets the value of the 'signal_fire' property.
     *
     * @param signalFire the new 'signal_fire' value
     */
    void setSignalFire(boolean signalFire);
}
