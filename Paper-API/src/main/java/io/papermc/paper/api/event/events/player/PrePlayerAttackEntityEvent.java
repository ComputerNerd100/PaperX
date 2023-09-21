package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when the player tries to attack an entity.
 *
 * This occurs before any of the damage logic, so cancelling this event
 * will prevent any sort of sounds from being played when attacking.
 *
 * This event will fire as cancelled for certain entities, with {@link PrePlayerAttackEntityEvent#willAttack()} being false
 * to indicate that this entity will not actually be attacked.
 * <p>
 * Note: there may be other factors (invulnerability, etc) that will prevent this entity from being attacked that this event will not cover
 */
public interface PrePlayerAttackEntityEvent extends CancellablePlayerEvent {

    /**
     * Gets the entity that was attacked in this event.
     * @return entity that was attacked
     */
    @Param(1)
    Entity attacked();

    /**
     * Gets if this entity will be attacked normally.
     * Entities like falling sand will return false because
     * their entity type does not allow them to be attacked.
     * <p>
     * Note: there may be other factors (invulnerability, etc) that will prevent this entity from being attacked that this event will not cover
     * @return if the entity will actually be attacked
     */
    @Param(2)
    boolean willAttack();
}
