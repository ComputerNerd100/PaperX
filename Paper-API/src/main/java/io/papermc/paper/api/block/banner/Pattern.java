package io.papermc.paper.api.block.banner;

import com.google.common.collect.ImmutableMap;
import io.papermc.paper.api.block.color.DyeColor;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Map;
import java.util.NoSuchElementException;

public class Pattern implements ConfigurationSerializable {

    private static final String COLOR = "color";
    private static final String PATTERN = "pattern";

    private final DyeColor color;
    private final PatternType pattern;

    /**
     * Creates a new pattern from the specified color and
     * pattern type
     *
     * @param color   the pattern color
     * @param pattern the pattern type
     */
    public Pattern(@NonNull DyeColor color, @NonNull PatternType pattern) {
        this.color = color;
        this.pattern = pattern;
    }

    /**
     * Constructor for deserialization.
     *
     * @param map the map to deserialize from
     */
    public Pattern(@NonNull Map<String, Object> map) {
        color = DyeColor.legacyValueOf(getString(map, COLOR));
        pattern = PatternType.getByIdentifier(getString(map, PATTERN));
    }

    private static String getString(@NonNull Map<?, ?> map, @NonNull Object key) {
        Object str = map.get(key);
        if (str instanceof String) {
            return (String) str;
        }
        throw new NoSuchElementException(map + " does not contain " + key);
    }

    @NonNull
    @Override
    public Map<String, Object> serialize() {
        return ImmutableMap.of(
                COLOR, color.toString(),
                PATTERN, pattern.getIdentifier()
        );
    }

    /**
     * Returns the color of the pattern
     *
     * @return the color of the pattern
     */
    @NonNull
    public DyeColor getColor() {
        return color;
    }

    /**
     * Returns the type of pattern
     *
     * @return the pattern type
     */
    @NonNull
    public PatternType getPattern() {
        return pattern;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.color != null ? this.color.hashCode() : 0);
        hash = 97 * hash + (this.pattern != null ? this.pattern.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pattern other = (Pattern) obj;
        return this.color == other.color && this.pattern == other.pattern;
    }
}

