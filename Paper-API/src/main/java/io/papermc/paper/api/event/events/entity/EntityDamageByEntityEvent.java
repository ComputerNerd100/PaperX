package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.AbstractArrow;
import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when an entity is damaged by an entity
 */
public interface EntityDamageByEntityEvent extends EntityDamageEvent {

    /**
     * Returns the entity that damaged the defender.
     *
     * @return Entity that damaged the defender.
     */
    @Param(2)
    Entity damager();

    /**
     * Shows this damage instance was critical.
     * The damage instance can be critical if the attacking player met the respective conditions.
     * Furthermore arrows may also cause a critical damage event if the arrow {@link AbstractArrow#isCritical()}.
     *
     * @return if the hit was critical.
     * @see <a href="https://minecraft.fandom.com/wiki/Damage#Critical_hit">https://minecraft.fandom.com/wiki/Damage#Critical_hit</a>
     */
    @Param(3)
    boolean critical();
}
