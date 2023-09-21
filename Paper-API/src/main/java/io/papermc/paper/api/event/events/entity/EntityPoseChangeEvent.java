package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.entity.Pose;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when an entity changes its pose.
 *
 * @see Entity#getPose()
 */
public interface EntityPoseChangeEvent extends EntityResultEvent {

    /**
     * Gets the entity's new pose.
     *
     * @return the new pose
     */
    @Param(0)
    Pose pose();
}
