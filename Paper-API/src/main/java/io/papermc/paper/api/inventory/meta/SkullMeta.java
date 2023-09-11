package io.papermc.paper.api.inventory.meta;

import io.papermc.paper.api.namespace.NamespacedKey;
import io.papermc.paper.api.player.OfflinePlayer;
import io.papermc.paper.api.profile.PlayerProfile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a skull that can have an owner.
 */
public interface SkullMeta extends ItemMeta {

    /**
     * Checks to see if the skull has an owner.
     *
     * @return true if the skull has an owner
     */
    boolean hasOwner();

    // Paper start
    /**
     * Sets this skull to use the supplied Player Profile, which can include textures already prefilled.
     * @param profile The profile to set this Skull to use, or null to clear owner
     */
    void setPlayerProfile(@Nullable PlayerProfile profile);

    /**
     * If the skull has an owner, per {@link #hasOwner()}, return the owners {@link PlayerProfile}
     * @return The profile of the owner, if set
     */
    @Nullable PlayerProfile getPlayerProfile();
    // Paper end

    /**
     * Gets the owner of the skull.
     *
     * @return the owner if the skull
     */
    @Nullable
    OfflinePlayer getOwningPlayer();

    /**
     * Sets the owner of the skull.
     * <p>
     * Plugins should check that hasOwner() returns true before calling this
     * plugin.
     *
     * @param owner the new owner of the skull
     * @return true if the owner was successfully set
     */
    boolean setOwningPlayer(@Nullable OfflinePlayer owner);

    /**
     * Sets the sound to play if the skull is placed on a note block.
     * <br>
     * <strong>Note:</strong> This only works for player heads. For other heads,
     * see {@link org.bukkit.Instrument}.
     *
     * @param noteBlockSound the key of the sound to be played, or null
     */
    void setNoteBlockSound(@Nullable NamespacedKey noteBlockSound);

    /**
     * Gets the sound to play if the skull is placed on a note block.
     * <br>
     * <strong>Note:</strong> This only works for player heads. For other heads,
     * see {@link org.bukkit.Instrument}.
     *
     * @return the key of the sound, or null
     */
    @Nullable
    NamespacedKey getNoteBlockSound();

    @Override
    @NotNull
    SkullMeta clone();
}

