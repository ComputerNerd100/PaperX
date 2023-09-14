package io.papermc.paper.api.block.tilestate;

import io.papermc.paper.api.namespace.NamespacedKey;
import io.papermc.paper.api.player.OfflinePlayer;
import io.papermc.paper.api.profile.PlayerProfile;
import io.papermc.paper.api.sound.Instrument;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;


/**
 * Represents a captured state of a skull block.
 */
public interface Skull extends TileState {

    /**
     * Checks to see if the skull has an owner
     *
     * @return true if the skull has an owner
     */
    public boolean hasOwner();


    /**
     * Get the player which owns the skull. This player may appear as the
     * texture depending on skull type.
     *
     * @return owning player
     */
    @Nullable
    public OfflinePlayer getOwningPlayer();

    /**
     * Set the player which owns the skull. This player may appear as the
     * texture depending on skull type.
     *
     * @param player the owning player
     */
    public void setOwningPlayer(@NonNull OfflinePlayer player);

    /**
     * Sets this skull to use the supplied Player Profile, which can include textures already prefilled.
     * @param profile The profile to set this Skull to use, may not be null
     */
    void setPlayerProfile(@NonNull PlayerProfile profile);

    /**
     * If the skull has an owner, per {@link #hasOwner()}, return the owners {@link PlayerProfile}
     * @return The profile of the owner, if set
     */
    @Nullable PlayerProfile getPlayerProfile();

    /**
     * Gets the sound to play if the skull is placed on a note block.
     * <br>
     * <strong>Note:</strong> This only works for player heads. For other heads,
     * see {@link Instrument}.
     *
     * @return the key of the sound, or null
     */
    @Nullable
    NamespacedKey getNoteBlockSound();

    /**
     * Sets the sound to play if the skull is placed on a note block.
     * <br>
     * <strong>Note:</strong> This only works for player heads. For other heads,
     * see {@link Instrument}.
     *
     * @param noteBlockSound the key of the sound to be played, or null
     *
     */
    void setNoteBlockSound(@Nullable NamespacedKey noteBlockSound);

}

