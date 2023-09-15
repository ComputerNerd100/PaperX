package io.papermc.paper.api.tag;

import com.google.common.collect.Lists;
import io.papermc.paper.api.namespace.Keyed;
import io.papermc.paper.api.namespace.NamespacedKey;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class BaseTag<T extends Keyed, C extends BaseTag<T, C>> implements Tag<T> {

    protected final NamespacedKey key;
    protected final Set<T> tagged;
    private final List<Predicate<T>> globalPredicates;
    private boolean locked = false;

    public BaseTag(@NonNull Class<T> clazz, @NonNull NamespacedKey key, @NonNull Predicate<T> filter) {
        this(clazz, key);
        add(filter);
    }

    public BaseTag(@NonNull Class<T> clazz, @NonNull NamespacedKey key, @NonNull T...values) {
        this(clazz, key, Lists.newArrayList(values));
    }

    public BaseTag(@NonNull Class<T> clazz, @NonNull NamespacedKey key, @NonNull Collection<T> values) {
        this(clazz, key, values, o -> true);
    }

    public BaseTag(@NonNull Class<T> clazz, @NonNull NamespacedKey key, @NonNull Collection<T> values, @NonNull Predicate<T>... globalPredicates) {
        this.key = key != null ? key : NamespacedKey.randomKey();
        this.tagged = clazz.isEnum() ? createEnumSet(clazz) : new HashSet<>();
        this.tagged.addAll(values);
        this.globalPredicates = Lists.newArrayList(globalPredicates);
    }

    private <E> Set<E> createEnumSet(Class<E> enumClass) {
        assert enumClass.isEnum();
        return (Set<E>) EnumSet.noneOf((Class<Enum>) enumClass);
    }

    public @NonNull C lock() {
        this.locked = true;
        return (C) this;
    }

    public boolean isLocked() {
        return this.locked;
    }

    private void checkLock() {
        if (this.locked) {
            throw new UnsupportedOperationException("Tag (" + this.key + ") is locked");
        }
    }

    @NonNull
    @Override
    public NamespacedKey getKey() {
        return key;
    }

    @NonNull
    @Override
    public Set<T> getValues() {
        return Collections.unmodifiableSet(tagged);
    }

    @Override
    public boolean isTagged(@NonNull T item) {
        return tagged.contains(item);
    }

    @NonNull
    public C add(@NonNull Tag<T>...tags) {
        for (Tag<T> tag : tags) {
            add(tag.getValues());
        }
        return (C) this;
    }

    @NonNull
    public C add(@NonNull T...values) {
        this.checkLock();
        this.tagged.addAll(Lists.newArrayList(values));
        return (C) this;
    }

    @NonNull
    public C add(@NonNull Collection<T> collection) {
        this.checkLock();
        this.tagged.addAll(collection);
        return (C) this;
    }

    @NonNull
    public C add(@NonNull Predicate<T> filter) {
        return add(getAllPossibleValues().stream().filter(globalPredicates.stream().reduce(Predicate::or).orElse(t -> true)).filter(filter).collect(Collectors.toSet()));
    }

    @NonNull
    public C contains(@NonNull String with) {
        return add(value -> getName(value).contains(with));
    }

    @NonNull
    public C endsWith(@NonNull String with) {
        return add(value -> getName(value).endsWith(with));
    }

    @NonNull
    public C startsWith(@NonNull String with) {
        return add(value -> getName(value).startsWith(with));
    }

    @NonNull
    public C not(@NonNull Tag<T>...tags) {
        for (Tag<T> tag : tags) {
            not(tag.getValues());
        }
        return (C) this;
    }

    @NonNull
    public C not(@NonNull T...values) {
        this.checkLock();
        this.tagged.removeAll(Lists.newArrayList(values));
        return (C) this;
    }

    @NonNull
    public C not(@NonNull Collection<T> values) {
        this.checkLock();
        this.tagged.removeAll(values);
        return (C) this;
    }

    @NonNull
    public C not(@NonNull Predicate<T> filter) {
        not(getAllPossibleValues().stream().filter(globalPredicates.stream().reduce(Predicate::or).orElse(t -> true)).filter(filter).collect(Collectors.toSet()));
        return (C) this;
    }

    @NonNull
    public C notContains(@NonNull String with) {
        return not(value -> getName(value).contains(with));
    }

    @NonNull
    public C notEndsWith(@NonNull String with) {
        return not(value -> getName(value).endsWith(with));
    }

    @NonNull
    public C notStartsWith(@NonNull String with) {
        return not(value -> getName(value).startsWith(with));
    }

    @NonNull
    public C ensureSize(@NonNull String label, int size) {
        long actual = this.tagged.stream().filter(globalPredicates.stream().reduce(Predicate::or).orElse(t -> true)).count();
        if (size != actual) {
            throw new IllegalStateException(key.toString() + ": " + label + " - Expected " + size + " values, got " + actual);
        }
        return (C) this;
    }

    @NonNull
    protected abstract Set<T> getAllPossibleValues();

    @NonNull
    protected abstract String getName(@NonNull T value);
}

