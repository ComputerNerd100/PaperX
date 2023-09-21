package io.papermc.paper.api.event.events.world;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.events.entity.EntityDeathEvent;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.Inventory;
import io.papermc.paper.api.inventory.InventoryHolder;
import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.loot.LootContext;
import io.papermc.paper.api.loot.LootTable;

import java.util.List;
import java.util.Random;

/**
 * Called when a {@link LootTable} is generated in the world for an
 * {@link InventoryHolder}.
 *
 * This event is NOT currently called when an entity's loot table has been
 * generated (use {@link EntityDeathEvent#drops()}, but WILL be called by
 * plugins invoking
 * {@link LootTable#fillInventory(Inventory, Random, LootContext)}.
 */
public interface LootGenerateEvent extends CancellableWorldEvent {

    /**
     * Get the entity used as context for loot generation (if applicable).
     *
     * For inventories where entities are not required to generate loot, such as
     * hoppers, null will be returned.
     *
     * This is a convenience method for
     * {@code getLootContext().getLootedEntity()}.
     *
     * @return the entity
     */
    @Param(1)
    Entity entity();

    /**
     * Get the inventory holder in which the loot was generated.
     *
     * If the loot was generated as a result of the block being broken, the
     * inventory holder will be null as this event is called post block break.
     *
     * @return the inventory holder
     */
    @Param(2)
    InventoryHolder inventoryHolder();

    /**
     * Get the loot table used to generate loot.
     *
     * @return the loot table
     */
    @Param(3)
    LootTable lootTable();

    /**
     * Get the loot context used to provide context to the loot table's loot
     * generation.
     *
     * @return the loot context
     */
    @Param(4)
    LootContext lootContext();

    /**
     * Get a mutable list of all loot to be generated.
     *
     * Any items added or removed from the returned list will be reflected in
     * the loot generation. Null items will be treated as air.
     *
     * @return the loot to generate
     */
    @Param(5)
    List<ItemStack> loot();

    /**
     * Check whether or not this event was called as a result of a plugin
     * invoking
     * {@link LootTable#fillInventory(Inventory, Random, LootContext)}.
     *
     * @return true if plugin caused, false otherwise
     */
    @Param(6)
    boolean plugin();
}
