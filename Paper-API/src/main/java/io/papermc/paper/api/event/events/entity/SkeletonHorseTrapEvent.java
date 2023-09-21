package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.HumanEntity;
import io.papermc.paper.api.entity.LightningStrike;
import io.papermc.paper.api.entity.SkeletonHorse;
import io.papermc.paper.api.event.util.Param;

import java.util.List;

/**
 * Event called when a player gets close to a skeleton horse and triggers the lightning trap
 */
public interface SkeletonHorseTrapEvent extends CancellableEntityEvent {
    default SkeletonHorse skeletonHorse() {
        return (SkeletonHorse) this.entity();
    }
    @Param(1)
    List<HumanEntity> eligibleHumans();
}
