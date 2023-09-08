package io.papermc.paper.api.inventory.meta;

import io.papermc.paper.api.material.Material;
import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.jetbrains.annotations.Contract;

/**
 * Represents a book ({@link Material#WRITABLE_BOOK} or {@link
 * Material#WRITTEN_BOOK}) that can have a title, an author, and pages.
 */
public interface BookMeta extends ItemMeta, net.kyori.adventure.inventory.Book { // Paper

    /**
     * Represents the generation (or level of copying) of a written book
     */
    enum Generation {
        /**
         * Book written into a book-and-quill. Can be copied. (Default value)
         */
        ORIGINAL,
        /**
         * Book that was copied from an original. Can be copied.
         */
        COPY_OF_ORIGINAL,
        /**
         * Book that was copied from a copy of an original. Can't be copied.
         */
        COPY_OF_COPY,
        /**
         * Unused; unobtainable by players. Can't be copied.
         */
        TATTERED;
    }

    /**
     * Checks for the existence of a title in the book.
     *
     * @return true if the book has a title
     */
    boolean hasTitle();

    /**
     * Gets the title of the book.
     * <p>
     * Plugins should check that hasTitle() returns true before calling this
     * method.
     *
     * @return the title of the book
     */
    @Nullable
    String getTitle();

    /**
     * Sets the title of the book.
     * <p>
     * Limited to 32 characters. Removes title when given null.
     *
     * @param title the title to set
     * @return true if the title was successfully set
     */
    boolean setTitle(@Nullable String title);

    /**
     * Checks for the existence of an author in the book.
     *
     * @return true if the book has an author
     */
    boolean hasAuthor();

    /**
     * Gets the author of the book.
     * <p>
     * Plugins should check that hasAuthor() returns true before calling this
     * method.
     *
     * @return the author of the book
     */
    @Nullable
    String getAuthor();

    /**
     * Sets the author of the book. Removes author when given null.
     *
     * @param author the author to set
     */
    void setAuthor(@Nullable String author);

    /**
     * Checks for the existence of generation level in the book.
     *
     * @return true if the book has a generation level
     */
    boolean hasGeneration();

    /**
     * Gets the generation of the book.
     * <p>
     * Plugins should check that hasGeneration() returns true before calling
     * this method.
     *
     * @return the generation of the book
     */
    @Nullable
    Generation getGeneration();

    /**
     * Sets the generation of the book. Removes generation when given null.
     *
     * @param generation the generation to set
     */
    void setGeneration(@Nullable Generation generation);

    /**
     * Checks for the existence of pages in the book.
     *
     * @return true if the book has pages
     */
    boolean hasPages();

    /**
     * Gets the title of the book.
     * <p>
     * Plugins should check that hasTitle() returns true before calling this
     * method.
     *
     * @return the title of the book
     */
    @Override
    @Nullable Component title();

    /**
     * Sets the title of the book.
     * <p>
     * Limited to 32 characters. Removes title when given null.
     *
     * @param title the title to set
     * @return the same {@link BookMeta} instance
     */
    @Contract(value = "_ -> this", pure = false)
    @Override
    @NonNull BookMeta title(net.kyori.adventure.text.@Nullable Component title);

    /**
     * Gets the author of the book.
     * <p>
     * Plugins should check that hasAuthor() returns true before calling this
     * method.
     *
     * @return the author of the book
     */
    @Override
    @Nullable Component author();

    /**
     * Sets the author of the book. Removes author when given null.
     *
     * @param author the author to set
     * @return the same {@link BookMeta} instance
     */
    @Contract(value = "_ -> this", pure = false)
    @Override
    @NonNull BookMeta author(net.kyori.adventure.text.@Nullable Component author);

    /**
     * Gets the specified page in the book. The page must exist.
     * <p>
     * Pages are 1-indexed.
     *
     * @param page the page number to get, in range [1, getPageCount()]
     * @return the page from the book
     */
    net.kyori.adventure.text.@NonNull Component page(int page);

    /**
     * Sets the specified page in the book. Pages of the book must be
     * contiguous.
     * <p>
     * The data can be up to 256 characters in length, additional characters
     * are truncated.
     * <p>
     * Pages are 1-indexed.
     *
     * @param page the page number to set, in range [1, getPageCount()]
     * @param data the data to set for that page
     */
    void page(int page, net.kyori.adventure.text.@NonNull Component data);

    /**
     * Adds new pages to the end of the book. Up to a maximum of 50 pages with
     * 256 characters per page.
     *
     * @param pages A list of strings, each being a page
     */
    void addPages(net.kyori.adventure.text.@NonNull Component @NonNull ... pages);

    interface BookMetaBuilder extends Builder {

        @Override
        @NonNull BookMetaBuilder title(net.kyori.adventure.text.@Nullable Component title);

        @Override
        @NonNull BookMetaBuilder author(net.kyori.adventure.text.@Nullable Component author);

        @Override
        @NonNull BookMetaBuilder addPage(net.kyori.adventure.text.@NonNull Component page);

        @Override
        @NonNull BookMetaBuilder pages(net.kyori.adventure.text.@NonNull Component @NonNull ... pages);

        @Override
        @NonNull BookMetaBuilder pages(java.util.@NonNull Collection<net.kyori.adventure.text.Component> pages);

        @Override
        @NonNull BookMeta build();
    }

    @Override
    @NonNull BookMetaBuilder toBuilder();
    
    /**
     * Gets the number of pages in the book.
     *
     * @return the number of pages in the book
     */
    int getPageCount();

    @Override
    @NonNull
    BookMeta clone();

}
