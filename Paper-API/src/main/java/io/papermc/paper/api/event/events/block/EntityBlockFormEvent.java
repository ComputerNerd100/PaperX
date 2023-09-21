package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.entity.Snowman;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a block is formed by entities.
 * <p>
 * Examples:
 * <ul>
 * <li>Snow formed by a {@link Snowman}.
 * <li>Frosted Ice formed by the Frost Walker enchantment.
 * </ul>
 */
public interface EntityBlockFormEvent extends BlockFormEvent {

    /**
     * Get the entity that formed the block.
     *
     * @return Entity involved in event
     */
    @Param(2)
    Entity entity();

}
