package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.LightningStrike;
import io.papermc.paper.api.entity.Pig;
import io.papermc.paper.api.entity.PigZombie;
import io.papermc.paper.api.event.util.Param;

/**
 * Stores data for pigs being zapped
 */
public interface PigZapEvent extends EntityZapEvent {
    default Pig pig() {
        return (Pig) entity();
    }

    /**
     * Gets the bolt which is striking the pig.
     *
     * @return lightning entity
     */
    @Param(5)
    LightningStrike bolt();

}
