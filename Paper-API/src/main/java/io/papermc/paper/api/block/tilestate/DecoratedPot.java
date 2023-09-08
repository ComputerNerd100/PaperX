package io.papermc.paper.api.block.tilestate;

import io.papermc.paper.api.material.Material;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

/**
 * Represents a captured state of a decorated pot.
 */
public interface DecoratedPot extends TileState {

    /**
     * Set the sherd on the provided side.
     *
     * @param side the side to set
     * @param sherd the sherd, or null to set a blank side.
     * @throws IllegalArgumentException if the sherd is not either
     * tagged by {@link Tag#ITEMS_DECORATED_POT_SHERDS}, {@link Material#BRICK},
     * or {@code null}
     */
    public void setSherd(@NonNull Side side, @Nullable Material sherd);

    /**
     * Get the sherd on the provided side.
     *
     * @param side the side to get
     * @return the sherd on the side or {@link Material#BRICK} if it's blank
     */
    @NonNull
    public Material getSherd(@NonNull Side side);

    /**
     * Gets a Map of all sides on this decorated pot and the sherds on them.
     * If a side does not have a specific sherd on it, {@link Material#BRICK}
     * will be the value of that side.
     *
     * @return the sherds
     */
    @NonNull
    public Map<Side, Material> getSherds();

    /**
     * Gets the sherds on this decorated pot. For faces without a specific sherd,
     * {@link Material#BRICK} is used in its place.
     *
     * @return the sherds
     * @deprecated in favor of {@link #getSherds()}
     */
    @Deprecated
    @NonNull
    public List<Material> getShards();

    /**
     * A side on a decorated pot. Sides are relative to the facing state of a
     * {@link org.bukkit.block.data.type.DecoratedPot}.
     */
    public static enum Side {
        BACK,
        LEFT,
        RIGHT,
        FRONT
    }
}
