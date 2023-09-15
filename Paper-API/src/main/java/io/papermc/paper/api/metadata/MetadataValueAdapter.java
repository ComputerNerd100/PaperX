package io.papermc.paper.api.metadata;

import com.google.common.base.Preconditions;
import io.papermc.paper.api.util.NumberConversions;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.lang.ref.WeakReference;

public abstract class MetadataValueAdapter implements MetadataValue {
    protected final WeakReference<Plugin> owningPlugin;

    protected MetadataValueAdapter(@NonNull Plugin owningPlugin) {
        Preconditions.checkArgument(owningPlugin != null, "owningPlugin cannot be null");
        this.owningPlugin = new WeakReference<Plugin>(owningPlugin);
    }

    @Override
    @Nullable
    public Plugin getOwningPlugin() {
        return owningPlugin.get();
    }

    @Override
    public int asInt() {
        return NumberConversions.toInt(value());
    }

    @Override
    public float asFloat() {
        return NumberConversions.toFloat(value());
    }

    @Override
    public double asDouble() {
        return NumberConversions.toDouble(value());
    }

    @Override
    public long asLong() {
        return NumberConversions.toLong(value());
    }

    @Override
    public short asShort() {
        return NumberConversions.toShort(value());
    }

    @Override
    public byte asByte() {
        return NumberConversions.toByte(value());
    }

    @Override
    public boolean asBoolean() {
        Object value = value();
        if (value instanceof Boolean) {
            return (Boolean) value;
        }

        if (value instanceof Number) {
            return ((Number) value).intValue() != 0;
        }

        if (value instanceof String) {
            return Boolean.parseBoolean((String) value);
        }

        return value != null;
    }

    @Override
    @NonNull
    public String asString() {
        Object value = value();

        if (value == null) {
            return "";
        }
        return value.toString();
    }
}
