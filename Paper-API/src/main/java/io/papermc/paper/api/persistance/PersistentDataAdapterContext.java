package io.papermc.paper.api.persistance;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * This interface represents the context in which the {@link PersistentDataType} can
 * serialize and deserialize the passed values.
 */
public interface PersistentDataAdapterContext {
    /**
     * Creates a new and empty meta container instance.
     *
     * @return the fresh container instance
     */
    @NonNull
    PersistentDataContainer newPersistentDataContainer();
}
