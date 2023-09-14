package io.papermc.paper.api.registry;

import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMap;
import io.papermc.paper.api.Paper;
import io.papermc.paper.api.advancement.Advancement;
import io.papermc.paper.api.attribute.Attribute;
import io.papermc.paper.api.util.fluid.Fluid;
import io.papermc.paper.api.util.game.GameEvent;
import io.papermc.paper.api.world.Biome;
import io.papermc.paper.api.boss.KeyedBossBar;
import io.papermc.paper.api.entity.EntityType;
import io.papermc.paper.api.entity.Frog;
import io.papermc.paper.api.entity.Villager;
import io.papermc.paper.api.entity.memory.MemoryKey;
import io.papermc.paper.api.inventory.meta.trim.TrimMaterial;
import io.papermc.paper.api.inventory.meta.trim.TrimPattern;
import io.papermc.paper.api.loot.LootTables;
import io.papermc.paper.api.material.Material;
import io.papermc.paper.api.namespace.Keyed;
import io.papermc.paper.api.namespace.NamespacedKey;
import io.papermc.paper.api.sound.Sound;
import io.papermc.paper.api.util.Art;
import io.papermc.paper.api.util.Statistic;
import io.papermc.paper.api.world.generator.structure.Structure;
import io.papermc.paper.api.world.generator.structure.StructureType;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Represents a registry of Bukkit objects that may be retrieved by
 * {@link NamespacedKey}.
 *
 * @param <T> type of item in the registry
 */
public interface Registry<T extends Keyed> extends Iterable<T> {

    /**
     * Server advancements.
     *
     * @see Paper#getAdvancement(NamespacedKey)
     * @see Paper#advancementIterator()
     */
    Registry<Advancement> ADVANCEMENT = new Registry<Advancement>() {

        @Nullable
        @Override
        public Advancement get(@NonNull NamespacedKey key) {
            return Paper.getAdvancement(key);
        }

        @NonNull
        @Override
        public Iterator<Advancement> iterator() {
            return Paper.advancementIterator();
        }
    };
    /**
     * Server art.
     *
     * @see Art
     */
    Registry<Art> ART = new SimpleRegistry<>(Art.class);
    /**
     * Attribute.
     *
     * @see Attribute
     */
    Registry<Attribute> ATTRIBUTE = new SimpleRegistry<>(Attribute.class);
    /**
     * Server biomes.
     *
     * @see Biome
     */
    Registry<Biome> BIOME = new SimpleRegistry<>(Biome.class);
    /**
     * Custom boss bars.
     *
     * @see Paper#getBossBar(NamespacedKey)
     * @see Paper#getBossBars()
     */
    Registry<KeyedBossBar> BOSS_BARS = new Registry<KeyedBossBar>() {

        @Nullable
        @Override
        public KeyedBossBar get(@NonNull NamespacedKey key) {
            return Paper.getBossBar(key);
        }

        @NonNull
        @Override
        public Iterator<KeyedBossBar> iterator() {
            return Paper.getBossBars();
        }
    };
    /**
     * Server enchantments.
     *
     * @see Enchantment#getByKey(NamespacedKey)
     */
    Registry<Enchantment> ENCHANTMENT = new Registry<Enchantment>() {

        @Nullable
        @Override
        public Enchantment get(@NonNull NamespacedKey key) {
            return Enchantment.getByKey(key);
        }

        @NonNull
        @Override
        public Iterator<Enchantment> iterator() {
            return Arrays.asList(Enchantment.values()).iterator();
        }
    };
    /**
     * Server entity types.
     *
     * @see EntityType
     */
    Registry<EntityType> ENTITY_TYPE = new SimpleRegistry<>(EntityType.class, (entity) -> entity != EntityType.UNKNOWN);
    /**
     * Default server loot tables.
     *
     * @see LootTables
     */
    Registry<LootTables> LOOT_TABLES = new SimpleRegistry<>(LootTables.class);
    /**
     * Server materials.
     *
     * @see Material
     */
    Registry<Material> MATERIAL = new SimpleRegistry<>(Material.class, (mat) -> !mat.isLegacy());
    /**
     * Server statistics.
     *
     * @see Statistic
     */
    Registry<Statistic> STATISTIC = new SimpleRegistry<>(Statistic.class);
    /**
     * Server structures.
     *
     * @see Structure
     */
    Registry<Structure> STRUCTURE = Paper.getRegistry(Structure.class);
    /**
     * Server structure types.
     *
     * @see StructureType
     */
    Registry<StructureType> STRUCTURE_TYPE = Paper.getRegistry(StructureType.class);
    /**
     * Sound keys.
     *
     * @see Sound
     */
    Registry<Sound> SOUNDS = new SimpleRegistry<>(Sound.class);
    /**
     * Trim materials.
     *
     * @see TrimMaterial
     */
    //@ApiStatus.Experimental // Paper
    Registry<TrimMaterial> TRIM_MATERIAL = Paper.getRegistry(TrimMaterial.class);
    /**
     * Trim patterns.
     *
     * @see TrimPattern
     */
    //@ApiStatus.Experimental // Paper
    Registry<TrimPattern> TRIM_PATTERN = Paper.getRegistry(TrimPattern.class);
    /**
     * Villager profession.
     *
     * @see Villager.Profession
     */
    Registry<Villager.Profession> VILLAGER_PROFESSION = new SimpleRegistry<>(Villager.Profession.class);
    /**
     * Villager type.
     *
     * @see Villager.Type
     */
    Registry<Villager.Type> VILLAGER_TYPE = new SimpleRegistry<>(Villager.Type.class);
    /**
     * Memory Keys.
     *
     * @see MemoryKey
     */
    Registry<MemoryKey> MEMORY_MODULE_TYPE = new Registry<MemoryKey>() {

        @NonNull
        @Override
        public Iterator iterator() {
            return MemoryKey.values().iterator();
        }

        @Nullable
        @Override
        public MemoryKey get(@NonNull NamespacedKey key) {
            return MemoryKey.getByKey(key);
        }
    };
    /**
     * Server fluids.
     *
     * @see Fluid
     */
    Registry<Fluid> FLUID = new SimpleRegistry<>(Fluid.class);
    /**
     * Frog variants.
     *
     * @see Frog.Variant
     */
    Registry<Frog.Variant> FROG_VARIANT = new SimpleRegistry<>(Frog.Variant.class);
    /**
     * Game events.
     *
     * @see GameEvent
     */
    Registry<GameEvent> GAME_EVENT = new Registry<GameEvent>() {

        @NonNull
        @Override
        public Iterator iterator() {
            return GameEvent.values().iterator();
        }

        @Nullable
        @Override
        public GameEvent get(@NonNull NamespacedKey key) {
            return GameEvent.getByKey(key);
        }
    };

    /**
     * Potion effect types.
     *
     * @see PotionEffectType
     */
    Registry<PotionEffectType> POTION_EFFECT_TYPE = new Registry<PotionEffectType>() {

        @Nullable
        @Override
        public PotionEffectType get(@NonNull NamespacedKey key) {
            return PotionEffectType.getByKey(key);
        }

        @NonNull
        @Override
        public Iterator<PotionEffectType> iterator() {
            return Arrays.stream(PotionEffectType.values()).iterator();
        }
    };
    // Paper end

    /**
     * Get the object by its key.
     *
     * @param key non-null key
     * @return item or null if does not exist
     */
    @Nullable
    T get(@NonNull NamespacedKey key);

    final class SimpleRegistry<T extends Enum<T> & Keyed> implements Registry<T> {

        private final Map<NamespacedKey, T> map;

        protected SimpleRegistry(@NonNull Class<T> type) {
            this(type, Predicates.<T>alwaysTrue());
        }

        protected SimpleRegistry(@NonNull Class<T> type, @NonNull Predicate<T> predicate) {
            ImmutableMap.Builder<NamespacedKey, T> builder = ImmutableMap.builder();

            for (T entry : type.getEnumConstants()) {
                if (predicate.test(entry)) {
                    builder.put(entry.getKey(), entry);
                }
            }

            map = builder.build();
        }

        @Nullable
        @Override
        public T get(@NonNull NamespacedKey key) {
            return map.get(key);
        }

        @NonNull
        @Override
        public Iterator<T> iterator() {
            return map.values().iterator();
        }
    }
}

