package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.EnderDragon;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when an EnderDragon switches controller phase.
 */
public interface EnderDragonChangePhaseEvent extends CancellableEntityEvent {
    default EnderDragon enderDragon() {
        return (EnderDragon) entity();
    }

    /**
     * Gets the new phase that the dragon will switch to.
     *
     * @return the new dragon phase
     */
    @Param(1)
    EnderDragon.Phase newPhase();

    /**
     * Gets the current phase that the dragon is in. This method will return null
     * when a dragon is first spawned and hasn't yet been assigned a phase.
     *
     * @return the current dragon phase
     */
    @Param(2)
    EnderDragon.Phase currentPhase();
}
