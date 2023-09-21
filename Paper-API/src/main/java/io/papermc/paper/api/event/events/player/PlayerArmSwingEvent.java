package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.EquipmentSlot;

/**
 * Represents a player arm swing event
 */
public interface PlayerArmSwingEvent extends PlayerAnimationEvent {

    /**
     * Returns the hand of the arm swing.
     *
     * @return the hand
     */
    @Param(2)
    EquipmentSlot equipmentSlot();
}
