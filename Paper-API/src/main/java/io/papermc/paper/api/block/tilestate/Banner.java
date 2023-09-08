package io.papermc.paper.api.block.tilestate;

import io.papermc.paper.api.Nameable;
import io.papermc.paper.api.block.banner.Pattern;
import io.papermc.paper.api.block.color.DyeColor;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

/**
 * Represents a captured state of a banner.
 */
public interface
Banner extends TileState, Nameable {

    /**
     * Returns the base color for this banner
     *
     * @return the base color
     */
    @NonNull
    DyeColor getBaseColor();

    /**
     * Sets the base color for this banner.
     * <b>Only valid for shield pseudo banners, otherwise base depends on block
     * type</b>
     *
     * @param color the base color
     */
    void setBaseColor(@NonNull DyeColor color);

    /**
     * Returns a list of patterns on this banner
     *
     * @return the patterns
     */
    @NonNull
    List<Pattern> getPatterns();

    /**
     * Sets the patterns used on this banner
     *
     * @param patterns the new list of patterns
     */
    void setPatterns(@NonNull List<Pattern> patterns);

    /**
     * Adds a new pattern on top of the existing
     * patterns
     *
     * @param pattern the new pattern to add
     */
    void addPattern(@NonNull Pattern pattern);

    /**
     * Returns the pattern at the specified index
     *
     * @param i the index
     * @return the pattern
     */
    @NonNull
    Pattern getPattern(int i);

    /**
     * Removes the pattern at the specified index
     *
     * @param i the index
     * @return the removed pattern
     */
    @NonNull
    Pattern removePattern(int i);

    /**
     * Sets the pattern at the specified index
     *
     * @param i       the index
     * @param pattern the new pattern
     */
    void setPattern(int i, @NonNull Pattern pattern);

    /**
     * Returns the number of patterns on this
     * banner
     *
     * @return the number of patterns
     */
    int numberOfPatterns();
}

