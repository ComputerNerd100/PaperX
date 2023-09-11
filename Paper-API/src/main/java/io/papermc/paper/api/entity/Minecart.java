package io.papermc.paper.api.entity;

import io.papermc.paper.api.block.data.BlockData;
import io.papermc.paper.api.material.Material;
import io.papermc.paper.api.util.vector.Vector;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents a minecart entity.
 */
public interface Minecart extends Vehicle {

    /**
     * Sets a minecart's damage.
     *
     * @param damage over 40 to "kill" a minecart
     */
    void setDamage(double damage);

    /**
     * Gets a minecart's damage.
     *
     * @return The damage
     */
    double getDamage();

    /**
     * Gets the maximum speed of a minecart. The speed is unrelated to the
     * velocity.
     *
     * @return The max speed
     */
    double getMaxSpeed();

    /**
     * Sets the maximum speed of a minecart. Must be nonnegative. Default is
     * 0.4D.
     *
     * @param speed The max speed
     */
    void setMaxSpeed(double speed);

    /**
     * Returns whether this minecart will slow down faster without a passenger
     * occupying it
     *
     * @return Whether it decelerates faster
     */
    boolean isSlowWhenEmpty();

    /**
     * Sets whether this minecart will slow down faster without a passenger
     * occupying it
     *
     * @param slow Whether it will decelerate faster
     */
    void setSlowWhenEmpty(boolean slow);

    /**
     * Gets the flying velocity modifier. Used for minecarts that are in
     * mid-air. A flying minecart's velocity is multiplied by this factor each
     * tick.
     *
     * @return The vector factor
     */
    @NonNull Vector getFlyingVelocityMod();

    /**
     * Sets the flying velocity modifier. Used for minecarts that are in
     * mid-air. A flying minecart's velocity is multiplied by this factor each
     * tick.
     *
     * @param flying velocity modifier vector
     */
    void setFlyingVelocityMod(@NonNull Vector flying);

    /**
     * Gets the derailed velocity modifier. Used for minecarts that are on the
     * ground, but not on rails.
     * <p>
     * A derailed minecart's velocity is multiplied by this factor each tick.
     *
     * @return derailed visible speed
     */
    @NonNull Vector getDerailedVelocityMod();

    /**
     * Sets the derailed velocity modifier. Used for minecarts that are on the
     * ground, but not on rails. A derailed minecart's velocity is multiplied
     * by this factor each tick.
     *
     * @param derailed visible speed
     */
    void setDerailedVelocityMod(@NonNull Vector derailed);


    /**
     * Sets the display block for this minecart.
     * Passing a null value will set the minecart to have no display block.
     *
     * @param blockData the material to set as display block.
     */
    void setDisplayBlockData(@Nullable BlockData blockData);

    /**
     * Gets the display block for this minecart.
     * This function will return the type AIR if none is set.
     *
     * @return the block displayed by this minecart.
     */
    @NonNull BlockData getDisplayBlockData();

    /**
     * Sets the offset of the display block.
     *
     * @param offset the block offset to set for this minecart.
     */
    void setDisplayBlockOffset(int offset);

    /**
     * Gets the offset of the display block.
     *
     * @return the current block offset for this minecart.
     */
    int getDisplayBlockOffset();

    /**
     * Gets the {@link Material} that represents this Minecart type.
     *
     * @return the minecart material.
     */
    @NonNull Material getMinecartMaterial();
}

