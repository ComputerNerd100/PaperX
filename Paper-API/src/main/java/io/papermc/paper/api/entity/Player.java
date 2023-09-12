package io.papermc.paper.api.entity;

import io.papermc.paper.api.ClientOption;
import io.papermc.paper.api.advancement.Advancement;
import io.papermc.paper.api.advancement.AdvancementProgress;
import io.papermc.paper.api.ban.BanEntry;
import io.papermc.paper.api.ban.BanList;
import io.papermc.paper.api.ban.IpBanList;
import io.papermc.paper.api.ban.ProfileBanList;
import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.block.BlockState;
import io.papermc.paper.api.block.data.BlockData;
import io.papermc.paper.api.block.sign.Side;
import io.papermc.paper.api.block.tilestate.Sign;
import io.papermc.paper.api.block.tilestate.TileState;
import io.papermc.paper.api.inventory.EquipmentSlot;
import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.location.Location;
import io.papermc.paper.api.material.Material;
import io.papermc.paper.api.math.Position;
import io.papermc.paper.api.network.NetworkClient;
import io.papermc.paper.api.particle.Particle;
import io.papermc.paper.api.player.OfflinePlayer;
import io.papermc.paper.api.profile.PlayerProfile;
import io.papermc.paper.api.sound.Instrument;
import io.papermc.paper.api.sound.Note;
import io.papermc.paper.api.sound.Sound;
import io.papermc.paper.api.sound.SoundCategory;
import net.kyori.adventure.identity.Identified;
import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.HoverEvent;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.UnmodifiableView;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.time.Duration;
import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;

/**
 * Represents a player, connected or not
 */
public interface Player extends HumanEntity, Conversable, OfflinePlayer, PluginMessageRecipient, Identified, net.kyori.adventure.bossbar.BossBarViewer, NetworkClient {

    @Override
    default @NonNull Identity identity() {
        return Identity.identity(this.getUniqueId());
    }

    /**
     * Gets an unmodifiable view of all known currently active bossbars.
     * <p>
     * <b>This currently only returns bossbars shown to the player via
     * {@link #showBossBar(net.kyori.adventure.bossbar.BossBar)} and does not contain bukkit
     * {@link io.papermc.paper.api.boss.BossBar} instances shown to the player.</b>
     *
     * @return an unmodifiable view of all known currently active bossbars
     * @since 4.14.0
     */
    @Override
    @UnmodifiableView @NonNull Iterable<? extends net.kyori.adventure.bossbar.BossBar> activeBossBars();

    /**
     * Gets the "friendly" name to display of this player.
     *
     * @return the display name
     */
    @NonNull Component displayName();

    /**
     * Sets the "friendly" name to display of this player.
     *
     * @param displayName the display name to set
     */
    void displayName(final @Nullable Component displayName);

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    String getName();

    /**
     * Sets the name that is shown on the in-game player list.
     * <p>
     * If the value is null, the name will be identical to {@link #getName()}.
     *
     * @param name new player list name
     */
    void playerListName(@Nullable Component name);

    /**
     * Gets the name that is shown on the in-game player list.
     *
     * @return the player list name
     */
    @NonNull Component playerListName();

    /**
     * Gets the currently displayed player list header for this player.
     *
     * @return player list header or null
     */
    @Nullable Component playerListHeader();

    /**
     * Gets the currently displayed player list footer for this player.
     *
     * @return player list footer or null
     */
    @Nullable Component playerListFooter();

    /**
     * Set the target of the player's compass.
     *
     * @param loc Location to point to
     */
    void setCompassTarget(@NonNull Location loc);

    /**
     * Get the previously set compass target.
     *
     * @return location of the target
     */
    @NonNull Location getCompassTarget();

    /**
     * Gets the socket address of this player
     *
     * @return the player's address
     */
    @Nullable InetSocketAddress getAddress();

    /**
     * Sends this sender a message raw
     *
     * @param message Message to be displayed
     */
    @Override
    void sendRawMessage(@NonNull String message);


    /**
     * Kicks the player with the default kick message.
     * @see #kick(Component)
     */
    void kick();
    /**
     * Kicks player with custom kick message.
     *
     * @param message kick message
     */
    void kick(final @Nullable Component message);

    /**
     * Kicks player with custom kick message and cause.
     *
     * @param message kick message
     * @param cause kick cause
     */
    void kick(final @Nullable Component message, PlayerKickEvent.@NonNull Cause cause);

    /**
     * Adds this user to the {@link ProfileBanList}. If a previous ban exists, this will
     * update the entry.
     *
     * @param reason reason for the ban, null indicates implementation default
     * @param expires date for the ban's expiration (unban), or null to imply
     *     forever
     * @param source source of the ban, null indicates implementation default
     * @param kickPlayer if the player need to be kick
     *
     * @return the entry for the newly created ban, or the entry for the
     *     (updated) previous ban
     */
    @Nullable <E extends BanEntry<? super PlayerProfile>> E ban(@Nullable String reason, @Nullable Date expires, @Nullable String source, boolean kickPlayer);

    /**
     * Adds this user to the {@link ProfileBanList}. If a previous ban exists, this will
     * update the entry.
     *
     * @param reason reason for the ban, null indicates implementation default
     * @param expires date for the ban's expiration (unban), or null to imply
     *     forever
     * @param source source of the ban, null indicates implementation default
     * @param kickPlayer if the player need to be kick
     *
     * @return the entry for the newly created ban, or the entry for the
     *     (updated) previous ban
     */
    @Nullable <E extends BanEntry<? super PlayerProfile>> E ban(@Nullable String reason, @Nullable Instant expires, @Nullable String source, boolean kickPlayer); // Paper - fix ban list API

    /**
     * Adds this user to the {@link ProfileBanList}. If a previous ban exists, this will
     * update the entry.
     *
     * @param reason reason for the ban, null indicates implementation default
     * @param duration the duration how long the ban lasts, or null to imply
     *     forever
     * @param source source of the ban, null indicates implementation default
     * @param kickPlayer if the player need to be kick
     *
     * @return the entry for the newly created ban, or the entry for the
     *     (updated) previous ban
     */
    @Nullable <E extends BanEntry<? super PlayerProfile>> E ban(@Nullable String reason, @Nullable Duration duration, @Nullable String source, boolean kickPlayer); // Paper - fix ban list API

    /**
     * Adds this user's current IP address to the {@link IpBanList}. If a previous ban exists, this will
     * update the entry. If {@link #getAddress()} is null this method will throw an exception.
     *
     * @param reason reason for the ban, null indicates implementation default
     * @param expires date for the ban's expiration (unban), or null to imply
     *     forever
     * @param source source of the ban, null indicates implementation default
     * @param kickPlayer if the player need to be kick
     *
     * @return the entry for the newly created ban, or the entry for the
     *     (updated) previous ban
     */
    @Nullable BanEntry<InetAddress> banIp(@Nullable String reason, @Nullable Date expires, @Nullable String source, boolean kickPlayer);

    /**
     * Adds this user's current IP address to the {@link IpBanList}. If a previous ban exists, this will
     * update the entry. If {@link #getAddress()} is null this method will throw an exception.
     *
     * @param reason reason for the ban, null indicates implementation default
     * @param expires date for the ban's expiration (unban), or null to imply
     *     forever
     * @param source source of the ban, null indicates implementation default
     * @param kickPlayer if the player need to be kick
     *
     * @return the entry for the newly created ban, or the entry for the
     *     (updated) previous ban
     */
    @Nullable BanEntry<InetAddress> banIp(@Nullable String reason, @Nullable Instant expires, @Nullable String source, boolean kickPlayer);

    /**
     * Adds this user's current IP address to the {@link IpBanList}. If a previous ban exists, this will
     * update the entry. If {@link #getAddress()} is null this method will throw an exception.
     *
     * @param reason reason for the ban, null indicates implementation default
     * @param duration the duration how long the ban lasts, or null to imply
     *     forever
     * @param source source of the ban, null indicates implementation default
     * @param kickPlayer if the player need to be kick
     *
     * @return the entry for the newly created ban, or the entry for the
     *     (updated) previous ban
     */
    @Nullable BanEntry<InetAddress> banIp(@Nullable String reason, @Nullable Duration duration, @Nullable String source, boolean kickPlayer);

    /**
     * Says a message (or runs a command).
     *
     * @param msg message to print
     */
    void chat(@NonNull String msg);

    /**
     * Makes the player perform the given command
     *
     * @param command Command to perform
     * @return true if the command was successful, otherwise false
     */
    boolean performCommand(@NonNull String command);

    /**
     * Returns true if the entity is supported by a block.
     *
     * This value is a state updated by the client after each movement.
     *
     * @return True if entity is on ground.
     * @deprecated This value is controlled only by the client and is therefore
     * unreliable and vulnerable to spoofing and/or desync depending on the
     * context/time which it is accessed
     */
    @Override
    @Deprecated
    boolean isOnGround();

    /**
     * Returns if the player is in sneak mode
     *
     * @return true if player is in sneak mode
     */
    @Override
    boolean isSneaking();

    /**
     * Sets the sneak mode the player
     *
     * @param sneak true if player should appear sneaking
     */
    @Override
    void setSneaking(boolean sneak);

    /**
     * Gets whether the player is sprinting or not.
     *
     * @return true if player is sprinting.
     */
    boolean isSprinting();

    /**
     * Sets whether the player is sprinting or not.
     *
     * @param sprinting true if the player should be sprinting
     */
    void setSprinting(boolean sprinting);

    /**
     * Saves the players current location, health, inventory, motion, and
     * other information into the &lt;uuid&gt;.dat file, in the
     * &lt;level-name&gt;/playerdata/ folder.
     */
    void saveData();

    /**
     * Loads the players current location, health, inventory, motion, and
     * other information from the &lt;uuid&gt;.dat file, in the
     * &lt;level-name&gt;/playerdata/ folder.
     * <p>
     * Note: This will overwrite the players current inventory, health,
     * motion, etc, with the state from the saved dat file.
     */
    void loadData();

    /**
     * Sets whether the player is ignored as not sleeping. If everyone is
     * either sleeping or has this flag set, then time will advance to the
     * next day. If everyone has this flag set but no one is actually in bed,
     * then nothing will happen.
     *
     * @param isSleeping Whether to ignore.
     */
    void setSleepingIgnored(boolean isSleeping);

    /**
     * Returns whether the player is sleeping ignored.
     *
     * @return Whether player is ignoring sleep.
     */
    boolean isSleepingIgnored();

    /**
     * Gets the Location where the player will spawn at their bed, null if
     * they have not slept in one or their current bed spawn is invalid.
     *
     * @return Bed Spawn Location if bed exists, otherwise null.
     */
    @Nullable
    @Override
    Location getBedSpawnLocation();

    /**
     * Sets the Location where the player will spawn at their bed.
     *
     * @param location where to set the respawn location
     */
    void setBedSpawnLocation(@Nullable Location location);

    /**
     * Sets the Location where the player will spawn at their bed.
     *
     * @param location where to set the respawn location
     * @param force whether to forcefully set the respawn location even if a
     *     valid bed is not present
     */
    void setBedSpawnLocation(@Nullable Location location, boolean force);

    /**
     * Play a note for a player at a location. This requires a note block
     * at the particular location (as far as the client is concerned). This
     * will not work without a note block. This will not work with cake.
     *
     * @param loc The location of a note block.
     * @param instrument The instrument ID.
     * @param note The note ID.
     * @deprecated Magic value
     */
    @Deprecated
    void playNote(@NonNull Location loc, byte instrument, byte note);

    /**
     * Play a note for a player at a location.
     *
     * @param loc The location of a note block
     * @param instrument The instrument
     * @param note The note
     */
    void playNote(@NonNull Location loc, @NonNull Instrument instrument, @NonNull Note note);


    /**
     * Play a sound for a player at the location.
     * <p>
     * This function will fail silently if Location or Sound are null.
     *
     * @param location The location to play the sound
     * @param sound The sound to play
     * @param volume The volume of the sound
     * @param pitch The pitch of the sound
     */
    void playSound(@NonNull Location location, @NonNull Sound sound, float volume, float pitch);

    /**
     * Play a sound for a player at the location.
     * <p>
     * This function will fail silently if Location or Sound are null. No
     * sound will be heard by the player if their client does not have the
     * respective sound for the value passed.
     *
     * @param location The location to play the sound
     * @param sound The internal sound name to play
     * @param volume The volume of the sound
     * @param pitch The pitch of the sound
     */
    void playSound(@NonNull Location location, @NonNull String sound, float volume, float pitch);

    /**
     * Play a sound for a player at the location.
     * <p>
     * This function will fail silently if Location or Sound are null.
     *
     * @param location The location to play the sound
     * @param sound The sound to play
     * @param category The category of the sound
     * @param volume The volume of the sound
     * @param pitch The pitch of the sound
     */
    void playSound(@NonNull Location location, @NonNull Sound sound, @NonNull SoundCategory category, float volume, float pitch);

    /**
     * Play a sound for a player at the location.
     * <p>
     * This function will fail silently if Location or Sound are null. No sound
     * will be heard by the player if their client does not have the respective
     * sound for the value passed.
     *
     * @param location The location to play the sound
     * @param sound The internal sound name to play
     * @param category The category of the sound
     * @param volume The volume of the sound
     * @param pitch The pitch of the sound
     */
    void playSound(@NonNull Location location, @NonNull String sound, @NonNull SoundCategory category, float volume, float pitch);

    /**
     * Play a sound for a player at the location of the entity.
     * <p>
     * This function will fail silently if Entity or Sound are null.
     *
     * @param entity The entity to play the sound
     * @param sound The sound to play
     * @param volume The volume of the sound
     * @param pitch The pitch of the sound
     */
    void playSound(@NonNull Entity entity, @NonNull Sound sound, float volume, float pitch);

    /**
     * Play a sound for a player at the location of the entity.
     * <p>
     * This function will fail silently if Entity or Sound are null.
     *
     * @param entity The entity to play the sound
     * @param sound The sound to play
     * @param volume The volume of the sound
     * @param pitch The pitch of the sound
     */
    void playSound(@NonNull Entity entity, @NonNull String sound, float volume, float pitch);

    /**
     * Play a sound for a player at the location of the entity.
     * <p>
     * This function will fail silently if Entity or Sound are null.
     *
     * @param entity The entity to play the sound
     * @param sound The sound to play
     * @param category The category of the sound
     * @param volume The volume of the sound
     * @param pitch The pitch of the sound
     */
    void playSound(@NonNull Entity entity, @NonNull Sound sound, @NonNull SoundCategory category, float volume, float pitch);

    /**
     * Play a sound for a player at the location of the entity.
     * <p>
     * This function will fail silently if Entity or Sound are null.
     *
     * @param entity The entity to play the sound
     * @param sound The sound to play
     * @param category The category of the sound
     * @param volume The volume of the sound
     * @param pitch The pitch of the sound
     */
    void playSound(@NonNull Entity entity, @NonNull String sound, @NonNull SoundCategory category, float volume, float pitch);

    /**
     * Stop the specified sound from playing.
     *
     * @param sound the sound to stop
     */
    void stopSound(@NonNull Sound sound);

    /**
     * Stop the specified sound from playing.
     *
     * @param sound the sound to stop
     */
    void stopSound(@NonNull String sound);

    /**
     * Stop the specified sound from playing.
     *
     * @param sound the sound to stop
     * @param category the category of the sound
     */
    void stopSound(@NonNull Sound sound, @Nullable SoundCategory category);

    /**
     * Stop the specified sound from playing.
     *
     * @param sound the sound to stop
     * @param category the category of the sound
     */
    void stopSound(@NonNull String sound, @Nullable SoundCategory category);

    /**
     * Stop the specified sound category from playing.
     *
     * @param category the sound category to stop
     */
    void stopSound(@NonNull SoundCategory category);

    /**
     * Stop all sounds from playing.
     */
    void stopAllSounds();

    /**
     * Plays an effect to just this player.
     *
     * @param loc the location to play the effect at
     * @param effect the {@link Effect}
     * @param data a data bit needed for some effects
     * @deprecated Magic value
     */
    @Deprecated
    void playEffect(@NonNull Location loc, @NonNull Effect effect, int data);

    /**
     * Plays an effect to just this player.
     *
     * @param <T> the data based on the type of the effect
     * @param loc the location to play the effect at
     * @param effect the {@link Effect}
     * @param data a data bit needed for some effects
     */
    <T> void playEffect(@NonNull Location loc, @NonNull Effect effect, @Nullable T data);

    /**
     * Force this player to break a Block using the item in their main hand.
     *
     * This method will respect enchantments, handle item durability (if
     * applicable) and drop experience and the correct items according to the
     * tool/item in the player's hand.
     * <p>
     * Note that this method will call a {@link BlockBreakEvent}, meaning that
     * this method may not be successful in breaking the block if the event was
     * cancelled by a third party plugin. Care should be taken if running this
     * method in a BlockBreakEvent listener as recursion may be possible if it
     * is invoked on the same {@link Block} being broken in the event.
     * <p>
     * Additionally, a {@link BlockDropItemEvent} is called for the items
     * dropped by this method (if successful).
     * <p>
     * The block must be in the same world as the player.
     *
     * @param block the block to break
     *
     * @return true if the block was broken, false if the break failed
     */
    boolean breakBlock(@NonNull Block block);

    /**
     * Send a block change. This fakes a block change packet for a user at a
     * certain location. This will not actually change the world in any way.
     *
     * @param loc The location of the changed block
     * @param material The new block
     * @param data The block data
     * @deprecated Magic value
     */
    @Deprecated
    void sendBlockChange(@NonNull Location loc, @NonNull Material material, byte data);

    /**
     * Send a block change. This fakes a block change packet for a user at a
     * certain location. This will not actually change the world in any way.
     *
     * @param loc The location of the changed block
     * @param block The new block
     */
    void sendBlockChange(@NonNull Location loc, @NonNull BlockData block);

    /**
     * Send a multi-block change. This fakes a block change packet for a user
     * at multiple locations. This will not actually change the world in any
     * way.
     * <p>
     * This method may send multiple packets to the client depending on the
     * blocks in the collection. A packet must be sent for each chunk section
     * modified, meaning one packet for each 16x16x16 block area. Even if only
     * one block is changed in two different chunk sections, two packets will
     * be sent.
     * <p>
     * Additionally, this method cannot guarantee the functionality of changes
     * being sent to the player in chunks not loaded by the client. It is the
     * responsibility of the caller to ensure that the client is within range
     * of the changed blocks or to handle any side effects caused as a result.
     *
     * @param blocks the block states to send to the player
     */
    void sendBlockChanges(@NonNull Collection<BlockState> blocks);

    /**
     * Send a multi-block change. This fakes a block change packet for a user
     * at multiple locations. This will not actually change the world in any
     * way.
     * <p>
     * This method may send multiple packets to the client depending on the
     * blocks in the collection. A packet must be sent for each chunk section
     * modified, meaning one packet for each 16x16x16 block area. Even if only
     * one block is changed in two different chunk sections, two packets will
     * be sent.
     * <p>
     * Additionally, this method cannot guarantee the functionality of changes
     * being sent to the player in chunks not loaded by the client. It is the
     * responsibility of the caller to ensure that the client is within range
     * of the changed blocks or to handle any side effects caused as a result.
     *
     * @param blocks the block states to send to the player
     * @param suppressLightUpdates whether or not light updates should be
     * suppressed when updating the blocks on the client
     * @deprecated suppressLightUpdates is not functional in versions greater
     * than 1.19.4
     */
    @Deprecated
    void sendBlockChanges(@NonNull Collection<BlockState> blocks, boolean suppressLightUpdates);

    /**
     * Send block damage. This fakes block break progress at a certain location
     * sourced by this player. This will not actually change the block's break
     * progress in any way.
     *
     * @param loc the location of the damaged block
     * @param progress the progress from 0.0 - 1.0 where 0 is no damage and
     * 1.0 is the most damaged
     */
    void sendBlockDamage(@NonNull Location loc, float progress);

    // Paper start
    /**
     * Send multiple block changes. This fakes a multi block change packet for each
     * chunk section that a block change occurs. This will not actually change the world in any way.
     *
     * @param blockChanges A map of the positions you want to change to their new block data
     */
    void sendMultiBlockChange(@NonNull Map<? extends Position, BlockData> blockChanges);

    /**
     * Send multiple block changes. This fakes a multi block change packet for each
     * chunk section that a block change occurs. This will not actually change the world in any way.
     *
     * @param blockChanges A map of the positions you want to change to their new block data
     * @param suppressLightUpdates Whether to suppress light updates or not
     * @deprecated suppressLightUpdates is no longer available in 1.20+, use {@link #sendMultiBlockChange(Map)}
     */
    @Deprecated
    default void sendMultiBlockChange(@NonNull Map<? extends Position, BlockData> blockChanges, boolean suppressLightUpdates) {
        this.sendMultiBlockChange(blockChanges);
    }
    // Paper end

    /**
     * Send block damage. This fakes block break progress at a certain location
     * sourced by the provided entity. This will not actually change the block's
     * break progress in any way.
     * <p>
     * At the same location for each unique damage source sent to the player, a
     * separate damage overlay will be displayed with the given progress. This allows
     * for block damage at different progress from multiple entities at once.
     *
     * @param loc the location of the damaged block
     * @param progress the progress from 0.0 - 1.0 where 0 is no damage and
     * 1.0 is the most damaged
     * @param source the entity to which the damage belongs
     */
    void sendBlockDamage(@NonNull Location loc, float progress, @NonNull Entity source);

    /**
     * Send block damage. This fakes block break progress at a certain location
     * sourced by the provided entity id. This will not actually change the block's
     * break progress in any way.
     * <p>
     * At the same location for each unique damage source sent to the player, a
     * separate damage overlay will be displayed with the given progress. This allows
     * for block damage at different progress from multiple entities at once.
     *
     * @param loc the location of the damaged block
     * @param progress the progress from 0.0 - 1.0 where 0 is no damage and
     * 1.0 is the most damaged
     * @param sourceId the entity id of the entity to which the damage belongs.
     * Can be an id that does not associate directly with an existing or loaded entity.
     */
    void sendBlockDamage(@NonNull Location loc, float progress, int sourceId);

    /**
     * Send an equipment change for the target entity. This will not
     * actually change the entity's equipment in any way.
     *
     * @param entity the entity whose equipment to change
     * @param slot the slot to change
     * @param item the item to which the slot should be changed, or null to set
     * it to air
     */
    void sendEquipmentChange(@NonNull LivingEntity entity, @NonNull EquipmentSlot slot, @Nullable ItemStack item);

    /**
     * Send multiple equipment changes for the target entity. This will not
     * actually change the entity's equipment in any way.
     *
     * @param entity the entity whose equipment to change
     * @param items the slots to change, where the values are the items to which
     * the slot should be changed. null values will set the slot to air
     */
    void sendEquipmentChange(@NonNull LivingEntity entity, @NonNull Map<EquipmentSlot, ItemStack> items);

    @ApiStatus.Experimental
    void sendBlockUpdate(@NonNull Location loc, @NonNull TileState tileState) throws IllegalArgumentException;

    /**
     * Render a map and send it to the player in its entirety. This may be
     * used when streaming the map in the normal manner is not desirable.
     *
     * @param map The map to be sent
     */
    void sendMap(@NonNull MapView map);

    /**
     * Shows the player the win screen that normally is only displayed after one kills the ender dragon
     * and exits the end for the first time.
     * In vanilla, the win screen starts with a poem and then continues with the credits but its content can be
     * changed by using a resource pack.
     * <br>
     * Calling this method does not change the value of {@link #hasSeenWinScreen()}.
     * That means that the win screen is still displayed to a player if they leave the end for the first time, even though
     * they have seen it before because this method was called.
     * Note this method does not make the player invulnerable, which is normally expected when viewing credits.
     *
     * @see #hasSeenWinScreen()
     * @see #setHasSeenWinScreen(boolean)
     * @see <a href="https://minecraft.fandom.com/wiki/End_Poem#Technical_details">https://minecraft.fandom.com/wiki/End_Poem#Technical_details</a>
     */
    void showWinScreen();

    /**
     * Returns whether this player has seen the win screen before.
     * When a player leaves the end the win screen is shown to them if they have not seen it before.
     *
     * @return Whether this player has seen the win screen before
     * @see #setHasSeenWinScreen(boolean)
     * @see #showWinScreen()
     * @see <a href="https://minecraft.fandom.com/wiki/End_Poem">https://minecraft.fandom.com/wiki/End_Poem</a>
     */
    boolean hasSeenWinScreen();

    /**
     * Changes whether this player has seen the win screen before.
     * When a player leaves the end the win screen is shown to them if they have not seen it before.
     *
     * @param hasSeenWinScreen Whether this player has seen the win screen before
     * @see #hasSeenWinScreen()
     * @see #showWinScreen()
     * @see <a href="https://minecraft.fandom.com/wiki/End_Poem">https://minecraft.fandom.com/wiki/End_Poem</a>
     */
    void setHasSeenWinScreen(boolean hasSeenWinScreen);

    /**
     * Permanently Bans the Profile and IP address currently used by the player.
     *
     * @param reason Reason for ban
     * @return Ban Entry
     */
    // For reference, Bukkit defines this as nullable, while they impl isn't, we'll follow API.
    @Nullable
    default BanEntry banPlayerFull(@Nullable String reason) {
        return banPlayerFull(reason, null, null);
    }

    /**
     * Permanently Bans the Profile and IP address currently used by the player.
     *
     * @param reason Reason for ban
     * @param source Source of ban, or null for default
     * @return Ban Entry
     */
    @Nullable
    default BanEntry banPlayerFull(@Nullable String reason, @Nullable String source) {
        return banPlayerFull(reason, null, source);
    }

    /**
     * Bans the Profile and IP address currently used by the player.
     *
     * @param reason Reason for Ban
     * @param expires When to expire the ban
     * @return Ban Entry
     */
    @Nullable
    default BanEntry banPlayerFull(@Nullable String reason, @Nullable java.util.Date expires) {
        return banPlayerFull(reason, expires, null);
    }

    /**
     * Bans the Profile and IP address currently used by the player.
     *
     * @param reason Reason for Ban
     * @param expires When to expire the ban
     * @param source Source of the ban, or null for default
     * @return Ban Entry
     */
    @Nullable
    default BanEntry banPlayerFull(@Nullable String reason, @Nullable java.util.Date expires, @Nullable String source) {
        banPlayer(reason, expires, source);
        return banPlayerIP(reason, expires, source, true);
    }

    /**
     * Permanently Bans the IP address currently used by the player.
     * Does not ban the Profile, use {@link #banPlayerFull(String, java.util.Date, String)}
     *
     * @param reason Reason for ban
     * @param kickPlayer Whether or not to kick the player afterwards
     * @return Ban Entry
     */
    @Nullable
    default BanEntry banPlayerIP(@Nullable String reason, boolean kickPlayer) {
        return banPlayerIP(reason, null, null, kickPlayer);
    }

    /**
     * Permanently Bans the IP address currently used by the player.
     * Does not ban the Profile, use {@link #banPlayerFull(String, java.util.Date, String)}
     * @param reason Reason for ban
     * @param source Source of ban, or null for default
     * @param kickPlayer Whether or not to kick the player afterwards
     * @return Ban Entry
     */
    @Nullable
    default BanEntry banPlayerIP(@Nullable String reason, @Nullable String source, boolean kickPlayer) {
        return banPlayerIP(reason, null, source, kickPlayer);
    }

    /**
     * Bans the IP address currently used by the player.
     * Does not ban the Profile, use {@link #banPlayerFull(String, java.util.Date, String)}
     * @param reason Reason for Ban
     * @param expires When to expire the ban
     * @param kickPlayer Whether or not to kick the player afterwards
     * @return Ban Entry
     */
    @Nullable
    default BanEntry banPlayerIP(@Nullable String reason, @Nullable java.util.Date expires, boolean kickPlayer) {
        return banPlayerIP(reason, expires, null, kickPlayer);
    }

    /**
     * Permanently Bans the IP address currently used by the player.
     * Does not ban the Profile, use {@link #banPlayerFull(String, java.util.Date, String)}
     *
     * @param reason Reason for ban
     * @return Ban Entry
     */
    @Nullable
    default BanEntry banPlayerIP(@Nullable String reason) {
        return banPlayerIP(reason, null, null);
    }

    /**
     * Permanently Bans the IP address currently used by the player.
     * Does not ban the Profile, use {@link #banPlayerFull(String, java.util.Date, String)}
     * @param reason Reason for ban
     * @param source Source of ban, or null for default
     * @return Ban Entry
     */
    @Nullable
    default BanEntry banPlayerIP(@Nullable String reason, @Nullable String source) {
        return banPlayerIP(reason, null, source);
    }

    /**
     * Bans the IP address currently used by the player.
     * Does not ban the Profile, use {@link #banPlayerFull(String, java.util.Date, String)}
     * @param reason Reason for Ban
     * @param expires When to expire the ban
     * @return Ban Entry
     */
    @Nullable
    default BanEntry banPlayerIP(@Nullable String reason, @Nullable java.util.Date expires) {
        return banPlayerIP(reason, expires, null);
    }

    /**
     * Bans the IP address currently used by the player.
     * Does not ban the Profile, use {@link #banPlayerFull(String, java.util.Date, String)}
     * @param reason Reason for Ban
     * @param expires When to expire the ban
     * @param source Source of the ban or null for default
     * @return Ban Entry
     */
    @Nullable
    default BanEntry banPlayerIP(@Nullable String reason, @Nullable java.util.Date expires, @Nullable String source) {
        return banPlayerIP(reason, expires, source, true);
    }

    /**
     * Bans the IP address currently used by the player.
     * Does not ban the Profile, use {@link #banPlayerFull(String, java.util.Date, String)}
     * @param reason Reason for Ban
     * @param expires When to expire the ban
     * @param source Source of the ban or null for default
     * @param kickPlayer if the targeted player should be kicked
     * @return Ban Entry
     */
    @Nullable
    default BanEntry banPlayerIP(@Nullable String reason, @Nullable java.util.Date expires, @Nullable String source, boolean kickPlayer) {
        BanEntry banEntry = Paper.getServer().getBanList(BanList.Type.IP).addBan(getAddress().getAddress().getHostAddress(), reason, expires, source);
        if (kickPlayer && isOnline()) {
            getPlayer().kickPlayer(reason);
        }

        return banEntry;
    }

    /**
     * Send a hurt animation. This fakes incoming damage towards the player from
     * the given yaw relative to the player's direction.
     *
     * @param yaw the yaw in degrees relative to the player's direction where 0
     * is in front of the player, 90 is to the right, 180 is behind, and 270 is
     * to the left
     */
    void sendHurtAnimation(float yaw);

    /**
     * Add custom chat completion suggestions shown to the player while typing a
     * message.
     *
     * @param completions the completions to send
     */
    void addCustomChatCompletions(@NonNull Collection<String> completions);

    /**
     * Remove custom chat completion suggestions shown to the player while
     * typing a message.
     *
     * Online player names cannot be removed with this method. This will affect
     * only custom completions added by {@link #addCustomChatCompletions(Collection)}
     * or {@link #setCustomChatCompletions(Collection)}.
     *
     * @param completions the completions to remove
     */
    void removeCustomChatCompletions(@NonNull Collection<String> completions);

    /**
     * Set the list of chat completion suggestions shown to the player while
     * typing a message.
     * <p>
     * If completions were set previously, this method will remove them all and
     * replace them with the provided completions.
     *
     * @param completions the completions to set
     */
    void setCustomChatCompletions(@NonNull Collection<String> completions);

    /**
     * Forces an update of the player's entire inventory.
     *
     * @apiNote It should not be necessary for plugins to use this method. If it
     * is required for some reason, it is probably a bug.
     */
    @ApiStatus.Internal
    void updateInventory();

    /**
     * Gets this player's previous {@link GameMode}
     *
     * @return Previous game mode or null
     */
    @Nullable GameMode getPreviousGameMode();

    /**
     * Sets the current time on the player's client. When relative is true the
     * player's time will be kept synchronized to its world time with the
     * specified offset.
     * <p>
     * When using non relative time the player's time will stay fixed at the
     * specified time parameter. It's up to the caller to continue updating
     * the player's time. To restore player time to normal use
     * resetPlayerTime().
     *
     * @param time The current player's perceived time or the player's time
     *     offset from the server time.
     * @param relative When true the player time is kept relative to its world
     *     time.
     */
    void setPlayerTime(long time, boolean relative);

    /**
     * Returns the player's current timestamp.
     *
     * @return The player's time
     */
    long getPlayerTime();

    /**
     * Returns the player's current time offset relative to server time, or
     * the current player's fixed time if the player's time is absolute.
     *
     * @return The player's time
     */
    long getPlayerTimeOffset();

    /**
     * Returns true if the player's time is relative to the server time,
     * otherwise the player's time is absolute and will not change its current
     * time unless done so with setPlayerTime().
     *
     * @return true if the player's time is relative to the server time.
     */
    boolean isPlayerTimeRelative();

    /**
     * Restores the normal condition where the player's time is synchronized
     * with the server time.
     * <p>
     * Equivalent to calling setPlayerTime(0, true).
     */
    void resetPlayerTime();

    /**
     * Sets the type of weather the player will see.  When used, the weather
     * status of the player is locked until {@link #resetPlayerWeather()} is
     * used.
     *
     * @param type The WeatherType enum type the player should experience
     */
    void setPlayerWeather(@NonNull WeatherType type);

    /**
     * Returns the type of weather the player is currently experiencing.
     *
     * @return The WeatherType that the player is currently experiencing or
     *     null if player is seeing server weather.
     */
    @Nullable WeatherType getPlayerWeather();

    /**
     * Restores the normal condition where the player's weather is controlled
     * by server conditions.
     */
    void resetPlayerWeather();

    // Paper start
    /**
     * Gives the player the amount of experience specified.
     *
     * @param amount Exp amount to give
     */
    default void giveExp(int amount) {
        giveExp(amount, false);
    }
    /**
     * Gets the player's cooldown between picking up experience orbs.
     *
     * @return The cooldown in ticks
     */
    int getExpCooldown();

    /**
     * Sets the player's cooldown between picking up experience orbs..
     *
     * <strong>Note:</strong> Setting this to 0 allows the player to pick up
     * instantly, but setting this to a negative value will cause the player to
     * be unable to pick up xp-orbs.
     *
     * Calling this Method will result in {@link PlayerExpCooldownChangeEvent}
     * being called.
     *
     * @param ticks The cooldown in ticks
     */
    void setExpCooldown(int ticks);

    /**
     * Gives the player the amount of experience specified.
     *
     * @param amount Exp amount to give
     * @param applyMending Mend players items with mending, with same behavior as picking up orbs. calls {@link #applyMending(int)}
     */
    void giveExp(int amount, boolean applyMending);

    /**
     * Applies the mending effect to any items just as picking up an orb would.
     *
     * Can also be called with {@link #giveExp(int, boolean)} by passing true to applyMending
     *
     * @param amount Exp to apply
     * @return the remaining experience
     */
    int applyMending(int amount);
    // Paper end

    /**
     * Gives the player the amount of experience levels specified. Levels can
     * be taken by specifying a negative amount.
     *
     * @param amount amount of experience levels to give or take
     */
    void giveExpLevels(int amount);

    /**
     * Gets the players current experience points towards the next level.
     * <p>
     * This is a percentage value. 0 is "no progress" and 1 is "next level".
     *
     * @return Current experience points
     */
    float getExp();

    /**
     * Sets the players current experience points towards the next level
     * <p>
     * This is a percentage value. 0 is "no progress" and 1 is "next level".
     *
     * @param exp New experience points
     */
    void setExp(float exp);

    /**
     * Gets the players current experience level
     *
     * @return Current experience level
     */
    int getLevel();

    /**
     * Sets the players current experience level
     *
     * @param level New experience level
     */
    void setLevel(int level);

    /**
     * Gets the players total experience points.
     * <br>
     * This refers to the total amount of experience the player has collected
     * over time and is not currently displayed to the client.
     *
     * @return Current total experience points
     */
    int getTotalExperience();

    /**
     * Sets the players current experience points.
     * <br>
     * This refers to the total amount of experience the player has collected
     * over time and is not currently displayed to the client.
     *
     * @param exp New total experience points
     */
    void setTotalExperience(int exp);

    /**
     * Send an experience change.
     *
     * This fakes an experience change packet for a user. This will not actually
     * change the experience points in any way.
     *
     * @param progress Experience progress percentage (between 0.0 and 1.0)
     * @see #setExp(float)
     */
    void sendExperienceChange(float progress);

    /**
     * Send an experience change.
     *
     * This fakes an experience change packet for a user. This will not actually
     * change the experience points in any way.
     *
     * @param progress New experience progress percentage (between 0.0 and 1.0)
     * @param level New experience level
     *
     * @see #setExp(float)
     * @see #setLevel(int)
     */
    void sendExperienceChange(float progress, int level);

    /**
     * Determines if the Player is allowed to fly via jump key double-tap like
     * in creative mode.
     *
     * @return True if the player is allowed to fly.
     */
    boolean getAllowFlight();

    /**
     * Sets if the Player is allowed to fly via jump key double-tap like in
     * creative mode.
     *
     * @param flight If flight should be allowed.
     */
    void setAllowFlight(boolean flight);

    // Paper start - flying fall damage
    /**
     * Allows you to enable fall damage while {@link #getAllowFlight()} is {@code true}
     *
     * @param flyingFallDamage Enables fall damage when {@link #getAllowFlight()} is {@code true}
     */
    void setFlyingFallDamage(@NonNull net.kyori.adventure.util.TriState flyingFallDamage);

    /**
     * Allows you to get if fall damage is enabled while {@link #getAllowFlight()} is {@code true}
     *
     * @return A tristate of whether fall damage is enabled, not set, or disabled when {@link #getAllowFlight()} is {@code true}
     */
    @NonNull net.kyori.adventure.util.TriState hasFlyingFallDamage();
    // Paper end

    /**
     * Hides a player from this player
     *
     * @param player Player to hide
     * @deprecated see {@link #hidePlayer(Plugin, Player)}
     */
    @Deprecated
    void hidePlayer(@NonNull Player player);

    /**
     * Hides a player from this player
     *
     * @param plugin Plugin that wants to hide the player
     * @param player Player to hide
     */
    void hidePlayer(@NonNull Plugin plugin, @NonNull Player player);

    /**
     * Allows this player to see a player that was previously hidden
     *
     * @param player Player to show
     * @deprecated see {@link #showPlayer(Plugin, Player)}
     */
    @Deprecated
    void showPlayer(@NonNull Player player);

    /**
     * Allows this player to see a player that was previously hidden. If
     * another plugin had hidden the player too, then the player will
     * remain hidden until the other plugin calls this method too.
     *
     * @param plugin Plugin that wants to show the player
     * @param player Player to show
     */
    void showPlayer(@NonNull Plugin plugin, @NonNull Player player);

    /**
     * Checks to see if a player has been hidden from this player
     *
     * @param player Player to check
     * @return True if the provided player is not being hidden from this
     *     player
     */
    boolean canSee(@NonNull Player player);

    /**
     * Visually hides an entity from this player.
     *
     * @param plugin Plugin that wants to hide the entity
     * @param entity Entity to hide
     * @apiNote draft API
     */
    @ApiStatus.Experimental
    void hideEntity(@NonNull Plugin plugin, @NonNull Entity entity);

    /**
     * Allows this player to see an entity that was previously hidden. If
     * another plugin had hidden the entity too, then the entity will
     * remain hidden until the other plugin calls this method too.
     *
     * @param plugin Plugin that wants to show the entity
     * @param entity Entity to show
     * @apiNote draft API
     */
    @ApiStatus.Experimental
    void showEntity(@NonNull Plugin plugin, @NonNull Entity entity);

    /**
     * Checks to see if an entity has been visually hidden from this player.
     *
     * @param entity Entity to check
     * @return True if the provided entity is not being hidden from this
     *     player
     * @apiNote draft API
     */
    @ApiStatus.Experimental
    boolean canSee(@NonNull Entity entity);

    // Paper start
    /**
     * Returns whether the {@code other} player is listed for {@code this}.
     *
     * @param other The other {@link Player} to check for listing.
     * @return True if the {@code other} player is listed for {@code this}.
     */
    boolean isListed(@NonNull Player other);

    /**
     * Unlists the {@code other} player from the tablist.
     *
     * @param other The other {@link Player} to de-list.
     * @return True if the {@code other} player was listed.
     */
    boolean unlistPlayer(@NonNull Player other);

    /**
     * Lists the {@code other} player.
     *
     * @param other The other {@link Player} to list.
     * @return True if the {@code other} player was not listed.
     */
    boolean listPlayer(@NonNull Player other);
    // Paper end

    /**
     * Checks to see if this player is currently flying or not.
     *
     * @return True if the player is flying, else false.
     */
    boolean isFlying();

    /**
     * Makes this player start or stop flying.
     *
     * @param value True to fly.
     */
    void setFlying(boolean value);

    /**
     * Sets the speed at which a client will fly. Negative values indicate
     * reverse directions.
     *
     * @param value The new speed, from -1 to 1.
     * @throws IllegalArgumentException If new speed is less than -1 or
     *     greater than 1
     */
    void setFlySpeed(float value) throws IllegalArgumentException;

    /**
     * Sets the speed at which a client will walk. Negative values indicate
     * reverse directions.
     *
     * @param value The new speed, from -1 to 1.
     * @throws IllegalArgumentException If new speed is less than -1 or
     *     greater than 1
     */
    void setWalkSpeed(float value) throws IllegalArgumentException;

    /**
     * Gets the current allowed speed that a client can fly.
     *
     * @return The current allowed speed, from -1 to 1
     */
    float getFlySpeed();

    /**
     * Gets the current allowed speed that a client can walk.
     *
     * @return The current allowed speed, from -1 to 1
     */
    float getWalkSpeed();

    /**
     * Request that the player's client download and switch texture packs.
     * <p>
     * The player's client will download the new texture pack asynchronously
     * in the background, and will automatically switch to it once the
     * download is complete. If the client has downloaded and cached the same
     * texture pack in the past, it will perform a file size check against
     * the response content to determine if the texture pack has changed and
     * needs to be downloaded again. When this request is sent for the very
     * first time from a given server, the client will first display a
     * confirmation GUI to the player before proceeding with the download.
     * <p>
     * Notes:
     * <ul>
     * <li>Players can disable server textures on their client, in which
     *     case this method will have no affect on them. Use the
     *     {@link PlayerResourcePackStatusEvent} to figure out whether or not
     *     the player loaded the pack!
     * <li>There is no concept of resetting texture packs back to default
     *     within Minecraft, so players will have to relog to do so or you
     *     have to send an empty pack.
     * <li>The request is send with "null" as the hash. This might result
     *     in newer versions not loading the pack correctly.
     * </ul>
     *
     * @param url The URL from which the client will download the texture
     *     pack. The string must contain only US-ASCII characters and should
     *     be encoded as per RFC 1738.
     * @throws IllegalArgumentException Thrown if the URL is null.
     * @throws IllegalArgumentException Thrown if the URL is too long.
     * @deprecated Minecraft no longer uses textures packs. Instead you
     *     should use {@link #setResourcePack(String)}.
     */
    @Deprecated
    void setTexturePack(@NonNull String url);

    /**
     * Request that the player's client download and switch resource packs.
     * <p>
     * The player's client will download the new resource pack asynchronously
     * in the background, and will automatically switch to it once the
     * download is complete. If the client has downloaded and cached the same
     * resource pack in the past, it will perform a file size check against
     * the response content to determine if the resource pack has changed and
     * needs to be downloaded again. When this request is sent for the very
     * first time from a given server, the client will first display a
     * confirmation GUI to the player before proceeding with the download.
     * <p>
     * Notes:
     * <ul>
     * <li>Players can disable server resources on their client, in which
     *     case this method will have no affect on them. Use the
     *     {@link PlayerResourcePackStatusEvent} to figure out whether or not
     *     the player loaded the pack!
     * <li>There is no concept of resetting resource packs back to default
     *     within Minecraft, so players will have to relog to do so or you
     *     have to send an empty pack.
     * <li>The request is send with empty string as the hash. This might result
     *     in newer versions not loading the pack correctly.
     * </ul>
     *
     * @param url The URL from which the client will download the resource
     *     pack. The string must contain only US-ASCII characters and should
     *     be encoded as per RFC 1738.
     * @throws IllegalArgumentException Thrown if the URL is null.
     * @throws IllegalArgumentException Thrown if the URL is too long. The
     *     length restriction is an implementation specific arbitrary value.
     * @deprecated use {@link #setResourcePack(String, String)}
     */
    @Deprecated // Paper
    void setResourcePack(@NonNull String url);

    /**
     * Request that the player's client download and switch resource packs.
     * <p>
     * The player's client will download the new resource pack asynchronously
     * in the background, and will automatically switch to it once the
     * download is complete. If the client has downloaded and cached a
     * resource pack with the same hash in the past it will not download but
     * directly apply the cached pack. If the hash is null and the client has
     * downloaded and cached the same resource pack in the past, it will
     * perform a file size check against the response content to determine if
     * the resource pack has changed and needs to be downloaded again. When
     * this request is sent for the very first time from a given server, the
     * client will first display a confirmation GUI to the player before
     * proceeding with the download.
     * <p>
     * Notes:
     * <ul>
     * <li>Players can disable server resources on their client, in which
     *     case this method will have no affect on them. Use the
     *     {@link PlayerResourcePackStatusEvent} to figure out whether or not
     *     the player loaded the pack!
     * <li>There is no concept of resetting resource packs back to default
     *     within Minecraft, so players will have to relog to do so or you
     *     have to send an empty pack.
     * <li>The request is sent with empty string as the hash when the hash is
     *     not provided. This might result in newer versions not loading the
     *     pack correctly.
     * </ul>
     *
     * @deprecated in favour of {@link #setResourcePack(String, byte[], Component)}
     * @param url The URL from which the client will download the resource
     *     pack. The string must contain only US-ASCII characters and should
     *     be encoded as per RFC 1738.
     * @param hash The sha1 hash sum of the resource pack file which is used
     *     to apply a cached version of the pack directly without downloading
     *     if it is available. Hast to be 20 bytes long!
     * @throws IllegalArgumentException Thrown if the URL is null.
     * @throws IllegalArgumentException Thrown if the URL is too long. The
     *     length restriction is an implementation specific arbitrary value.
     * @throws IllegalArgumentException Thrown if the hash is not 20 bytes
     *     long.
     */
    void setResourcePack(@NonNull String url, @Nullable byte[] hash);

    /**
     * Request that the player's client download and switch resource packs.
     * <p>
     * The player's client will download the new resource pack asynchronously
     * in the background, and will automatically switch to it once the
     * download is complete. If the client has downloaded and cached a
     * resource pack with the same hash in the past it will not download but
     * directly apply the cached pack. If the hash is null and the client has
     * downloaded and cached the same resource pack in the past, it will
     * perform a file size check against the response content to determine if
     * the resource pack has changed and needs to be downloaded again. When
     * this request is sent for the very first time from a given server, the
     * client will first display a confirmation GUI to the player before
     * proceeding with the download.
     * <p>
     * Notes:
     * <ul>
     * <li>Players can disable server resources on their client, in which
     *     case this method will have no affect on them. Use the
     *     {@link PlayerResourcePackStatusEvent} to figure out whether or not
     *     the player loaded the pack!
     * <li>There is no concept of resetting resource packs back to default
     *     within Minecraft, so players will have to relog to do so or you
     *     have to send an empty pack.
     * <li>The request is sent with empty string as the hash when the hash is
     *     not provided. This might result in newer versions not loading the
     *     pack correctly.
     * </ul>
     *
     * @deprecated in favour of {@link #setResourcePack(String, byte[], Component, boolean)}
     * @param url The URL from which the client will download the resource
     *     pack. The string must contain only US-ASCII characters and should
     *     be encoded as per RFC 1738.
     * @param hash The sha1 hash sum of the resource pack file which is used
     *     to apply a cached version of the pack directly without downloading
     *     if it is available. Hast to be 20 bytes long!
     * @param prompt The optional custom prompt message to be shown to client.
     * @throws IllegalArgumentException Thrown if the URL is null.
     * @throws IllegalArgumentException Thrown if the URL is too long. The
     *     length restriction is an implementation specific arbitrary value.
     * @throws IllegalArgumentException Thrown if the hash is not 20 bytes
     *     long.
     */
    @Deprecated // Paper
    void setResourcePack(@NonNull String url, @Nullable byte[] hash, @Nullable String prompt);

    // Paper start
    /**
     * Request that the player's client download and switch resource packs.
     * <p>
     * The player's client will download the new resource pack asynchronously
     * in the background, and will automatically switch to it once the
     * download is complete. If the client has downloaded and cached a
     * resource pack with the same hash in the past it will not download but
     * directly apply the cached pack. If the hash is null and the client has
     * downloaded and cached the same resource pack in the past, it will
     * perform a file size check against the response content to determine if
     * the resource pack has changed and needs to be downloaded again. When
     * this request is sent for the very first time from a given server, the
     * client will first display a confirmation GUI to the player before
     * proceeding with the download.
     * <p>
     * Notes:
     * <ul>
     * <li>Players can disable server resources on their client, in which
     *     case this method will have no affect on them. Use the
     *     {@link PlayerResourcePackStatusEvent} to figure out whether or not
     *     the player loaded the pack!
     * <li>There is no concept of resetting resource packs back to default
     *     within Minecraft, so players will have to relog to do so or you
     *     have to send an empty pack.
     * <li>The request is sent with empty string as the hash when the hash is
     *     not provided. This might result in newer versions not loading the
     *     pack correctly.
     * </ul>
     *
     * @param url The URL from which the client will download the resource
     *     pack. The string must contain only US-ASCII characters and should
     *     be encoded as per RFC 1738.
     * @param hash The sha1 hash sum of the resource pack file which is used
     *     to apply a cached version of the pack directly without downloading
     *     if it is available. Hast to be 20 bytes long!
     * @param prompt The optional custom prompt message to be shown to client.
     * @throws IllegalArgumentException Thrown if the URL is null.
     * @throws IllegalArgumentException Thrown if the URL is too long. The
     *     length restriction is an implementation specific arbitrary value.
     * @throws IllegalArgumentException Thrown if the hash is not 20 bytes
     *     long.
     */
    default void setResourcePack(@NonNull String url, byte @Nullable [] hash, net.kyori.adventure.text.@Nullable Component prompt) {
        this.setResourcePack(url, hash, prompt, false);
    }
    // Paper end

    /**
     * Request that the player's client download and switch resource packs.
     * <p>
     * The player's client will download the new resource pack asynchronously
     * in the background, and will automatically switch to it once the
     * download is complete. If the client has downloaded and cached a
     * resource pack with the same hash in the past it will not download but
     * directly apply the cached pack. If the hash is null and the client has
     * downloaded and cached the same resource pack in the past, it will
     * perform a file size check against the response content to determine if
     * the resource pack has changed and needs to be downloaded again. When
     * this request is sent for the very first time from a given server, the
     * client will first display a confirmation GUI to the player before
     * proceeding with the download.
     * <p>
     * Notes:
     * <ul>
     * <li>Players can disable server resources on their client, in which
     *     case this method will have no affect on them. Use the
     *     {@link PlayerResourcePackStatusEvent} to figure out whether or not
     *     the player loaded the pack!
     * <li>There is no concept of resetting resource packs back to default
     *     within Minecraft, so players will have to relog to do so or you
     *     have to send an empty pack.
     * <li>The request is sent with empty string as the hash when the hash is
     *     not provided. This might result in newer versions not loading the
     *     pack correctly.
     * </ul>
     *
     * @param url The URL from which the client will download the resource
     *     pack. The string must contain only US-ASCII characters and should
     *     be encoded as per RFC 1738.
     * @param hash The sha1 hash sum of the resource pack file which is used
     *     to apply a cached version of the pack directly without downloading
     *     if it is available. Hast to be 20 bytes long!
     * @param force If true, the client will be disconnected from the server
     *     when it declines to use the resource pack.
     * @throws IllegalArgumentException Thrown if the URL is null.
     * @throws IllegalArgumentException Thrown if the URL is too long. The
     *     length restriction is an implementation specific arbitrary value.
     * @throws IllegalArgumentException Thrown if the hash is not 20 bytes
     *     long.
     */
    void setResourcePack(@NonNull String url, @Nullable byte[] hash, boolean force);

    /**
     * Request that the player's client download and switch resource packs.
     * <p>
     * The player's client will download the new resource pack asynchronously
     * in the background, and will automatically switch to it once the
     * download is complete. If the client has downloaded and cached a
     * resource pack with the same hash in the past it will not download but
     * directly apply the cached pack. If the hash is null and the client has
     * downloaded and cached the same resource pack in the past, it will
     * perform a file size check against the response content to determine if
     * the resource pack has changed and needs to be downloaded again. When
     * this request is sent for the very first time from a given server, the
     * client will first display a confirmation GUI to the player before
     * proceeding with the download.
     * <p>
     * Notes:
     * <ul>
     * <li>Players can disable server resources on their client, in which
     *     case this method will have no affect on them. Use the
     *     {@link PlayerResourcePackStatusEvent} to figure out whether or not
     *     the player loaded the pack!
     * <li>There is no concept of resetting resource packs back to default
     *     within Minecraft, so players will have to relog to do so or you
     *     have to send an empty pack.
     * <li>The request is sent with empty string as the hash when the hash is
     *     not provided. This might result in newer versions not loading the
     *     pack correctly.
     * </ul>
     *
     * @param url The URL from which the client will download the resource
     *     pack. The string must contain only US-ASCII characters and should
     *     be encoded as per RFC 1738.
     * @param hash The sha1 hash sum of the resource pack file which is used
     *     to apply a cached version of the pack directly without downloading
     *     if it is available. Hast to be 20 bytes long!
     * @param prompt The optional custom prompt message to be shown to client.
     * @param force If true, the client will be disconnected from the server
     *     when it declines to use the resource pack.
     * @throws IllegalArgumentException Thrown if the URL is null.
     * @throws IllegalArgumentException Thrown if the URL is too long. The
     *     length restriction is an implementation specific arbitrary value.
     * @throws IllegalArgumentException Thrown if the hash is not 20 bytes
     *     long.
     */
    @Deprecated // Paper
    void setResourcePack(@NonNull String url, @Nullable byte[] hash, @Nullable String prompt, boolean force);

    // Paper start
    /**
     * Request that the player's client download and switch resource packs.
     * <p>
     * The player's client will download the new resource pack asynchronously
     * in the background, and will automatically switch to it once the
     * download is complete. If the client has downloaded and cached a
     * resource pack with the same hash in the past it will not download but
     * directly apply the cached pack. If the hash is null and the client has
     * downloaded and cached the same resource pack in the past, it will
     * perform a file size check against the response content to determine if
     * the resource pack has changed and needs to be downloaded again. When
     * this request is sent for the very first time from a given server, the
     * client will first display a confirmation GUI to the player before
     * proceeding with the download.
     * <p>
     * Notes:
     * <ul>
     * <li>Players can disable server resources on their client, in which
     *     case this method will have no affect on them. Use the
     *     {@link PlayerResourcePackStatusEvent} to figure out whether or not
     *     the player loaded the pack!
     * <li>There is no concept of resetting resource packs back to default
     *     within Minecraft, so players will have to relog to do so or you
     *     have to send an empty pack.
     * <li>The request is sent with empty string as the hash when the hash is
     *     not provided. This might result in newer versions not loading the
     *     pack correctly.
     * </ul>
     *
     * @param url The URL from which the client will download the resource
     *     pack. The string must contain only US-ASCII characters and should
     *     be encoded as per RFC 1738.
     * @param hash The sha1 hash sum of the resource pack file which is used
     *     to apply a cached version of the pack directly without downloading
     *     if it is available. Hast to be 20 bytes long!
     * @param prompt The optional custom prompt message to be shown to client.
     * @param force If true, the client will be disconnected from the server
     *     when it declines to use the resource pack.
     * @throws IllegalArgumentException Thrown if the URL is null.
     * @throws IllegalArgumentException Thrown if the URL is too long. The
     *     length restriction is an implementation specific arbitrary value.
     * @throws IllegalArgumentException Thrown if the hash is not 20 bytes
     *     long.
     */
    void setResourcePack(@NonNull String url, byte @Nullable [] hash, net.kyori.adventure.text.@Nullable Component prompt, boolean force);
    // Paper end

    /**
     * Gets the Scoreboard displayed to this player
     *
     * @return The current scoreboard seen by this player
     */
    @NonNull Scoreboard getScoreboard();

    /**
     * Sets the player's visible Scoreboard.
     *
     * @param scoreboard New Scoreboard for the player
     * @throws IllegalArgumentException if scoreboard is null
     * @throws IllegalArgumentException if scoreboard was not created by the
     *     {@link org.bukkit.scoreboard.ScoreboardManager scoreboard manager}
     * @throws IllegalStateException if this is a player that is not logged
     *     yet or has logged out
     */
    void setScoreboard(@NonNull Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException;

    /**
     * Gets the {@link WorldBorder} visible to this Player, or null if viewing
     * the world's world border.
     *
     * @return the player's world border
     */
    @Nullable WorldBorder getWorldBorder();

    /**
     * Sets the {@link WorldBorder} visible to this Player.
     *
     * @param border the border to set, or null to set to the world border of
     * the player's current world
     *
     * @throws UnsupportedOperationException if setting the border to that of
     * a world in which the player is not currently present.
     *
     * @see Server#createWorldBorder()
     */
    void setWorldBorder(@Nullable WorldBorder border);

    /**
     * Send a health update to the player. This will adjust the health, food, and
     * saturation on the client and will not affect the player's actual values on
     * the server. As soon as any of these values change on the server, changes sent
     * by this method will no longer be visible.
     *
     * @param health the health. If 0.0, the client will believe it is dead
     * @param foodLevel the food level
     * @param saturation the saturation
     */
    void sendHealthUpdate(double health, int foodLevel, float saturation);

    /**
     * Send a health update to the player using its known server values. This will
     * synchronize the health, food, and saturation on the client and therefore may
     * be useful when changing a player's maximum health attribute.
     */
    void sendHealthUpdate();

    /**
     * Gets if the client is displayed a 'scaled' health, that is, health on a
     * scale from 0-{@link #getHealthScale()}.
     *
     * @return if client health display is scaled
     * @see Player#setHealthScaled(boolean)
     */
    boolean isHealthScaled();

    /**
     * Sets if the client is displayed a 'scaled' health, that is, health on a
     * scale from 0-{@link #getHealthScale()}.
     * <p>
     * Displayed health follows a simple formula <code>displayedHealth =
     * getHealth() / getMaxHealth() * getHealthScale()</code>.
     *
     * @param scale if the client health display is scaled
     */
    void setHealthScaled(boolean scale);

    /**
     * Sets the number to scale health to for the client; this will also
     * {@link #setHealthScaled(boolean) setHealthScaled(true)}.
     * <p>
     * Displayed health follows a simple formula <code>displayedHealth =
     * getHealth() / getMaxHealth() * getHealthScale()</code>.
     *
     * @param scale the number to scale health to
     * @throws IllegalArgumentException if scale is &lt;0
     * @throws IllegalArgumentException if scale is {@link Double#NaN}
     * @throws IllegalArgumentException if scale is too high
     */
    void setHealthScale(double scale) throws IllegalArgumentException;

    /**
     * Gets the number that health is scaled to for the client.
     *
     * @return the number that health would be scaled to for the client if
     *     HealthScaling is set to true
     * @see Player#setHealthScale(double)
     * @see Player#setHealthScaled(boolean)
     */
    double getHealthScale();

    /**
     * Gets the entity which is followed by the camera when in
     * {@link GameMode#SPECTATOR}.
     *
     * @return the followed entity, or null if not in spectator mode or not
     * following a specific entity.
     */
    @Nullable Entity getSpectatorTarget();

    /**
     * Sets the entity which is followed by the camera when in
     * {@link GameMode#SPECTATOR}.
     *
     * @param entity the entity to follow or null to reset
     * @throws IllegalStateException if the player is not in
     * {@link GameMode#SPECTATOR}
     */
    void setSpectatorTarget(@Nullable Entity entity);



    /**
     * Resets the title displayed to the player. This will clear the displayed
     * title / subtitle and reset timings to their default values.
     */
    void resetTitle();

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location.
     *
     * @param particle the particle to spawn
     * @param location the location to spawn at
     * @param count the number of particles
     */
    void spawnParticle(@NonNull Particle particle, @NonNull Location location, int count);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location.
     *
     * @param particle the particle to spawn
     * @param x the position on the x axis to spawn at
     * @param y the position on the y axis to spawn at
     * @param z the position on the z axis to spawn at
     * @param count the number of particles
     */
    void spawnParticle(@NonNull Particle particle, double x, double y, double z, int count);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location.
     *
     * @param <T> type of particle data (see {@link Particle#getDataType()}
     * @param particle the particle to spawn
     * @param location the location to spawn at
     * @param count the number of particles
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    <T> void spawnParticle(@NonNull Particle particle, @NonNull Location location, int count, @Nullable T data);


    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location.
     *
     * @param <T> type of particle data (see {@link Particle#getDataType()}
     * @param particle the particle to spawn
     * @param x the position on the x axis to spawn at
     * @param y the position on the y axis to spawn at
     * @param z the position on the z axis to spawn at
     * @param count the number of particles
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    <T> void spawnParticle(@NonNull Particle particle, double x, double y, double z, int count, @Nullable T data);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param particle the particle to spawn
     * @param location the location to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     */
    void spawnParticle(@NonNull Particle particle, @NonNull Location location, int count, double offsetX, double offsetY, double offsetZ);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param particle the particle to spawn
     * @param x the position on the x axis to spawn at
     * @param y the position on the y axis to spawn at
     * @param z the position on the z axis to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     */
    void spawnParticle(@NonNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param <T> type of particle data (see {@link Particle#getDataType()}
     * @param particle the particle to spawn
     * @param location the location to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    <T> void spawnParticle(@NonNull Particle particle, @NonNull Location location, int count, double offsetX, double offsetY, double offsetZ, @Nullable T data);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param <T> type of particle data (see {@link Particle#getDataType()}
     * @param particle the particle to spawn
     * @param x the position on the x axis to spawn at
     * @param y the position on the y axis to spawn at
     * @param z the position on the z axis to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    <T> void spawnParticle(@NonNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, @Nullable T data);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param particle the particle to spawn
     * @param location the location to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     * @param extra the extra data for this particle, depends on the
     *              particle used (normally speed)
     */
    void spawnParticle(@NonNull Particle particle, @NonNull Location location, int count, double offsetX, double offsetY, double offsetZ, double extra);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param particle the particle to spawn
     * @param x the position on the x axis to spawn at
     * @param y the position on the y axis to spawn at
     * @param z the position on the z axis to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     * @param extra the extra data for this particle, depends on the
     *              particle used (normally speed)
     */
    void spawnParticle(@NonNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param <T> type of particle data (see {@link Particle#getDataType()}
     * @param particle the particle to spawn
     * @param location the location to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     * @param extra the extra data for this particle, depends on the
     *              particle used (normally speed)
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    <T> void spawnParticle(@NonNull Particle particle, @NonNull Location location, int count, double offsetX, double offsetY, double offsetZ, double extra, @Nullable T data);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param <T> type of particle data (see {@link Particle#getDataType()}
     * @param particle the particle to spawn
     * @param x the position on the x axis to spawn at
     * @param y the position on the y axis to spawn at
     * @param z the position on the z axis to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     * @param extra the extra data for this particle, depends on the
     *              particle used (normally speed)
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    <T> void spawnParticle(@NonNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra, @Nullable T data);

    /**
     * Return the player's progression on the specified advancement.
     *
     * @param advancement advancement
     * @return object detailing the player's progress
     */
    @NonNull AdvancementProgress getAdvancementProgress(@NonNull Advancement advancement);

    /**
     * Get the player's current client side view distance.
     * <br>
     * Will default to the server view distance if the client has not yet
     * communicated this information,
     *
     * @return client view distance as above
     */
    int getClientViewDistance();

    // Paper start
    /**
     * Gets the player's current locale.
     *
     * @return the player's locale
     */
    @NonNull java.util.Locale locale();
    // Paper end
    /**
     * Gets the player's estimated ping in milliseconds.
     *
     * In Vanilla this value represents a weighted average of the response time
     * to application layer ping packets sent. This value does not represent the
     * network round trip time and as such may have less granularity and be
     * impacted by other sources. For these reasons it <b>should not</b> be used
     * for anti-cheat purposes. Its recommended use is only as a
     * <b>qualitative</b> indicator of connection quality (Vanilla uses it for
     * this purpose in the tab list).
     *
     * @return player ping
     */
    int getPing();

    /**
     * Gets the player's current locale.
     *
     * The value of the locale String is not defined properly.
     * <br>
     * The vanilla Minecraft client will use lowercase language / country pairs
     * separated by an underscore, but custom resource packs may use any format
     * they wish.
     *
     * @return the player's locale
     * @deprecated in favour of {@link #locale()}
     */
    @NonNull
    @Deprecated // Paper
    String getLocale();

    // Paper start
    /**
     * Get whether the player can affect mob spawning
     *
     * @return if the player can affect mob spawning
     */
    boolean getAffectsSpawning();

    /**
     * Set whether the player can affect mob spawning
     *
     * @param affects Whether the player can affect mob spawning
     */
    void setAffectsSpawning(boolean affects);

    /**
     * Gets the view distance for this player
     *
     * @return the player's view distance
     * @see org.bukkit.World#getViewDistance()
     */
    int getViewDistance();

    /**
     * Sets the view distance for this player
     *
     * @param viewDistance the player's view distance
     * @see org.bukkit.World#setViewDistance(int)
     */
    void setViewDistance(int viewDistance);

    /**
     * Gets the simulation distance for this player
     *
     * @return the player's simulation distance
     */
    int getSimulationDistance();

    /**
     * Sets the simulation distance for this player
     *
     * @param simulationDistance the player's new simulation distance
     */
    void setSimulationDistance(int simulationDistance);

    /**
     * Gets the no-ticking view distance for this player.
     * <p>
     * No-tick view distance is the view distance where chunks will load, however the chunks and their entities will not
     * be set to tick.
     * </p>
     * @return The no-tick view distance for this player.
     * @deprecated Use {@link #getViewDistance()}
     */
    @Deprecated
    int getNoTickViewDistance();

    /**
     * Sets the no-ticking view distance for this player.
     * <p>
     * No-tick view distance is the view distance where chunks will load, however the chunks and their entities will not
     * be set to tick.
     * </p>
     * @param viewDistance view distance in [2, 32] or -1
     * @deprecated Use {@link #setViewDistance(int)}
     */
    @Deprecated
    void setNoTickViewDistance(int viewDistance);

    /**
     * Gets the sending view distance for this player.
     * <p>
     * Sending view distance is the view distance where chunks will load in for players.
     * </p>
     * @return The sending view distance for this player.
     */
    int getSendViewDistance();

    /**
     * Sets the sending view distance for this player.
     * <p>
     * Sending view distance is the view distance where chunks will load in for players.
     * </p>
     * @param viewDistance view distance in [2, 32] or -1
     */
    void setSendViewDistance(int viewDistance);
    // Paper end

    /**
     * Update the list of commands sent to the client.
     * <br>
     * Generally useful to ensure the client has a complete list of commands
     * after permission changes are done.
     */
    void updateCommands();

    /**
     * Open a {@link Material#WRITTEN_BOOK} for a Player
     *
     * @param book The book to open for this player
     */
    void openBook(@NonNull ItemStack book);

    /**
     * Open a Sign for editing by the Player.
     *
     * The Sign must be in the same world as the player.
     *
     * @param sign The sign to edit
     * @deprecated use {@link #openSign(Sign, Side)}
     */
    @Deprecated
    void openSign(@NonNull Sign sign);

    /**
     * Open a Sign for editing by the Player.
     *
     * The Sign must be placed in the same world as the player.
     *
     * @param sign The sign to edit
     * @param side The side to edit
     */
    void openSign(@NonNull Sign sign, @NonNull Side side);

    /**
     * Shows the demo screen to the player, this screen is normally only seen in
     * the demo version of the game.
     * <br>
     * Servers can modify the text on this screen using a resource pack.
     */
    void showDemoScreen();

    /**
     * Gets whether the player has the "Allow Server Listings" setting enabled.
     *
     * @return whether the player allows server listings
     */
    boolean isAllowingServerListings();

    // Paper start
    @NonNull
    @Override
    default HoverEvent<HoverEvent.ShowEntity> asHoverEvent(final @NonNull UnaryOperator<HoverEvent.ShowEntity> op) {
        return HoverEvent.showEntity(op.apply(HoverEvent.ShowEntity.of(this.getType().getKey(), this.getUniqueId(), this.displayName())));
    }

    /**
     * Request that the player's client download and switch resource packs.
     * <p>
     * The player's client will download the new resource pack asynchronously
     * in the background, and will automatically switch to it once the
     * download is complete. If the client has downloaded and cached the same
     * resource pack in the past, it will perform a quick timestamp check
     * over the network to determine if the resource pack has changed and
     * needs to be downloaded again. When this request is sent for the very
     * first time from a given server, the client will first display a
     * confirmation GUI to the player before proceeding with the download.
     * <p>
     * Notes:
     * <ul>
     * <li>Players can disable server resources on their client, in which
     *     case this method will have no affect on them.
     * <li>There is no concept of resetting resource packs back to default
     *     within Minecraft, so players will have to relog to do so.
     * </ul>
     *
     * @param url The URL from which the client will download the resource
     *     pack. The string must contain only US-ASCII characters and should
     *     be encoded as per RFC 1738.
     * @param hash A 40 character hexadecimal and lowercase SHA-1 digest of
     *     the resource pack file.
     * @throws IllegalArgumentException Thrown if the URL is null.
     * @throws IllegalArgumentException Thrown if the URL is too long. The
     *     length restriction is an implementation specific arbitrary value.
     */
    void setResourcePack(@NonNull String url, @NonNull String hash);

    /**
     * Request that the player's client download and switch resource packs.
     * <p>
     * The player's client will download the new resource pack asynchronously
     * in the background, and will automatically switch to it once the
     * download is complete. If the client has downloaded and cached the same
     * resource pack in the past, it will perform a quick timestamp check
     * over the network to determine if the resource pack has changed and
     * needs to be downloaded again. When this request is sent for the very
     * first time from a given server, the client will first display a
     * confirmation GUI to the player before proceeding with the download.
     * <p>
     * Notes:
     * <ul>
     * <li>Players can disable server resources on their client, in which
     *     case this method will have no affect on them.
     * <li>There is no concept of resetting resource packs back to default
     *     within Minecraft, so players will have to relog to do so.
     * </ul>
     *
     * @param url The URL from which the client will download the resource
     *     pack. The string must contain only US-ASCII characters and should
     *     be encoded as per RFC 1738.
     * @param hash A 40 character hexadecimal and lowercase SHA-1 digest of
     *     the resource pack file.
     * @param required Marks if the resource pack should be required by the client
     * @throws IllegalArgumentException Thrown if the URL is null.
     * @throws IllegalArgumentException Thrown if the URL is too long. The
     *     length restriction is an implementation specific arbitrary value.
     */
    void setResourcePack(@NonNull String url, @NonNull String hash, boolean required);

    /**
     * Request that the player's client download and switch resource packs.
     * <p>
     * The player's client will download the new resource pack asynchronously
     * in the background, and will automatically switch to it once the
     * download is complete. If the client has downloaded and cached the same
     * resource pack in the past, it will perform a quick timestamp check
     * over the network to determine if the resource pack has changed and
     * needs to be downloaded again. When this request is sent for the very
     * first time from a given server, the client will first display a
     * confirmation GUI to the player before proceeding with the download.
     * <p>
     * Notes:
     * <ul>
     * <li>Players can disable server resources on their client, in which
     *     case this method will have no affect on them.
     * <li>There is no concept of resetting resource packs back to default
     *     within Minecraft, so players will have to relog to do so.
     * </ul>
     *
     * @param url The URL from which the client will download the resource
     *     pack. The string must contain only US-ASCII characters and should
     *     be encoded as per RFC 1738.
     * @param hash A 40 character hexadecimal and lowercase SHA-1 digest of
     *     the resource pack file.
     * @param required Marks if the resource pack should be required by the client
     * @param resourcePackPrompt A Prompt to be displayed in the client request
     * @throws IllegalArgumentException Thrown if the URL is null.
     * @throws IllegalArgumentException Thrown if the URL is too long. The
     *     length restriction is an implementation specific arbitrary value.
     */
    void setResourcePack(@NonNull String url, @NonNull String hash, boolean required, @Nullable net.kyori.adventure.text.Component resourcePackPrompt);
    /**
     * @return the most recent resource pack status received from the player,
     *         or null if no status has ever been received from this player.
     */
    @Nullable
    PlayerResourcePackStatusEvent.Status getResourcePackStatus();

    /**
     * @return the most recent resource pack hash received from the player,
     *         or null if no hash has ever been received from this player.
     *
     * @deprecated This is no longer sent from the client and will always be null
     */
    @Nullable
    @Deprecated
    String getResourcePackHash();

    /**
     * @return true if the last resource pack status received from this player
     *         was {@link org.bukkit.event.player.PlayerResourcePackStatusEvent.Status#SUCCESSFULLY_LOADED}
     */
    boolean hasResourcePack();

    /**
     * Gets a copy of this players profile
     * @return The players profile object
     */
    @NonNull
    PlayerProfile getPlayerProfile();

    /**
     * Changes the PlayerProfile for this player. This will cause this player
     * to be reregistered to all clients that can currently see this player.
     *
     * After executing this method, the player {@link java.util.UUID} won't
     * be swapped, only their name and gameprofile properties.
     *
     * @param profile The new profile to use
     */
    void setPlayerProfile(@NonNull PlayerProfile profile);

    /**
     * Returns the amount of ticks the current cooldown lasts
     *
     * @return Amount of ticks cooldown will last
     */
    float getCooldownPeriod();

    /**
     * Returns the percentage of attack power available based on the cooldown (zero to one).
     *
     * @param adjustTicks Amount of ticks to add to cooldown counter for this calculation
     * @return Percentage of attack power available
     */
    float getCooledAttackStrength(float adjustTicks);

    /**
     * Reset the cooldown counter to 0, effectively starting the cooldown period.
     */
    void resetCooldown();

    /**
     * @return the client option value of the player
     */
    @NonNull
    <T> T getClientOption(@NonNull ClientOption<T> option);

    /**
     * Boost a Player that's {@link #isGliding()} using a {@link Firework}.
     * If the creation of the entity is cancelled, no boosting is done.
     * This method does not fire {@link com.destroystokyo.paper.event.player.PlayerElytraBoostEvent}.
     *
     * @param firework The {@link Material#FIREWORK_ROCKET} to boost the player with
     * @return The {@link Firework} boosting the Player or null if the spawning of the entity was cancelled
     * @throws IllegalArgumentException if {@link #isGliding()} is false
     * or if the {@code firework} isn't a {@link Material#FIREWORK_ROCKET}
     */
    @Nullable
    Firework boostElytra(@NonNull ItemStack firework);

    /**
     * Send a packet to the player indicating its operator status level.
     * <p>
     * <b>Note:</b> This will not persist across more than the current connection, and setting the player's operator
     * status as a later point <i>will</i> override the effects of this.
     *
     * @param level The level to send to the player. Must be in {@code [0, 4]}.
     * @throws IllegalArgumentException If the level is negative or greater than {@code 4} (i.e. not within {@code [0, 4]}).
     */
    void sendOpLevel(byte level);

    /**
     * Returns player's client brand name. If the client didn't send this information, the brand name will be null.<br>
     * For the Notchian client this name defaults to <code>vanilla</code>. Some modified clients report other names such as <code>forge</code>.<br>
     * @return client brand name
     */
    @Nullable
    String getClientBrandName();

    /**
     * Sets the player's rotation.
     *
     * @param yaw the yaw
     * @param pitch the pitch
     */
    @ApiStatus.Experimental
    void setRotation(float yaw, float pitch);

    /**
     * Causes the player to look towards the given position.
     *
     * @param x x coordinate
     * @param y y coordinate
     * @param z z coordinate
     * @param playerAnchor What part of the player should face the given position
     */
    @ApiStatus.Experimental
    void lookAt(double x, double y, double z, @NonNull LookAnchor playerAnchor);

    /**
     * Causes the player to look towards the given position.
     *
     * @param position Position to look at in the player's current world
     * @param playerAnchor What part of the player should face the given position
     */
    @ApiStatus.Experimental
    default void lookAt(@NonNull Position position, @NonNull LookAnchor playerAnchor) {
        this.lookAt(position.x(), position.y(), position.z(), playerAnchor);
    }

    /**
     * Causes the player to look towards the given entity.
     *
     * @param entity Entity to look at
     * @param playerAnchor What part of the player should face the entity
     * @param entityAnchor What part of the entity the player should face
     */
    @ApiStatus.Experimental
    void lookAt(@NonNull Entity entity, @NonNull LookAnchor playerAnchor, @NonNull LookAnchor entityAnchor);
    // Paper end - Teleport API

    // Paper start
    /**
     * Displays elder guardian effect with a sound
     *
     * @see #showElderGuardian(boolean)
     */
    default void showElderGuardian() {
        showElderGuardian(false);
    }

    /**
     * Displays elder guardian effect and optionally plays a sound
     *
     * @param silent whether sound should be silenced
     */
    void showElderGuardian(boolean silent);

    /**
     * Returns the player's cooldown in ticks until the next Warden warning can occur.
     *
     * @return ticks until next Warden warning can occur. 0 means there is no cooldown left.
     */
    int getWardenWarningCooldown();

    /**
     * Sets the player's cooldown in ticks until next Warden warning can occur.
     *
     * @param cooldown ticks until next Warden warning can occur. 0 means there is no cooldown left. Values less than 0 are set to 0.
     */
    void setWardenWarningCooldown(int cooldown);

    /**
     * Returns time since last Warden warning in ticks.
     *
     * @return ticks since last Warden warning
     */
    int getWardenTimeSinceLastWarning();

    /**
     * Sets time since last Warden warning in ticks.
     *
     * @param time ticks since last Warden warning
     */
    void setWardenTimeSinceLastWarning(int time);

    /**
     * Returns the player's current Warden warning level.
     *
     * @return current Warden warning level
     */
    int getWardenWarningLevel();

    /**
     * Sets the player's Warden warning level.
     * <p>
     * <b>Note:</b> This will not actually spawn the Warden.
     * Even if the warning level is over threshold, the player still needs to activate a Shrieker in order to summon the Warden.
     *
     * @param warningLevel player's Warden warning level. The warning level is internally limited to valid values.
     */
    void setWardenWarningLevel(int warningLevel);

    /**
     * Increases the player's Warden warning level if possible and not on cooldown.
     * <p>
     * <b>Note:</b> This will not actually spawn the Warden.
     * Even if the warning level is over threshold, the player still needs to activate a Shrieker in order to summon the Warden.
     */
    void increaseWardenWarningLevel();
}

