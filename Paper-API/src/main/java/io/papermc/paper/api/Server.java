package io.papermc.paper.api;

import io.papermc.paper.api.advancement.Advancement;
import io.papermc.paper.api.ban.BanList;
import io.papermc.paper.api.block.data.BlockData;
import io.papermc.paper.api.boss.*;
import io.papermc.paper.api.inventory.*;
import io.papermc.paper.api.inventory.recipe.Recipe;
import io.papermc.paper.api.location.Location;
import io.papermc.paper.api.loot.LootTable;
import io.papermc.paper.api.material.Material;
import io.papermc.paper.api.namespace.Keyed;
import io.papermc.paper.api.namespace.NamespacedKey;
import io.papermc.paper.api.profile.PlayerProfile;
import net.kyori.adventure.audience.ForwardingAudience;
import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.logging.Logger;

public interface Server extends PluginMessageRecipient, ForwardingAudience { // TODO - Add Kyori Forwarding Audience

    @NonNull Path pluginsFolder();

    String BROADCAST_CHANNEL_ADMINISTRATIVE = "paper.broadcast.admin";

    String BROADCAST_CHANNEL_USERS = "paper.broadcast.users";

    /**
     * Gets the name of this server implementation
     * @return server implementation name
     */
    @NonNull String name();

    @NonNull String version();

    @NonNull String paperVersion();

    @NonNull String minecraftVersion();

    @NonNull Collection<? extends Player> onlinePlayers();

    int maxPlayers();

    void maxPlayers(int maxPlayers);

    int port();

    int viewDistance();

    int simulationDistance();

    String serverIp();

    String worldType();

    boolean generateStructures();

    int maxWorldSize();

    boolean allowEnd();

    boolean allowNether();

    String resourcePack();

    String resourcePackHash();

    String resourcePackPrompt();

    boolean resourcePackRequired();

    boolean whitelist();

    void whitelist(boolean value);

    boolean whitelistEnforced();

    void whitelistEnforced(boolean value);

    @NonNull Set<OfflinePlayer> whitelistPlayers();

    void reloadWhitelist();

    @NonNull String updateFolderName();

    @NonNull Path updateFolder();

    long connectionThrottle();

    int ticksPerSpawns(@NonNull SpawnCategory spawnCategory);

    @Nullable Player player(@NonNull String name);

    @Nullable Player playerExact(@NonNull String name);

    @NonNull List<Player> matchPlayer(@NonNull String name);

    @Nullable Player player(@NonNull UUID uuid);

    @NonNull UUID playerUUID(@NonNull String playerName);

    @NonNull PluginManager pluginManager();

    @NonNull PaperScheduler scheduler();

    @NonNull ServicesManager servicesManager();

    @NonNull List<World> worlds();

    @Nullable World createWorld(@NonNull WorldCreator creator);

    boolean unloadWorld(@NonNull World world, boolean save);

    boolean unloadWorld(@NonNull String worldName, boolean save);

    @Nullable World getWorld(@NonNull String name);

    @Nullable World getWorld(@NonNull UUID uuid);

    @Nullable World getWorld(@NonNull NamespacedKey worldKey);

    @NonNull WorldBorder createWorldBorder();

    @NonNull MapView createMap(@NonNull World world);

    @NonNull ItemStack createExplorerMap(@NonNull World world, @NonNull Location location, @NonNull StructureType structureType, int radius, boolean findUnexplored);

    void reload();

    void reloadData();

    @NonNull Logger logger();

    void savePlayers();

    boolean dispatchCommand(@NonNull CommandSender sender, @NonNull String commandLine) throws CommandException;

    @Contract("null -> false")
    boolean addRecipe(@Nullable Recipe recipe);

    @NonNull List<Recipe> recipesFor(@NonNull ItemStack result);

    @Nullable Recipe recipe(@NonNull NamespacedKey key);

    @Nullable Recipe craftingRecipe(@NonNull ItemStack[] craftingMatrix, @NonNull World world);

    @NonNull ItemStack craftItem(@NonNull ItemStack[] craftingMatrix, @NonNull World world, @NonNull Player player);

    @NonNull Iterator<Recipe> recipeIterator();

    void clearRecipes();

    void resetRecipes();

    boolean removeRecipe(@NonNull NamespacedKey key);

    @NonNull Map<String, String[]> commandAliases();

    int spawnRadius();

    void spawnRadius(int radius);

    boolean hideOnlinePlayers();

    boolean onlineMode();

    boolean allowFlight();

    boolean hardcore();

    void shutdown();

    int broadcast(@NonNull Component message);

    int broadcast(@NonNull Component message, @NonNull String permission);

    @NonNull OfflinePlayer getOfflinePlayer(@NonNull String name);

    @Nullable OfflinePlayer getOfflinePlayerIfCached(@NonNull String name);

    @NonNull OfflinePlayer getOfflinePlayer(@NonNull UUID uuid);

    @NonNull Set<String> getIPBans();

    void banIP(@NonNull String address);

    void unbanIP(@NonNull String address);

    @NonNull Set<OfflinePlayer> bannedPlayers();

    @NonNull BanList banList(@NotNull BanList.Type type);

    @NonNull Set<OfflinePlayer> operators();

    @NonNull GameMode defaultGamemode();

    void defaultGamemode(@NonNull GameMode mode);

    @NonNull ConsoleCommandSender consoleSender();

    @NonNull CommandSender createCommandSender(final @NonNull Consumer<? super Component> feedback);

    @NonNull Path worldContainer();

    @NonNull CompletableFuture<OfflinePlayer[]> offlinePlayers();

    @NonNull Messenger messenger();

    @NonNull HelpMap helpMap();

    @NonNull Inventory createInventory(@Nullable InventoryHolder owner, @NonNull InventoryType type);

    @NonNull Inventory createInventory(@Nullable InventoryHolder owner, @NonNull InventoryType type, @NonNull Component title);

    @NonNull Inventory createInventory(@Nullable InventoryHolder owner, int size);

    @NonNull Inventory createInventory(@Nullable InventoryHolder owner, int size, @NonNull Component title) throws IllegalArgumentException;

    @NonNull Merchant createMerchant(@NonNull Component title);

    int spawnLimit(@NonNull SpawnCategory);

    boolean isPrimaryThread();

    @NonNull Component motd();

    @Nullable Component shutdownMessage();

    @NonNull WarningState warningState();

    @NonNull ItemFactory itemFactory();

    @NonNull ScoreboardManager scoreboardManager();

    @Nullable CachedServerIcon serverIcon();

    @NonNull CachedServerIcon loadServerIcon(@NonNull Path file) throws IllegalArgumentException, Exception;

    @NonNull CachedServerIcon loadServerIcon(@NonNull BufferedImage image) throws IllegalArgumentException, Exception;

    int idleTimeout();

    void idleTimeout(int threshold);

    @NonNull ChunkGenerator.ChunkData createChunkData(@NonNull World world);

    @NonNull BossBar createBossBar(@Nullable String title, @NonNull BarColor color, @NonNull BarStyle style, @NonNull BarFlag... flags);

    @NonNull KeyedBossBar createBossBar(@NonNull NamespacedKey key, @Nullable String title, @NonNull BarColor color, @NonNull BarStyle style, @NonNull BarFlag... flags);

    @NonNull Iterator<KeyedBossBar> bossBars();

    @NonNull KeyedBossBar bossBar(@NonNull NamespacedKey key);

    boolean removeBossBar(@NonNull NamespacedKey key);

    @Nullable Entity entity(@NonNull UUID uuid);

    double[] getTPS();

    long[] getTickTimes();

    double averageTickTime();

    @NonNull CommandMap commandMap();

    @Nullable Advancement advancement(@NonNull NamespacedKey key);

    @NonNull Iterator<Advancement> advancementIterator();

    @NonNull BlockData blockData(@NonNull Material material);

    @NonNull BlockData blockData(@NonNull Material material, @Nullable Consumer<BlockData> consumer);

    @NonNull BlockData blockData(@NonNull String data) throws IllegalArgumentException;

    @Contract("null, null -> fail")
    @NonNull BlockData blockData(@Nullable Material material, @Nullable String data) throws IllegalArgumentException;

    @Nullable <T extends Keyed> Tag<T> tag(@NonNull String registry, @NonNull NamespacedKey tag, @NonNull Class<T> clazz);

    @Nullable <T extends Keyed> Iterable<Tag<T>> tags(@NonNull String registry, @NonNull Class<T> clazz);

    @Nullable LootTable lootTable(@NonNull NamespacedKey key);

    @NonNull List<Entity> selectEntities(@NonNull CommandSender sender, @NonNull String selector) throws IllegalArgumentException;

    @NonNull StructureManager structureManager();

    @NonNull UnsafeValues unsafe();

    // TODO - Spigot config class

    void reloadPermissions();

    boolean reloadCommandAliases();

    boolean suggestPlayerNamesWhenNullTabCompletions();

    @NonNull String permissionMessage();

    @NonNull PlayerProfile createProfile(@NonNull UUID uuid);

    @NonNull PlayerProfile createProfile(@NonNull String name);

    @NonNull PlayerProfile createProfile(@NonNull UUID uuid, @NonNull String name);

    @NonNull PlayerProfile createProfileExact(@NonNull UUID uuid, @NonNull String name);

    int currentTick();

    boolean isStopping();

    @NonNull MobGoals mobGoals();

    @NonNull DatapackManager datapackManager();

    @NonNull PotionBrewer potionBrewer();

}
