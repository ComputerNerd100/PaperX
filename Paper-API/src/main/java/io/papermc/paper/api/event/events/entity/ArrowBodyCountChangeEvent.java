package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.LivingEntity;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when an arrow enters or exists an entity's body.
 */
public interface ArrowBodyCountChangeEvent extends CancellableEntityEvent {

    default LivingEntity livingEntity() {
        return (LivingEntity) entity();
    }

    /**
     * Gets the old amount of arrows in the entity's body.
     *
     * @return amount of arrows
     */
    @Param(1)
    int oldAmount();

    /**
     * Get the new amount of arrows in the entity's body.
     *
     * @return amount of arrows
     */
    @Param(2)
    int newAmount();

    /**
     * Whether the event was called because the entity was reset.
     *
     * @return was reset
     */
    @Param(3)
    boolean isReset();

}
