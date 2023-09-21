package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Enderman;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;

/**
 * Fired when an Enderman determines if it should attack a player or not.
 * Starts off cancelled if the player is wearing a pumpkin head or is not looking
 * at the Enderman, according to Vanilla rules.
 *
 */
public interface EndermanAttackPlayerEvent extends CancellableEntityEvent {

    /**
     * The enderman considering attacking
     *
     * @return The enderman considering attacking
     */
    default Enderman enderman() {
        return (Enderman) this.entity();
    }

    /**
     * The player the Enderman is considering attacking
     *
     * @return The player the Enderman is considering attacking
     */
    @Param(1)
    Player player();
}
