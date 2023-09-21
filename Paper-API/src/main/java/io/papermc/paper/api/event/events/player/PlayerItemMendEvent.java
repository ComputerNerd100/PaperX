package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.ExperienceOrb;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.EquipmentSlot;
import io.papermc.paper.api.inventory.ItemStack;

import java.util.function.IntUnaryOperator;

/**
 * Represents when a player has an item repaired via the Mending enchantment.
 * <br>
 * This event is fired directly before the {@link PlayerExpChangeEvent}, and the
 * results of this event directly affect the {@link PlayerExpChangeEvent}.
 */
public interface PlayerItemMendEvent extends CancellablePlayerEvent {

    /**
     * Get the {@link ItemStack} to be repaired.
     *
     * This is not necessarily the item the player is holding.
     *
     * @return the item to be repaired
     */
    @Param(1)
    ItemStack item();

    /**
     * Get the {@link EquipmentSlot} in which the repaired {@link ItemStack}
     * may be found.
     *
     * @return the repaired slot
     */
    @Param(2)
    EquipmentSlot slot();

    /**
     * Get the experience orb triggering the event.
     *
     * @return the experience orb
     */
    @Param(3)
    ExperienceOrb experienceOrb();

    /**
     * Get the amount the item is to be repaired.
     *
     * The default value is twice the value of the consumed experience orb
     * or the remaining damage left on the item, whichever is smaller.
     *
     * @return how much damage will be repaired by the experience orb
     */
    @Param(4)
    int repairAmount();

    /**
     * Get the operation used to calculate xp used based on
     * the set repair amount. Used to calculate how much of
     * an XP orb will be consumed by this mend operation.
     *
     * @return the durability-to-xp operation
     */
    @Param(5)
    IntUnaryOperator durabilityToXpOP();
}
