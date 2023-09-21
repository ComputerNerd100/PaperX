package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.ElderGuardian;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;

/**
 * Is called when an {@link ElderGuardian} appears in front of a {@link Player}.
 */
public interface ElderGuardianAppearanceEvent extends CancellableEntityEvent {

    /**
     * The elder guardian playing the effect.
     *
     * @return The elder guardian
     */
    default ElderGuardian elderGuardian() {
        return (ElderGuardian) entity();
    }

    /**
     * Get the player affected by the guardian appearance.
     *
     * @return Player affected by the appearance
     */
    @Param(1)
    Player affectedPlayer();
}
