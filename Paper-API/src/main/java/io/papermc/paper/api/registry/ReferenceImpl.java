package io.papermc.paper.api.registry;

import io.papermc.paper.api.namespace.Keyed;
import io.papermc.paper.api.namespace.NamespacedKey;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

record ReferenceImpl<T extends Keyed>(@NonNull Registry<T> registry, @NonNull NamespacedKey key) implements Reference<T> {
    ReferenceImpl(@NonNull Registry<T> registry, @NonNull NamespacedKey key) {
        this.registry = registry;
        this.key = key;
    }

    public @NonNull T value() {
        T value = this.registry.get(this.key);
        return value;
    }

    public @Nullable T valueOrNull() {
        return this.registry.get(this.key);
    }

    public @NonNull NamespacedKey getKey() {
        return this.key;
    }

    public @NonNull Registry<T> registry() {
        return this.registry;
    }

    public @NonNull NamespacedKey key() {
        return this.key;
    }
}

