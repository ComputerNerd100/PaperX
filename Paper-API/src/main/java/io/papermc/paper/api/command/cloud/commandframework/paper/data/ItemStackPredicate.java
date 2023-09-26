package io.papermc.paper.api.command.cloud.commandframework.paper.data;

import io.papermc.paper.api.inventory.ItemStack;

import java.util.function.Predicate;

/**
 * {@link Predicate} for {@link ItemStack ItemStacks}, parsed from user input.
 *
 * @since 1.5.0
 */
public interface ItemStackPredicate extends Predicate<ItemStack> {

}

