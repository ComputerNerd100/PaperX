package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.EntityType;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.material.Material;
import io.papermc.paper.api.util.Statistic;

/**
 * Called when a player statistic is incremented.
 * <p>
 * This event is not called for some high frequency statistics, e.g. movement
 * based statistics.
 *
 */
public interface PlayerStatisticIncrementEvent extends CancellablePlayerEvent {

    /**
     * Gets the statistic that is being incremented.
     *
     * @return the incremented statistic
     */
    @Param(1)
    Statistic statistic();

    /**
     * Gets the previous value of the statistic.
     *
     * @return the previous value of the statistic
     */
    @Param(2)
    int initialValue();

    /**
     * Gets the new value of the statistic.
     *
     * @return the new value of the statistic
     */
    @Param(3)
    int newValue();

    /**
     * Gets the EntityType if {@link #statistic()}  getStatistic()} is an
     * entity statistic otherwise returns null.
     *
     * @return the EntityType of the statistic
     */
    @Param(4)
    EntityType entityType();

    /**
     * Gets the Material if {@link #statistic()}  getStatistic()} is a block
     * or item statistic otherwise returns null.
     *
     * @return the Material of the statistic
     */
    @Param(5)
    Material material();
}
