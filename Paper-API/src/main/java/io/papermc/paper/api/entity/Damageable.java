package io.papermc.paper.api.entity;

import io.papermc.paper.api.attribute.Attribute;
import org.checkerframework.checker.nullness.qual.Nullable;


/**
 * Represents an {@link Entity} that has health and can take damage.
 */
public interface Damageable extends Entity {
    /**
     * Deals the given amount of damage to this entity.
     *
     * @param amount Amount of damage to deal
     */
    void damage(double amount);

    /**
     * Deals the given amount of damage to this entity, from a specified
     * entity.
     *
     * @param amount Amount of damage to deal
     * @param source Entity which to attribute this damage from
     */
    void damage(double amount, @Nullable Entity source);

    /**
     * Gets the entity's health from 0 to {@link Attribute#GENERIC_MAX_HEALTH}, where 0 is dead.
     *
     * @return Health represented from 0 to max
     */
    double getHealth();

    /**
     * Sets the entity's health from 0 to {@link Attribute#GENERIC_MAX_HEALTH}, where 0 is
     * dead.
     *
     * @param health New health represented from 0 to max
     * @throws IllegalArgumentException Thrown if the health is {@literal < 0 or >}
     *     {@link Attribute#GENERIC_MAX_HEALTH}
     */
    void setHealth(double health);

    /**
     * Gets the entity's absorption amount.
     *
     * @return absorption amount from 0
     */
    double getAbsorptionAmount();

    /**
     * Sets the entity's absorption amount.
     *
     * @param amount new absorption amount from 0
     * @throws IllegalArgumentException thrown if health is {@literal < 0} or
     * non-finite.
     */
    void setAbsorptionAmount(double amount);
}

