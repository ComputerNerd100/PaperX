package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.entity.LivingEntity;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when an equippable item is dispensed from a block and equipped on a
 * nearby entity.
 * <p>
 * If a Block Dispense Armor event is cancelled, the equipment will not be
 * equipped on the target entity.
 */
public interface BlockDispenseArmorEvent extends BlockDispenseEvent {

    /**
     * Get the living entity on which the armor was dispensed.
     *
     * @return the target entity
     */
    @Param(3)
    LivingEntity targetEntity();

}
