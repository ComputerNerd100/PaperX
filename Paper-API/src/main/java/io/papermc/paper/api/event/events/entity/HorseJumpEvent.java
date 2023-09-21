package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.AbstractHorse;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a horse jumps.
 */
public interface HorseJumpEvent extends CancellableEntityEvent {
    default AbstractHorse horse() {
        return (AbstractHorse) entity();
    }

    /**
     * Gets the power of the jump.
     * <p>
     * Power is a value that defines how much of the horse's jump strength
     * should be used for the jump. Power is effectively multiplied times
     * the horse's jump strength to determine how high the jump is; 0
     * represents no jump strength while 1 represents full jump strength.
     * Setting power to a value above 1 will use additional jump strength
     * that the horse does not usually have.
     * <p>
     * Power does not affect how high the horse is capable of jumping, only
     * how much of its jumping capability will be used in this jump. To set
     * the horse's overall jump strength, see {@link
     * AbstractHorse#setJumpStrength(double)}.
     *
     * @return jump strength
     */
    @Param(1)
    float power();
}
