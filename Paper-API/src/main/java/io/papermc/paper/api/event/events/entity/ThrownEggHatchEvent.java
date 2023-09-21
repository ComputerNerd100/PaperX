package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Egg;
import io.papermc.paper.api.entity.EntityType;
import io.papermc.paper.api.event.Event;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a thrown egg might hatch.
 * <p>
 * This event fires for all thrown eggs that may hatch, players, dispensers, etc.
 */
public interface ThrownEggHatchEvent extends Event {

    /**
     * Gets the egg involved in this event.
     *
     * @return the egg involved in this event
     */
    @Param(0)
    Egg egg();

    /**
     * Gets whether the egg is hatching or not. Will be what the server
     * would've done without interaction.
     *
     * @return boolean Whether the egg is going to hatch or not
     */
    @Param(1)
    boolean hatching();

    /**
     * Get the number of mob hatches from the egg. By default the number will
     * be the number the server would've done
     * <ul>
     * <li>7/8 chance of being 0
     * <li>31/256 ~= 1/8 chance to be 1
     * <li>1/256 chance to be 4
     * </ul>
     *
     * @return The number of mobs going to be hatched by the egg
     */
    @Param(2)
    byte numHatches();

    /**
     * Get the type of the mob being hatched (EntityType.CHICKEN by default)
     *
     * @return The type of the mob being hatched by the egg
     */
    @Param(3)
    EntityType hatchingType();
}
