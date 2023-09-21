package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.entity.LivingEntity;
import io.papermc.paper.api.event.util.Param;

import java.util.List;

/**
 * Called when a bell resonated after being rung and highlights nearby raiders.
 * A bell will only resonate if raiders are in the vicinity of the bell.
 */
public interface BellResonateEvent extends BlockResultEvent {

    /**
     * Get a mutable list of all {@link LivingEntity LivingEntities} to be
     * highlighted by the bell's resonating. This list can be added to or
     * removed from to change which entities are highlighted, and may be empty
     * if no entities were resonated as a result of this event.
     * <p>
     * While the highlighted entities will change, the particles that display
     * over a resonated entity and their colors will not. This is handled by the
     * client and cannot be controlled by the server.
     *
     * @return a list of resonated entities
     */
    @Param(0)
    List<LivingEntity> resonatingEntities();

}
