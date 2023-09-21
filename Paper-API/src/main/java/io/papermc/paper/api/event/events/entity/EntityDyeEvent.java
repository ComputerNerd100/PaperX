package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.block.color.DyeColor;
import io.papermc.paper.api.entity.Cat;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.entity.Sheep;
import io.papermc.paper.api.entity.Wolf;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when an entity is dyed. Currently, this is called for {@link Sheep}
 * being dyed, and {@link Wolf}/{@link Cat} collars being dyed.
 */
public interface EntityDyeEvent extends CancellableEntityEvent {

    /**
     * Gets the DyeColor the entity is being dyed
     *
     * @return the DyeColor the entity is being dyed
     */
    @Param(1)
    DyeColor color();

    /**
     * Returns the player dyeing the entity, if available.
     *
     * @return player or null
     */
    @Param(2)
    Player player();
}
