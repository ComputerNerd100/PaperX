package io.papermc.paper.api.entity.ai;

import com.google.common.base.Objects;
import io.papermc.paper.api.entity.Mob;
import io.papermc.paper.api.namespace.NamespacedKey;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.StringJoiner;

/**
 * Used to identify a Goal. Consists of a {@link NamespacedKey} and the type of mob the goal can be applied to
 *
 * @param <T> the type of mob the goal can be applied to
 */
public class GoalKey<T extends Mob> {

    private final Class<T> entityClass;
    private final NamespacedKey namespacedKey;

    private GoalKey(@NonNull Class<T> entityClass, @NonNull NamespacedKey namespacedKey) {
        this.entityClass = entityClass;
        this.namespacedKey = namespacedKey;
    }

    @NonNull
    public Class<T> getEntityClass() {
        return entityClass;
    }

    @NonNull
    public NamespacedKey getNamespacedKey() {
        return namespacedKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoalKey<?> goalKey = (GoalKey<?>) o;
        return Objects.equal(entityClass, goalKey.entityClass) &&
                Objects.equal(namespacedKey, goalKey.namespacedKey);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(entityClass, namespacedKey);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GoalKey.class.getSimpleName() + "[", "]")
                .add("entityClass=" + entityClass)
                .add("namespacedKey=" + namespacedKey)
                .toString();
    }

    @NonNull
    public static <A extends Mob> GoalKey<A> of(@NonNull Class<A> entityClass, @NonNull NamespacedKey namespacedKey) {
        return new GoalKey<>(entityClass, namespacedKey);
    }
}

