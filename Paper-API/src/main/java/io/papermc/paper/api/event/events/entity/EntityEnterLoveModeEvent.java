package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Animals;
import io.papermc.paper.api.entity.HumanEntity;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when an entity enters love mode.
 * <br>
 * This can be cancelled but the item will still be consumed that was used to
 * make the entity enter into love mode.
 */
public interface EntityEnterLoveModeEvent extends CancellableEntityEvent {

    /**
     * Gets the animal that is entering love mode.
     *
     * @return The animal that is entering love mode
     */
    default Animals animals() {
        return (Animals) entity();
    }

    /**
     * Gets the Human Entity that caused the animal to enter love mode.
     *
     * @return The Human entity that caused the animal to enter love mode, or
     * null if there wasn't one.
     */
    @Param(1)
    HumanEntity humanEntity();

    /**
     * Gets the amount of ticks that the animal will fall in love for.
     *
     * @return The amount of ticks that the animal will fall in love for
     */
    @Param(2)
    int ticksInLove();
}
