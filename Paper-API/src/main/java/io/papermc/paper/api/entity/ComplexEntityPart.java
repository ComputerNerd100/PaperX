package io.papermc.paper.api.entity;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a single part of a {@link ComplexLivingEntity}
 */
public interface ComplexEntityPart extends Entity {

    /**
     * Gets the parent {@link ComplexLivingEntity} of this part.
     *
     * @return Parent complex entity
     */
    @NonNull
    public ComplexLivingEntity getParent();
}
