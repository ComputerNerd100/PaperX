package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.ThrownExpBottle;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a ThrownExpBottle hits and releases experience.
 */
public interface ExpBottleEvent extends ProjectileHitEvent {
    default ThrownExpBottle expBottle() {
        return (ThrownExpBottle) projectile();
    }

    /**
     * This method retrieves the amount of experience to be created.
     * <p>
     * The number indicates a total amount to be divided into orbs.
     *
     * @return the total amount of experience to be created
     */
    @Param(4)
    int exp();

    /**
     * This method indicates if the particle effect should be shown.
     *
     * @return true if the effect will be shown, false otherwise
     */
    @Param(5)
    boolean showEffect();
}
