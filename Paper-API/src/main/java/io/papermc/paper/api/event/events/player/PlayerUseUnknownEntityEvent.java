package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.EquipmentSlot;
import io.papermc.paper.api.util.vector.Vector;

/**
 * Represents an event that is called when a player right-clicks an unknown entity.
 * Useful for plugins dealing with virtual entities (entities that don't actually spawned on the server).
 * <br>
 * This event may be called multiple times per interaction with different interaction hands
 * and with or without the clicked position.
 */
public interface PlayerUseUnknownEntityEvent extends PlayerResultEvent {

    /**
     * Returns the entity id of the unknown entity that was interacted with.
     *
     * @return the entity id of the entity that was interacted with
     */
    @Param(0)
    int entityId();

    /**
     * Returns whether the interaction was an attack.
     *
     * @return true if the player is attacking the entity, false if the player is interacting with the entity
     */
    @Param(1)
    boolean attack();

    /**
     * Returns the hand used to perform this interaction.
     *
     * @return the hand used to interact
     */
    @Param(2)
    EquipmentSlot hand();

    /**
     * Returns the position relative to the entity that was clicked, or null if not available.
     * See {@link PlayerInteractAtEntityEvent} for more details.
     *
     * @return the position relative to the entity that was clicked, or null if not available
     * @see PlayerInteractAtEntityEvent
     */
    @Param(3)
    Vector clickedPosition();
}
