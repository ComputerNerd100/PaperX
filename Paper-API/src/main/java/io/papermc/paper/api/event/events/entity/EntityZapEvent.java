package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.LightningStrike;
import io.papermc.paper.api.event.util.Param;

/**
 *  Fired when lightning strikes an entity
 */
public interface EntityZapEvent extends EntityTransformEvent {

    /**
     * Gets the lightning bolt that is striking the entity.
     * @return The lightning bolt responsible for this event
     */
    @Param(4)
    LightningStrike bolt();
}
