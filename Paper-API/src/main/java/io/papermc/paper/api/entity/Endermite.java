package io.papermc.paper.api.entity;

public interface Endermite extends Monster {

    /**
     * Sets how many ticks this endermite has been living for.
     * If this value is greater than 2400, this endermite will despawn.
     *
     * @param ticks lifetime ticks
     */
    void setLifetimeTicks(int ticks);

    /**
     * Gets how long this endermite has been living for.
     * This value will tick up while {@link LivingEntity#getRemoveWhenFarAway()} is false.
     * If this value is greater than 2400, this endermite will despawn.
     *
     * @return lifetime ticks
     */
    int getLifetimeTicks();
}

