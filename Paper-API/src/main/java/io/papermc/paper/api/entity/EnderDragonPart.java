package io.papermc.paper.api.entity;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents an ender dragon part
 */
public interface EnderDragonPart extends ComplexEntityPart, Damageable {
    @Override
    @NonNull
    EnderDragon getParent();
}
