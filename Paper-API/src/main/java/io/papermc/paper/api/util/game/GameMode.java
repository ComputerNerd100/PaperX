package io.papermc.paper.api.util.game;


import com.google.common.collect.Maps;
import io.papermc.paper.api.entity.HumanEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Represents the various type of game modes that {@link HumanEntity}s may
 * have
 */
public enum GameMode implements net.kyori.adventure.translation.Translatable { // Paper - implement Translatable
    /**
     * Creative mode may fly, build instantly, become invulnerable and create
     * free items.
     */
    CREATIVE(1),

    /**
     * Survival mode is the "normal" gameplay type, with no special features.
     */
    SURVIVAL(0),

    /**
     * Adventure mode cannot break blocks without the correct tools.
     */
    ADVENTURE(2),

    /**
     * Spectator mode cannot interact with the world in anyway and is
     * invisible to normal players. This grants the player the
     * ability to no-clip through the world.
     */
    SPECTATOR(3);

    private final int value;
    private static final Map<Integer, GameMode> BY_ID = Maps.newHashMap();
    private final String translationKey;

    @Override
    public @NotNull String translationKey() {
        return this.translationKey;
    }

    GameMode(final int value) {
        this.value = value;
        this.translationKey = "gameMode." +  this.name().toLowerCase(java.util.Locale.ENGLISH); // Paper
    }

    /**
     * Gets the mode value associated with this GameMode
     *
     * @return An integer value of this gamemode
     * @deprecated Magic value
     */
    @Deprecated
    public int getValue() {
        return value;
    }

    /**
     * Gets the GameMode represented by the specified value
     *
     * @param value Value to check
     * @return Associative {@link GameMode} with the given value, or null if
     *     it doesn't exist
     * @deprecated Magic value
     */
    @Deprecated
    @Nullable
    public static GameMode getByValue(final int value) {
        return BY_ID.get(value);
    }

    static {
        for (GameMode mode : values()) {
            BY_ID.put(mode.getValue(), mode);
        }
    }
}

