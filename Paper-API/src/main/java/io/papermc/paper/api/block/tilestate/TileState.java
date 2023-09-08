package io.papermc.paper.api.block.tilestate;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.block.BlockState;
import io.papermc.paper.api.persistance.PersistentDataContainer;
import io.papermc.paper.api.persistance.PersistentDataHolder;
import org.jetbrains.annotations.NotNull;

public interface TileState extends BlockState, PersistentDataHolder {
    /**
     * Returns a custom tag container capable of storing tags on the object.
     *
     * Note that the tags stored on this container are all stored under their
     * own custom namespace therefore modifying default tags using this
     * {@link PersistentDataHolder} is impossible.
     * <p>
     * This {@link PersistentDataHolder} is only linked to the snapshot instance
     * stored by the {@link BlockState}.
     *
     * When storing changes on the {@link PersistentDataHolder}, the updated
     * content will only be applied to the actual tile entity after one of the
     * {@link #update()} methods is called.
     *
     * @return the custom tag container
     */
    @NotNull
    @Override
    PersistentDataContainer getPersistentDataContainer();

    // Paper start
    /**
     * Checks if this TileState is a snapshot or a live
     * representation of the underlying tile entity.
     * <p>
     * NOTE: You may still have to call {@link BlockState#update()} on
     * live representations to update any visuals on the block.
     *
     * @return true if this is a snapshot
     * @see Block#getState(boolean)
     */
    boolean isSnapshot();
    // Paper end
}
