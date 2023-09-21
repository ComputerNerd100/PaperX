package io.papermc.paper.api.event.events.world;

import io.papermc.paper.api.event.type.ResultEvent;
import io.papermc.paper.api.world.World;

/**
 * Represents a world event that has a result
 * <p>
 *     <b>
 *         Anything that implements/extends this interface cannon inherit {@link CancellableWorldEvent}
 *     </b>
 */
public interface WorldResultEvent extends WorldEvent, ResultEvent<World> {
    default World world() {
        return this.result();
    }
    default void setWorld(World world) {
        rawResult().set(world);
    }
}
