package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.AreaEffectCloud;
import io.papermc.paper.api.entity.LivingEntity;
import io.papermc.paper.api.event.util.Param;

import java.util.List;

/**
 * Called when a lingering potion applies its effects. Happens
 * once every 5 ticks
 */
public interface AreaEffectCloudApplyEvent extends CancellableEntityEvent {

    /**
     * Retrieves a mutable list of the effected entities
     * <p>
     * It is important to note that not every entity in this list
     * is guaranteed to be effected.  The cloud may die during the
     * application of its effects due to the depletion of {@link AreaEffectCloud#getDurationOnUse()}
     * or {@link AreaEffectCloud#getRadiusOnUse()}
     *
     * @return the affected entity list
     */
    @Param(1)
    List<LivingEntity> affectedEntities();
}
