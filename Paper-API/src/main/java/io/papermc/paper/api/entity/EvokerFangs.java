package io.papermc.paper.api.entity;


import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents Evoker Fangs.
 */
public interface EvokerFangs extends Entity {

    /**
     * Gets the {@link LivingEntity} which summoned the fangs.
     *
     * @return the {@link LivingEntity} which summoned the fangs
     */
    @Nullable
    LivingEntity getOwner();

    /**
     * Sets the {@link LivingEntity} which summoned the fangs.
     *
     * @param owner the {@link LivingEntity} which summoned the fangs
     */
    void setOwner(@Nullable LivingEntity owner);
}

