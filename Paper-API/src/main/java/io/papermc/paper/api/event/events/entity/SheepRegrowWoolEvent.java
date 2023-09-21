package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Sheep;

/**
 * Called when a sheep regrows its wool
 */
public interface SheepRegrowWoolEvent extends CancellableEntityEvent {
    default Sheep sheep() {
        return (Sheep) entity();
    }
}
