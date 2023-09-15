package io.papermc.paper.api.entity;

import io.papermc.paper.api.block.color.DyeColor;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Tropical fish.
 */
public interface TropicalFish extends SchoolableFish { // Paper - Schooling Fish API

    /**
     * Gets the color of the fish's pattern.
     *
     * @return pattern color
     */
    @NonNull
    DyeColor getPatternColor();

    /**
     * Sets the color of the fish's pattern
     *
     * @param color pattern color
     */
    void setPatternColor(@NonNull DyeColor color);

    /**
     * Gets the color of the fish's body.
     *
     * @return pattern color
     */
    @NonNull
    DyeColor getBodyColor();

    /**
     * Sets the color of the fish's body
     *
     * @param color body color
     */
    void setBodyColor(@NonNull DyeColor color);

    /**
     * Gets the fish's pattern.
     *
     * @return pattern
     */
    @NonNull
    Pattern getPattern();

    /**
     * Sets the fish's pattern
     *
     * @param pattern new pattern
     */
    void setPattern(@NonNull Pattern pattern);

    /**
     * Enumeration of all different fish patterns. Refer to the
     * <a href="https://minecraft.gamepedia.com/Fish_(mob)">Minecraft Wiki</a>
     * for pictures.
     */
    enum Pattern {

        KOB,
        SUNSTREAK,
        SNOOPER,
        DASHER,
        BRINELY,
        SPOTTY,
        FLOPPER,
        STRIPEY,
        GLITTER,
        BLOCKFISH,
        BETTY,
        CLAYFISH
    }
}

