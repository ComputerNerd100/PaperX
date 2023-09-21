package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.LivingEntity;
import io.papermc.paper.api.event.util.Param;
import net.kyori.adventure.text.Component;

/**
 * Called when the player is attempting to rename a mob
 */
public interface PlayerNameEntityEvent extends CancellablePlayerEvent {

    /**
     * Gets the entity involved in this event.
     *
     * @return the entity
     */
    @Param(1)
    LivingEntity entity();

    /**
     * Gets the name to be given to the entity.
     * @return the name
     */
    @Param(2)
    Component name();

    /**
     * Gets whether this will set the mob to be persistent.
     *
     * @return persistent
     */
    @Param(3)
    boolean persistent();
}
