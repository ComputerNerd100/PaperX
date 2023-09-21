package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Sheep;

/**
 * Called when a sheep's wool is dyed
 */
public interface SheepDyeWoolEvent extends EntityDyeEvent {
    default Sheep sheep() {
        return (Sheep) entity();
    }
}
