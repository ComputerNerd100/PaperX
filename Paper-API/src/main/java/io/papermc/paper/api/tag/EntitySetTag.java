package io.papermc.paper.api.tag;

import io.papermc.paper.api.entity.EntityType;
import io.papermc.paper.api.namespace.NamespacedKey;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EntitySetTag extends BaseTag<EntityType, EntitySetTag> {

    public EntitySetTag(@NonNull NamespacedKey key, @NonNull Predicate<EntityType> filter) {
        super(EntityType.class, key, filter);
    }

    public EntitySetTag(@NonNull NamespacedKey key, @NonNull EntityType... values) {
        super(EntityType.class, key, values);
    }

    public EntitySetTag(@NonNull NamespacedKey key, @NonNull Collection<EntityType> values) {
        super(EntityType.class, key, values);
    }

    public EntitySetTag(@NonNull NamespacedKey key, @NonNull Collection<EntityType> values, @NonNull Predicate<EntityType>... globalPredicates) {
        super(EntityType.class, key, values, globalPredicates);
    }

    @NonNull
    @Override
    protected Set<EntityType> getAllPossibleValues() {
        return Stream.of(EntityType.values()).collect(Collectors.toSet());
    }

    @NonNull
    @Override
    protected String getName(@NonNull EntityType value) {
        return value.name();
    }
}

