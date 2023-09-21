package io.papermc.paper.api.event.events.inventory;

import io.papermc.paper.api.event.events.block.CancellableBlockEvent;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Called when an ItemStack is about to increase the fuel level of a brewing
 * stand.
 */
public interface BrewingStandFuelEvent extends CancellableBlockEvent {

    /**
     * Gets the ItemStack of the fuel before the amount was subtracted.
     *
     * @return the fuel ItemStack
     */
    @Param(1)
    ItemStack fuel();

    /**
     * Gets the fuel power for this fuel. Each unit of power can fuel one
     * brewing operation.
     *
     * @return the fuel power for this fuel
     */
    @Param(2)
    int fuelPower();

    /**
     * Gets whether the brewing stand's fuel will be reduced / consumed or not.
     *
     * @return whether the fuel will be reduced or not
     */
    @Param(3)
    boolean consuming();
}
