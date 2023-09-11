package io.papermc.paper.api.entity;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.UUID;

public interface AnimalTamer {

    /**
     * This is the name of the specified AnimalTamer.
     *
     * @return The name to reference on tamed animals or null if a name cannot be obtained
     */
    @Nullable
    String getName();

    /**
     * This is the UUID of the specified AnimalTamer.
     *
     * @return The UUID to reference on tamed animals
     */
    @NonNull
    UUID getUniqueId();
}
