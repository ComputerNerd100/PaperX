package io.papermc.paper.api.registry;

import io.papermc.paper.api.namespace.Keyed;
import io.papermc.paper.api.namespace.NamespacedKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

record ReferenceImpl<T extends Keyed>(@NotNull Registry<T> registry, @NotNull NamespacedKey key) implements Reference<T> {
    ReferenceImpl(@NotNull Registry<T> registry, @NotNull NamespacedKey key) {
        this.registry = registry;
        this.key = key;
    }

    public @NotNull T value() {
        T value = this.registry.get(this.key);
        return value;
    }

    public @Nullable T valueOrNull() {
        return this.registry.get(this.key);
    }

    public @NotNull NamespacedKey getKey() {
        return this.key;
    }

    public @NotNull Registry<T> registry() {
        return this.registry;
    }

    public @NotNull NamespacedKey key() {
        return this.key;
    }
}

