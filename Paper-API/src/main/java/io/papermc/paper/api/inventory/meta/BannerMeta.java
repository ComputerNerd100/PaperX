package io.papermc.paper.api.inventory.meta;

import io.papermc.paper.api.block.banner.Pattern;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

public interface BannerMeta extends ItemMeta {
    
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
     * @throws IndexOutOfBoundsException when index is not in [0, numberOfPatterns()) range
     */
    @NonNull
    Pattern getPattern(int i);

    /**
     * Removes the pattern at the specified index
     *
     * @param i the index
     * @return the removed pattern
     * @throws IndexOutOfBoundsException when index is not in [0, numberOfPatterns()) range
     */
    @NonNull
    Pattern removePattern(int i);

    /**
     * Sets the pattern at the specified index
     *
     * @param i       the index
     * @param pattern the new pattern
     * @throws IndexOutOfBoundsException when index is not in [0, numberOfPatterns()) range
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

