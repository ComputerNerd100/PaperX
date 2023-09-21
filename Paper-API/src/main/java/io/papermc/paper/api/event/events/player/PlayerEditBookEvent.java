package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.meta.BookMeta;

/**
 * Called when a player edits or signs a book and quill item. If the event is
 * cancelled, no changes are made to the BookMeta
 */
public interface PlayerEditBookEvent extends CancellablePlayerEvent {

    /**
     * Gets the book meta currently on the book.
     * <p>
     * Note: this is a copy of the book meta. You cannot use this object to
     * change the existing book meta.
     *
     * @return the book meta currently on the book
     */
    @Param(1)
    BookMeta previousBookMeta();
    /**
     * Gets the book meta that the player is attempting to add to the book.
     * <p>
     * Note: this is a copy of the proposed new book meta.
     *
     * @return the book meta that the player is attempting to add
     */
    @Param(2)
    BookMeta newBookMeta();

    /**
     * Gets whether or not the book is being signed. If a book is signed the
     * Material changes from BOOK_AND_QUILL to WRITTEN_BOOK.
     *
     * @return true if the book is being signed
     */
    @Param(3)
    boolean signing();
}
