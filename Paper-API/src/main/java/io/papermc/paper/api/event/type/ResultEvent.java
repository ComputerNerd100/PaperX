package io.papermc.paper.api.event.type;

import io.papermc.paper.api.event.util.Param;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Represents an event that has a result.
 * @param <T> the type of the result
 */
public interface ResultEvent<T> {

    /**
     * Gets an {@link AtomicReference} containing the result.
     * @return the result
     */
    @Param(-1)
    @NonNull AtomicReference<T> rawResult();

    /**
     * Checks if a result has been set for the event.
     * @return {@code true} if there is a result
     */
    default boolean hasResult() {
        return rawResult().get() != null;
    }

    /**
     * Get the result from {@link #rawResult()}
     * @return the result contained within the {@link AtomicReference} in this event, or {@code null} if no result has been set
     */
    default @Nullable T result() {
        return rawResult().get();
    }

}
