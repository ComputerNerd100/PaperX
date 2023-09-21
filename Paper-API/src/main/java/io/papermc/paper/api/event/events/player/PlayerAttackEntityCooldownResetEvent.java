package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when processing a player's attack on an entity when the player's attack strength cooldown is reset
 */
public interface PlayerAttackEntityCooldownResetEvent extends CancellablePlayerEvent {

    /**
     * Get the value of the players cooldown attack strength when they initiated the attack
     *
     * @return returns the original player cooldown value
     */
    @Param(1)
    float cooledAttackStrength();

    /**
     * Returns the entity attacked by the player
     *
     * @return the entity attacked by the player
     */
    @Param(2)
    Entity attackedEntity();
}
