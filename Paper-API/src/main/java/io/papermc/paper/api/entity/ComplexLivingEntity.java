package io.papermc.paper.api.entity;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Set;

/**
 * Represents a complex living entity - one that is made up of various smaller
 * parts
 */
public interface ComplexLivingEntity extends LivingEntity {
    /**
     * Gets a list of parts that belong to this complex entity
     *
     * @return List of parts
     */
    @NonNull
    public Set<ComplexEntityPart> getParts();
}
