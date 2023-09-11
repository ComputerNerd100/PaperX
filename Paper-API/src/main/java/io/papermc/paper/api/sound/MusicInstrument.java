package io.papermc.paper.api.sound;

import com.google.common.base.Preconditions;
import io.papermc.paper.api.namespace.Keyed;
import io.papermc.paper.api.namespace.NamespacedKey;
import net.kyori.adventure.translation.Translatable;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class MusicInstrument implements Keyed, Translatable { 

    private static final Map<NamespacedKey, MusicInstrument> INSTRUMENTS = new HashMap<>();
    public static final MusicInstrument PONDER = getInstrument("ponder_goat_horn");
    public static final MusicInstrument SING = getInstrument("sing_goat_horn");
    public static final MusicInstrument SEEK = getInstrument("seek_goat_horn");
    public static final MusicInstrument FEEL = getInstrument("feel_goat_horn");
    public static final MusicInstrument ADMIRE = getInstrument("admire_goat_horn");
    public static final MusicInstrument CALL = getInstrument("call_goat_horn");
    public static final MusicInstrument YEARN = getInstrument("yearn_goat_horn");
    public static final MusicInstrument DREAM = getInstrument("dream_goat_horn");
    private final NamespacedKey key;

    private MusicInstrument(NamespacedKey key) {
        this.key = key;

        INSTRUMENTS.put(key, this);
    }

    @NonNull
    @Override
    public NamespacedKey getKey() {
        return key;
    }

    /**
     * Returns a {@link MusicInstrument} by a {@link NamespacedKey}.
     *
     * @param namespacedKey the key
     * @return the event or null
     */
    @Nullable
    public static MusicInstrument getByKey(@NonNull NamespacedKey namespacedKey) {
        Preconditions.checkArgument(namespacedKey != null, "NamespacedKey cannot be null");

        return INSTRUMENTS.get(namespacedKey);
    }

    /**
     * Returns all known MusicInstruments.
     *
     * @return the memoryKeys
     */
    @NonNull
    public static Collection<MusicInstrument> values() {
        return Collections.unmodifiableCollection(INSTRUMENTS.values());
    }

    private static MusicInstrument getInstrument(@NonNull String name) {
        Preconditions.checkArgument(name != null, "Instrument name cannot be null");

        return new MusicInstrument(NamespacedKey.minecraft(name));
    }
    
    @Override
    public @NonNull String translationKey() {
        return "instrument.minecraft." + this.key.value();
    }
}

