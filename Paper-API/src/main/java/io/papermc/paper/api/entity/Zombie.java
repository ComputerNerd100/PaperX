package io.papermc.paper.api.entity;

/**
 * Represents a Zombie.
 */
public interface Zombie extends Monster, Ageable {

    /**
     * Get if this entity is in the process of converting to a Drowned as a
     * result of being underwater.
     *
     * @return conversion status
     */
    boolean isConverting();

    /**
     * Gets the amount of ticks until this entity will be converted to a Drowned
     * as a result of being underwater.
     *
     * When this reaches 0, the entity will be converted.
     *
     * @return conversion time
     * @throws IllegalStateException if {@link #isConverting()} is false.
     */
    int getConversionTime();

    /**
     * Sets the amount of ticks until this entity will be converted to a Drowned
     * as a result of being underwater.
     *
     * When this reaches 0, the entity will be converted. A value of less than 0
     * will stop the current conversion process without converting the current
     * entity.
     *
     * @param time new conversion time
     */
    void setConversionTime(int time);

    /**
     * Gets whether this zombie can break doors
     *
     * @return Whether this zombie can break doors
     */
    boolean canBreakDoors();

    /**
     * Sets whether this zombie can break doors
     * <p>
     * Check {@link #supportsBreakingDoors()} to see
     * if this zombie type will even be affected by using
     * this method. Will also stop the action if
     * the entity is currently breaking a door.
     *
     * @param flag Whether this zombie can break doors
     */
    void setCanBreakDoors(boolean flag);

    /**
     * Check if zombie is drowning
     *
     * @return True if zombie conversion process has begun
     */
    boolean isDrowning();

    /**
     * Stop a zombie from starting the drowning conversion process
     */
    void stopDrowning();

    /**
     * Set if zombie has its arms raised
     *
     * @param raised True to raise arms
     */
    void setArmsRaised(boolean raised);

    /**
     * Check if zombie has arms raised
     *
     * @return True if arms are raised
     */
    boolean isArmsRaised();

    /**
     * Check if this zombie will burn in the sunlight
     *
     * @return True if zombie will burn in sunlight
     */
    boolean shouldBurnInDay();

    /**
     * Set if this zombie should burn in the sunlight
     *
     * @param shouldBurnInDay True to burn in sunlight
     */
    void setShouldBurnInDay(boolean shouldBurnInDay);

    /**
     * Checks if this zombie type supports breaking doors.
     * {@link Drowned} do not have support for breaking doors
     * so using {@link #setCanBreakDoors(boolean)} on them has
     * no effect.
     *
     * @return true if entity supports breaking doors
     */
    boolean supportsBreakingDoors();
}

