package io.papermc.paper.api.inventory.meta;

import io.papermc.paper.api.entity.EntityType;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents a spawn egg and it's spawned type.
 */
public interface SpawnEggMeta extends ItemMeta {
    
    /**
     * Get the custom type of entity this egg will spawn.
     *
     * @return the entity type or null if no custom type is set
     */
    @Nullable EntityType getCustomSpawnedType();

    /**
     * Set the custom type of entity this egg will spawn.
     *
     * @param type the entity type or null to clear the custom type
     */
    void setCustomSpawnedType(@Nullable EntityType type);

    @NonNull
    @Override
    SpawnEggMeta clone();
}

