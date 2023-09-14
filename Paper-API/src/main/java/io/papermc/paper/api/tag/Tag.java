package io.papermc.paper.api.tag;

import io.papermc.paper.api.Paper;
import io.papermc.paper.api.entity.EntityType;
import io.papermc.paper.api.material.Material;
import io.papermc.paper.api.namespace.Keyed;
import io.papermc.paper.api.namespace.NamespacedKey;
import io.papermc.paper.api.util.fluid.Fluid;
import io.papermc.paper.api.util.game.GameEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * Represents a tag that may be defined by the server or a resource pack to
 * group like things together.
 *
 * Note that whilst all tags defined within this interface must be present in
 * implementations, their existence is not guaranteed across future versions.
 *
 * <p>Custom tags defined by Paper are not present (as constants) in this class.
 * To access them please refer to {@link MaterialTags}
 * and {@link EntityTags}.</p>
 *
 * @param <T> the type of things grouped by this tag
 */
public interface Tag<T extends Keyed> extends Keyed {

    /**
     * Key for the built in block registry.
     */
    String REGISTRY_BLOCKS = "blocks";
    /**
     * Vanilla block tag representing all colors of wool.
     */
    Tag<Material> WOOL = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wool"), Material.class);
    /**
     * Vanilla block tag representing all plank variants.
     */
    Tag<Material> PLANKS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("planks"), Material.class);
    /**
     * Vanilla block tag representing all regular/mossy/cracked/chiseled stone
     * bricks.
     */
    Tag<Material> STONE_BRICKS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("stone_bricks"), Material.class);
    /**
     * Vanilla block tag representing all wooden buttons.
     */
    Tag<Material> WOODEN_BUTTONS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wooden_buttons"), Material.class);
    /**
     * Vanilla block tag representing all stone buttons.
     */
    Tag<Material> STONE_BUTTONS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("stone_buttons"), Material.class);
    /**
     * Vanilla block tag representing all buttons (inherits from
     * {@link #WOODEN_BUTTONS}.
     */
    Tag<Material> BUTTONS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("buttons"), Material.class);
    /**
     * Vanilla block tag representing all colors of carpet.
     */
    Tag<Material> WOOL_CARPETS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wool_carpets"), Material.class);
    /**
     * @deprecated {@link #WOOL_CARPETS}.
     */
    @Deprecated
    Tag<Material> CARPETS = WOOL_CARPETS;
    /**
     * Vanilla block tag representing all wooden doors.
     */
    Tag<Material> WOODEN_DOORS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wooden_doors"), Material.class);
    /**
     * Vanilla block tag representing all wooden stairs.
     */
    Tag<Material> WOODEN_STAIRS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wooden_stairs"), Material.class);
    /**
     * Vanilla block tag representing all wooden slabs.
     */
    Tag<Material> WOODEN_SLABS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wooden_slabs"), Material.class);
    /**
     * Vanilla block tag representing all wooden fences.
     */
    Tag<Material> WOODEN_FENCES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wooden_fences"), Material.class);
    /**
     * Vanilla block tag representing all pressure plates.
     */
    Tag<Material> PRESSURE_PLATES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("pressure_plates"), Material.class);
    /**
     * Vanilla block tag representing all wooden pressure plates.
     */
    Tag<Material> WOODEN_PRESSURE_PLATES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wooden_pressure_plates"), Material.class);
    /**
     * Vanilla block tag representing all stone pressure plates.
     */
    Tag<Material> STONE_PRESSURE_PLATES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("stone_pressure_plates"), Material.class);
    /**
     * Vanilla block tag representing all wooden trapdoors.
     */
    Tag<Material> WOODEN_TRAPDOORS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wooden_trapdoors"), Material.class);
    /**
     * Vanilla block tag representing all doors (inherits from
     * {@link #WOODEN_DOORS}.
     */
    Tag<Material> DOORS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("doors"), Material.class);
    /**
     * Vanilla block tag representing all sapling variants.
     */
    Tag<Material> SAPLINGS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("saplings"), Material.class);
    /**
     * Vanilla block tag representing all log and bark variants that burn.
     */
    Tag<Material> LOGS_THAT_BURN = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("logs_that_burn"), Material.class);
    /**
     * Vanilla block tag representing all log and bark variants.
     */
    Tag<Material> LOGS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("logs"), Material.class);
    /**
     * Vanilla block tag representing all dark oak log and bark variants.
     */
    Tag<Material> DARK_OAK_LOGS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("dark_oak_logs"), Material.class);
    /**
     * Vanilla block tag representing all oak log and bark variants.
     */
    Tag<Material> OAK_LOGS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("oak_logs"), Material.class);
    /**
     * Vanilla block tag representing all birch log and bark variants.
     */
    Tag<Material> BIRCH_LOGS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("birch_logs"), Material.class);
    /**
     * Vanilla block tag representing all acacia log and bark variants.
     */
    Tag<Material> ACACIA_LOGS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("acacia_logs"), Material.class);
    /**
     * Vanilla block tag representing all cherry log and bark variants.
     */
    Tag<Material> CHERRY_LOGS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("cherry_logs"), Material.class);
    /**
     * Vanilla block tag representing all jungle log and bark variants.
     */
    Tag<Material> JUNGLE_LOGS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("jungle_logs"), Material.class);
    /**
     * Vanilla block tag representing all spruce log and bark variants.
     */
    Tag<Material> SPRUCE_LOGS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("spruce_logs"), Material.class);
    /**
     * Vanilla block tag representing all mangrove log and bark variants.
     */
    Tag<Material> MANGROVE_LOGS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mangrove_logs"), Material.class);
    /**
     * Vanilla block tag representing all crimson stems.
     */
    Tag<Material> CRIMSON_STEMS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("crimson_stems"), Material.class);
    /**
     * Vanilla block tag representing all warped stems.
     */
    Tag<Material> WARPED_STEMS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("warped_stems"), Material.class);
    /**
     * Vanilla block tag representing all bamboo blocks.
     */
    Tag<Material> BAMBOO_BLOCKS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("bamboo_blocks"), Material.class);
    /**
     * Vanilla block tag representing all banner blocks.
     */
    Tag<Material> BANNERS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("banners"), Material.class);
    /**
     * Vanilla block tag representing all sand blocks.
     */
    Tag<Material> SAND = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("sand"), Material.class);
    /**
     * Vanilla block tag representing all blocks which smelt to glass in a furnace.
     */
    Tag<Material> SMELTS_TO_GLASS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("smelts_to_glass"), Material.class);
    /**
     * Vanilla block tag representing all stairs.
     */
    Tag<Material> STAIRS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("stairs"), Material.class);
    /**
     * Vanilla block tag representing all slabs.
     */
    Tag<Material> SLABS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("slabs"), Material.class);
    /**
     * Vanilla block tag representing all walls.
     */
    Tag<Material> WALLS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("walls"), Material.class);
    /**
     * Vanilla block tag representing all damaged and undamaged anvils.
     */
    Tag<Material> ANVIL = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("anvil"), Material.class);
    /**
     * Vanilla block tag representing all Minecart rails.
     */
    Tag<Material> RAILS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("rails"), Material.class);
    /**
     * Vanilla block tag representing all leaves fans.
     */
    Tag<Material> LEAVES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("leaves"), Material.class);
    /**
     * Vanilla block tag representing all trapdoors (inherits from
     * {@link #WOODEN_TRAPDOORS}.
     */
    Tag<Material> TRAPDOORS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("trapdoors"), Material.class);
    /**
     * Vanilla block tag representing all empty and filled flower pots.
     */
    Tag<Material> FLOWER_POTS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("flower_pots"), Material.class);
    /**
     * Vanilla block tag representing all small flowers.
     */
    Tag<Material> SMALL_FLOWERS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("small_flowers"), Material.class);
    /**
     * Vanilla block tag representing all beds.
     */
    Tag<Material> BEDS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("beds"), Material.class);
    /**
     * Vanilla block tag representing all fences.
     */
    Tag<Material> FENCES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("fences"), Material.class);
    /**
     * Vanilla block tag representing all tall flowers.
     */
    Tag<Material> TALL_FLOWERS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("tall_flowers"), Material.class);
    /**
     * Vanilla block tag representing all flowers.
     */
    Tag<Material> FLOWERS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("flowers"), Material.class);
    /**
     * Vanilla block tag representing all piglin repellents.
     */
    Tag<Material> PIGLIN_REPELLENTS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("piglin_repellents"), Material.class);
    /**
     * Vanilla block tag representing all gold ores.
     */
    Tag<Material> GOLD_ORES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("gold_ores"), Material.class);
    /**
     * Vanilla block tag representing all iron ores.
     */
    Tag<Material> IRON_ORES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("iron_ores"), Material.class);
    /**
     * Vanilla block tag representing all diamond ores.
     */
    Tag<Material> DIAMOND_ORES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("diamond_ores"), Material.class);
    /**
     * Vanilla block tag representing all redstone ores.
     */
    Tag<Material> REDSTONE_ORES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("redstone_ores"), Material.class);
    /**
     * Vanilla block tag representing all lapis ores.
     */
    Tag<Material> LAPIS_ORES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("lapis_ores"), Material.class);
    /**
     * Vanilla block tag representing all coal ores.
     */
    Tag<Material> COAL_ORES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("coal_ores"), Material.class);
    /**
     * Vanilla block tag representing all emerald ores.
     */
    Tag<Material> EMERALD_ORES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("emerald_ores"), Material.class);
    /**
     * Vanilla block tag representing all copper ores.
     */
    Tag<Material> COPPER_ORES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("copper_ores"), Material.class);
    /**
     * Vanilla block tag representing all candles.
     */
    Tag<Material> CANDLES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("candles"), Material.class);
    /**
     * Vanilla block tag representing all dirt.
     */
    Tag<Material> DIRT = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("dirt"), Material.class);
    /**
     * Vanilla block tag representing all terracotta.
     */
    Tag<Material> TERRACOTTA = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("terracotta"), Material.class);
    /**
     * Vanilla block tag representing all blocks which complete the find tree
     * tutorial.
     */
    Tag<Material> COMPLETES_FIND_TREE_TUTORIAL = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("completes_find_tree_tutorial"), Material.class);
    /**
     * Vanilla block tag denoting blocks that enderman may pick up and hold.
     */
    Tag<Material> ENDERMAN_HOLDABLE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("enderman_holdable"), Material.class);
    /**
     * Vanilla block tag denoting ice blocks.
     */
    Tag<Material> ICE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("ice"), Material.class);
    /**
     * Vanilla block tag denoting all valid mob spawn positions.
     */
    Tag<Material> VALID_SPAWN = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("valid_spawn"), Material.class);
    /**
     * Vanilla block tag denoting impermeable blocks which do not drip fluids.
     */
    Tag<Material> IMPERMEABLE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("impermeable"), Material.class);
    /**
     * Vanilla block tag denoting all underwater blocks which may be bonemealed.
     */
    Tag<Material> UNDERWATER_BONEMEALS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("underwater_bonemeals"), Material.class);
    /**
     * Vanilla block tag representing all coral blocks.
     */
    Tag<Material> CORAL_BLOCKS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("coral_blocks"), Material.class);
    /**
     * Vanilla block tag representing all wall corals.
     */
    Tag<Material> WALL_CORALS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wall_corals"), Material.class);
    /**
     * Vanilla block tag representing all coral plants.
     */
    Tag<Material> CORAL_PLANTS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("coral_plants"), Material.class);
    /**
     * Vanilla block tag representing all coral.
     */
    Tag<Material> CORALS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("corals"), Material.class);
    /**
     * Vanilla block tag denoting all blocks bamboo may be planted on.
     */
    Tag<Material> BAMBOO_PLANTABLE_ON = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("bamboo_plantable_on"), Material.class);
    /**
     * Vanilla block tag representing all standing signs.
     */
    Tag<Material> STANDING_SIGNS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("standing_signs"), Material.class);
    /**
     * Vanilla block tag representing all wall signs.
     */
    Tag<Material> WALL_SIGNS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wall_signs"), Material.class);
    /**
     * Vanilla block tag representing all regular signs.
     */
    Tag<Material> SIGNS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("signs"), Material.class);
    /**
     * Vanilla block tag representing all ceiling signs.
     */
    Tag<Material> CEILING_HANGING_SIGNS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("ceiling_hanging_signs"), Material.class);
    /**
     * Vanilla block tag representing all wall hanging signs.
     */
    Tag<Material> WALL_HANGING_SIGNS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wall_hanging_signs"), Material.class);
    /**
     * Vanilla block tag representing all hanging signs.
     */
    Tag<Material> ALL_HANGING_SIGNS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("all_hanging_signs"), Material.class);
    /**
     * Vanilla block tag representing all signs, regardless of type.
     */
    Tag<Material> ALL_SIGNS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("all_signs"), Material.class);
    /**
     * Vanilla block tag representing all blocks immune to dragons.
     */
    Tag<Material> DRAGON_IMMUNE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("dragon_immune"), Material.class);
    /**
     * Vanilla block tag representing all blocks transparent to the ender
     * dragon.
     */
    Tag<Material> DRAGON_TRANSPARENT = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("dragon_transparent"), Material.class);
    /**
     * Vanilla block tag representing all blocks immune to withers.
     */
    Tag<Material> WITHER_IMMUNE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wither_immune"), Material.class);
    /**
     * Vanilla block tag representing all base blocks used for wither summoning.
     */
    Tag<Material> WITHER_SUMMON_BASE_BLOCKS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wither_summon_base_blocks"), Material.class);
    /**
     * Vanilla block tag representing all beehives.
     */
    Tag<Material> BEEHIVES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("beehives"), Material.class);
    /**
     * Vanilla block tag representing all crops.
     */
    Tag<Material> CROPS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("crops"), Material.class);
    /**
     * Vanilla block tag representing all bee growables.
     */
    Tag<Material> BEE_GROWABLES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("bee_growables"), Material.class);
    /**
     * Vanilla block tag representing all portals.
     */
    Tag<Material> PORTALS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("portals"), Material.class);
    /**
     * Vanilla block tag representing all fire blocks.
     */
    Tag<Material> FIRE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("fire"), Material.class);
    /**
     * Vanilla block tag representing all nylium blocks.
     */
    Tag<Material> NYLIUM = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("nylium"), Material.class);
    /**
     * Vanilla block tag representing all wart blocks.
     */
    Tag<Material> WART_BLOCKS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wart_blocks"), Material.class);
    /**
     * Vanilla block tag representing all beacon base blocks.
     */
    Tag<Material> BEACON_BASE_BLOCKS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("beacon_base_blocks"), Material.class);
    /**
     * Vanilla block tag representing all blocks affected by the soul speed
     * enchantment.
     */
    Tag<Material> SOUL_SPEED_BLOCKS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("soul_speed_blocks"), Material.class);
    /**
     * Vanilla block tag representing all wall post overrides.
     */
    Tag<Material> WALL_POST_OVERRIDE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wall_post_override"), Material.class);
    /**
     * Vanilla block tag representing all climbable blocks.
     */
    Tag<Material> CLIMBABLE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("climbable"), Material.class);
    /**
     * Vanilla block tag representing all blocks which reset fall damage.
     */
    Tag<Material> FALL_DAMAGE_RESETTING = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("fall_damage_resetting"), Material.class);
    /**
     * Vanilla block tag representing all shulker boxes.
     */
    Tag<Material> SHULKER_BOXES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("shulker_boxes"), Material.class);
    /**
     * Vanilla block tag representing all hoglin repellents.
     */
    Tag<Material> HOGLIN_REPELLENTS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("hoglin_repellents"), Material.class);
    /**
     * Vanilla block tag representing all soul fire base blocks.
     */
    Tag<Material> SOUL_FIRE_BASE_BLOCKS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("soul_fire_base_blocks"), Material.class);
    /**
     * Vanilla block tag representing all warm strider blocks.
     */
    Tag<Material> STRIDER_WARM_BLOCKS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("strider_warm_blocks"), Material.class);
    /**
     * Vanilla block tag representing all campfires.
     */
    Tag<Material> CAMPFIRES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("campfires"), Material.class);
    /**
     * Vanilla block tag representing all blocks guarded by piglins.
     */
    Tag<Material> GUARDED_BY_PIGLINS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("guarded_by_piglins"), Material.class);
    /**
     * Vanilla block tag representing all blocks that prevent inside mob
     * spawning.
     */
    Tag<Material> PREVENT_MOB_SPAWNING_INSIDE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("prevent_mob_spawning_inside"), Material.class);
    /**
     * Vanilla block tag representing all fence gates.
     */
    Tag<Material> FENCE_GATES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("fence_gates"), Material.class);
    /**
     * Vanilla block tag representing all unstable bottom center blocks.
     */
    Tag<Material> UNSTABLE_BOTTOM_CENTER = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("unstable_bottom_center"), Material.class);
    Tag<Material> MUSHROOM_GROW_BLOCK = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mushroom_grow_block"), Material.class);

    /**
     * Vanilla block tag representing all blocks that burn forever in the
     * overworld.
     */
    Tag<Material> INFINIBURN_OVERWORLD = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("infiniburn_overworld"), Material.class);
    /**
     * Vanilla block tag representing all blocks that burn forever in the
     * nether.
     */
    Tag<Material> INFINIBURN_NETHER = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("infiniburn_nether"), Material.class);
    /**
     * Vanilla block tag representing all blocks that burn forever in the end.
     */
    Tag<Material> INFINIBURN_END = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("infiniburn_end"), Material.class);
    /**
     * Vanilla block tag representing the overworld base material.
     */
    Tag<Material> BASE_STONE_OVERWORLD = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("base_stone_overworld"), Material.class);
    /**
     * Vanilla block tag representing all blocks that may be replaced by ores.
     */
    Tag<Material> STONE_ORE_REPLACEABLES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("stone_ore_replaceables"), Material.class);
    /**
     * Vanilla block tag representing all blocks that may be replaced by
     * deepslate ores.
     */
    Tag<Material> DEEPSLATE_ORE_REPLACEABLES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("deepslate_ore_replaceables"), Material.class);
    /**
     * Vanilla block tag representing the nether base material.
     */
    Tag<Material> BASE_STONE_NETHER = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("base_stone_nether"), Material.class);
    /**
     * Vanilla block tag representing all blocks replaceable by the overworld
     * carver.
     */
    Tag<Material> OVERWORLD_CARVER_REPLACEABLES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("overworld_carver_replaceables"), Material.class);
    /**
     * Vanilla block tag representing all blocks replaceable by the nether
     * carver.
     */
    Tag<Material> NETHER_CARVER_REPLACEABLES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("nether_carver_replaceables"), Material.class);
    /**
     * Vanilla block tag representing all candle cakes.
     */
    Tag<Material> CANDLE_CAKES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("candle_cakes"), Material.class);
    /**
     * Vanilla block tag representing all cauldrons.
     */
    Tag<Material> CAULDRONS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("cauldrons"), Material.class);
    /**
     * Vanilla block tag representing all blocks that make crystal sounds.
     */
    Tag<Material> CRYSTAL_SOUND_BLOCKS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("crystal_sound_blocks"), Material.class);
    /**
     * Vanilla block tag representing all blocks that play muffled step sounds.
     */
    Tag<Material> INSIDE_STEP_SOUND_BLOCKS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("inside_step_sound_blocks"), Material.class);
    /**
     * Vanilla block tag representing all blocks that play combination step sounds.
     */
    Tag<Material> COMBINATION_STEP_SOUND_BLOCKS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("combination_step_sound_blocks"), Material.class);
    /**
     * Vanilla block tag representing all blocks that block vibration signals.
     */
    Tag<Material> OCCLUDES_VIBRATION_SIGNALS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("occludes_vibration_signals"), Material.class);
    /**
     * Vanilla block tag representing all blocks that dampen the propagation of
     * vibration signals.
     */
    Tag<Material> DAMPENS_VIBRATIONS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("dampens_vibrations"), Material.class);
    /**
     * Vanilla block tag representing all blocks that are replaceable by
     * dripstone.
     */
    Tag<Material> DRIPSTONE_REPLACEABLE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("dripstone_replaceable_blocks"), Material.class);
    /**
     * Vanilla block tag representing all cave vines.
     */
    Tag<Material> CAVE_VINES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("cave_vines"), Material.class);
    /**
     * Vanilla block tag representing all blocks replaceable by moss.
     */
    Tag<Material> MOSS_REPLACEABLE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("moss_replaceable"), Material.class);
    /**
     * Vanilla block tag representing all blocks replaceable by lush ground.
     */
    Tag<Material> LUSH_GROUND_REPLACEABLE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("lush_ground_replaceable"), Material.class);
    /**
     * Vanilla block tag representing all blocks replaceable by azalea root.
     */
    Tag<Material> AZALEA_ROOT_REPLACEABLE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("azalea_root_replaceable"), Material.class);
    /**
     * Vanilla block tag representing all blocks which small dripleaf can be
     * placed on.
     */
    Tag<Material> SMALL_DRIPLEAF_PLACEABLE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("small_dripleaf_placeable"), Material.class);
    /**
     * Vanilla block tag representing all blocks which big dripleaf can be
     * placed on.
     */
    Tag<Material> BIG_DRIPLEAF_PLACEABLE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("big_dripleaf_placeable"), Material.class);
    /**
     * Vanilla block tag representing all snow blocks.
     */
    Tag<Material> SNOW = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("snow"), Material.class);
    /**
     * Vanilla block tag representing all blocks mineable with an axe.
     */
    Tag<Material> MINEABLE_AXE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mineable/axe"), Material.class);
    /**
     * Vanilla block tag representing all blocks mineable with a hoe.
     */
    Tag<Material> MINEABLE_HOE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mineable/hoe"), Material.class);
    /**
     * Vanilla block tag representing all blocks mineable with a pickaxe.
     */
    Tag<Material> MINEABLE_PICKAXE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mineable/pickaxe"), Material.class);
    /**
     * Vanilla block tag representing all blocks mineable with a shovel.
     */
    Tag<Material> MINEABLE_SHOVEL = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mineable/shovel"), Material.class);
    /**
     * Vanilla block tag representing all blocks that can be efficiently mined with a sword.
     */
    Tag<Material> SWORD_EFFICIENT = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("sword_efficient"), Material.class);
    /**
     * Vanilla block tag representing all blocks which require a diamond tool.
     */
    Tag<Material> NEEDS_DIAMOND_TOOL = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("needs_diamond_tool"), Material.class);
    /**
     * Vanilla block tag representing all blocks which require an iron tool.
     */
    Tag<Material> NEEDS_IRON_TOOL = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("needs_iron_tool"), Material.class);
    /**
     * Vanilla block tag representing all blocks which require a stone tool.
     */
    Tag<Material> NEEDS_STONE_TOOL = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("needs_stone_tool"), Material.class);
    /**
     * Vanilla block tag representing all blocks which will not be replaced by
     * world generation features.
     */
    Tag<Material> FEATURES_CANNOT_REPLACE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("features_cannot_replace"), Material.class);
    /**
     * Vanilla block tag representing all blocks which lava pools will not
     * replace.
     */
    Tag<Material> LAVA_POOL_STONE_CANNOT_REPLACE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("lava_pool_stone_cannot_replace"), Material.class);
    /**
     * Vanilla block tag representing all blocks which geodes will not spawn in.
     */
    Tag<Material> GEODE_INVALID_BLOCKS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("geode_invalid_blocks"), Material.class);
    /**
     * Vanilla block tag representing all blocks which frogs prefer to jump to.
     */
    Tag<Material> FROG_PREFER_JUMP_TO = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("frog_prefer_jump_to"), Material.class);
    /**
     * Vanilla block tag representing all blocks which can be replaced by skulk.
     */
    Tag<Material> SCULK_REPLACEABLE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("sculk_replaceable"), Material.class);
    /**
     * Vanilla block tag representing all blocks which can be replaced by skulk
     * during world generation.
     */
    Tag<Material> SCULK_REPLACEABLE_WORLD_GEN = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("sculk_replaceable_world_gen"), Material.class);
    /**
     * Vanilla block tag representing all blocks which can be replaced by
     * ancient cities.
     */
    Tag<Material> ANCIENT_CITY_REPLACEABLE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("ancient_city_replaceable"), Material.class);
    /**
     * Vanilla block tag representing all blocks which resonate vibrations.
     */
    Tag<Material> VIBRATION_RESONATORS = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("vibration_resonators"), Material.class);
    /**
     * Vanilla block tag representing all blocks which animals will spawn on.
     */
    Tag<Material> ANIMALS_SPAWNABLE_ON = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("animals_spawnable_on"), Material.class);
    /**
     * Vanilla block tag representing all blocks which axolotls will spawn on.
     */
    Tag<Material> AXOLOTLS_SPAWNABLE_ON = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("axolotls_spawnable_on"), Material.class);
    /**
     * Vanilla block tag representing all blocks which goats will spawn on.
     */
    Tag<Material> GOATS_SPAWNABLE_ON = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("goats_spawnable_on"), Material.class);
    /**
     * Vanilla block tag representing all blocks which mooshrooms will spawn on.
     */
    Tag<Material> MOOSHROOMS_SPAWNABLE_ON = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mooshrooms_spawnable_on"), Material.class);
    /**
     * Vanilla block tag representing all blocks which parrots will spawn on.
     */
    Tag<Material> PARROTS_SPAWNABLE_ON = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("parrots_spawnable_on"), Material.class);
    /**
     * Vanilla block tag representing all blocks which polar bears will spawn
     * on.
     */
    Tag<Material> POLAR_BEARS_SPAWNABLE_ON_ALTERNATE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("polar_bears_spawnable_on_alternate"), Material.class);
    /**
     * Vanilla block tag representing all blocks which rabbits will spawn on.
     */
    Tag<Material> RABBITS_SPAWNABLE_ON = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("rabbits_spawnable_on"), Material.class);
    /**
     * Vanilla block tag representing all blocks which foxes will spawn on.
     */
    Tag<Material> FOXES_SPAWNABLE_ON = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("foxes_spawnable_on"), Material.class);
    /**
     * Vanilla block tag representing all blocks which wolves will spawn on.
     */
    Tag<Material> WOLVES_SPAWNABLE_ON = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wolves_spawnable_on"), Material.class);
    /**
     * Vanilla block tag representing all blocks which frogs will spawn on.
     */
    Tag<Material> FROGS_SPAWNABLE_ON = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("frogs_spawnable_on"), Material.class);
    /**
     * Vanilla block tag representing all blocks which azaleas will grow on.
     */
    Tag<Material> AZALEA_GROWS_ON = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("azalea_grows_on"), Material.class);
    /**
     * Vanilla block tag representing all blocks which may be converted to mud.
     */
    Tag<Material> CONVERTABLE_TO_MUD = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("convertable_to_mud"), Material.class);
    /**
     * Vanilla block tag representing all blocks which mangrove logs can grow
     * through.
     */
    Tag<Material> MANGROVE_LOGS_CAN_GROW_THROUGH = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mangrove_logs_can_grow_through"), Material.class);
    /**
     * Vanilla block tag representing all blocks which mangrove roots can grow
     * through.
     */
    Tag<Material> MANGROVE_ROOTS_CAN_GROW_THROUGH = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mangrove_roots_can_grow_through"), Material.class);
    /**
     * Vanilla block tag representing all blocks which dead bushes may be placed
     * on.
     */
    Tag<Material> DEAD_BUSH_MAY_PLACE_ON = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("dead_bush_may_place_on"), Material.class);
    /**
     * Vanilla block tag representing all blocks which snap dropped goat horns.
     */
    Tag<Material> SNAPS_GOAT_HORN = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("snaps_goat_horn"), Material.class);
    /**
     * Vanilla block tag representing all blocks replaceable by growing trees.
     */
    Tag<Material> REPLACEABLE_BY_TREES = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("replaceable_by_trees"), Material.class);
    /**
     * Vanilla block tag representing blocks which snow cannot survive on.
     */
    Tag<Material> SNOW_LAYER_CANNOT_SURVIVE_ON = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("snow_layer_cannot_survive_on"), Material.class);
    /**
     * Vanilla block tag representing blocks which snow can survive on.
     */
    Tag<Material> SNOW_LAYER_CAN_SURVIVE_ON = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("snow_layer_can_survive_on"), Material.class);
    /**
     * Vanilla block tag representing blocks which cannot be dismounted into.
     */
    Tag<Material> INVALID_SPAWN_INSIDE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("invalid_spawn_inside"), Material.class);
    /**
     * Vanilla block tag representing blocks which can be dug by sniffers.
     */
    Tag<Material> SNIFFER_DIGGABLE_BLOCK = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("sniffer_diggable_block"), Material.class);
    /**
     * Vanilla block tag representing all blocks which booster sniffer egg hatching.
     */
    Tag<Material> SNIFFER_EGG_HATCH_BOOST = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("sniffer_egg_hatch_boost"), Material.class);
    /**
     * Vanilla block tag representing all blocks which can be replaced by trail ruins.
     */
    Tag<Material> TRAIL_RUINS_REPLACEABLE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("trail_ruins_replaceable"), Material.class);
    /**
     * Vanilla block tag representing all blocks which are replaceable.
     */
    Tag<Material> REPLACEABLE = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("replaceable"), Material.class);
    /**
     * Vanilla block tag representing all blocks which provide enchantment power.
     */
    Tag<Material> ENCHANTMENT_POWER_PROVIDER = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("enchantment_power_provider"), Material.class);
    /**
     * Vanilla block tag representing all blocks which transmit enchantment power.
     */
    Tag<Material> ENCHANTMENT_POWER_TRANSMITTER = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("enchantment_power_transmitter"), Material.class);
    /**
     * Vanilla block tag representing all blocks which do not destroy farmland when placed.
     */
    Tag<Material> MAINTAINS_FARMLAND = Paper.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("maintains_farmland"), Material.class);
    /**
     * Key for the built in item registry.
     */
    String REGISTRY_ITEMS = "items";
    /**
     * Vanilla item tag representing all items loved by piglins.
     */
    Tag<Material> ITEMS_PIGLIN_LOVED = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("piglin_loved"), Material.class);
    /**
     * Vanilla item tag representing all items ignored by piglin babies.
     */
    Tag<Material> IGNORED_BY_PIGLIN_BABIES = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("ignored_by_piglin_babies"), Material.class);
    /**
     * Vanilla item tag representing all piglin food.
     */
    Tag<Material> PIGLIN_FOOD = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("piglin_food"), Material.class);
    /**
     * Vanilla item tag representing all fox food.
     */
    Tag<Material> FOX_FOOD = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("fox_food"), Material.class);
    /**
     * Vanilla item tag representing all banner items.
     */
    Tag<Material> ITEMS_BANNERS = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("banners"), Material.class);
    /**
     * Vanilla item tag representing all boat items.
     */
    Tag<Material> ITEMS_BOATS = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("boats"), Material.class);
    /**
     * Vanilla item tag representing all chest boat items.
     */
    Tag<Material> ITEMS_CHEST_BOATS = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("chest_boats"), Material.class);
    // Paper start
    /**
     * Vanilla item tag representing all non-flammable wood items.
     */
    Tag<Material> ITEMS_NON_FLAMMABLE_WOOD = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("non_flammable_wood"), Material.class);
    // Paper end
    /**
     * Vanilla item tag representing all fish items.
     */
    Tag<Material> ITEMS_FISHES = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("fishes"), Material.class);
    /**
     * Vanilla item tag representing all music disc items.
     */
    Tag<Material> ITEMS_MUSIC_DISCS = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("music_discs"), Material.class);
    /**
     * Vanilla item tag representing all music disc items dropped by creepers.
     */
    Tag<Material> ITEMS_CREEPER_DROP_MUSIC_DISCS = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("creeper_drop_music_discs"), Material.class);
    /**
     * Vanilla item tag representing all coal items.
     */
    Tag<Material> ITEMS_COALS = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("coals"), Material.class);
    /**
     * Vanilla item tag representing all arrow items.
     */
    Tag<Material> ITEMS_ARROWS = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("arrows"), Material.class);
    /**
     * Vanilla item tag representing all books that may be placed on lecterns.
     */
    Tag<Material> ITEMS_LECTERN_BOOKS = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("lectern_books"), Material.class);
    /**
     * Vanilla item tag representing all books that may be placed on bookshelves.
     */
    Tag<Material> ITEMS_BOOKSHELF_BOOKS = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("bookshelf_books"), Material.class);
    /**
     * Vanilla item tag representing all items that may be placed in beacons.
     */
    Tag<Material> ITEMS_BEACON_PAYMENT_ITEMS = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("beacon_payment_items"), Material.class);
    /**
     * Vanilla item tag representing all stone tool materials.
     */
    Tag<Material> ITEMS_STONE_TOOL_MATERIALS = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("stone_tool_materials"), Material.class);
    /**
     * Vanilla item tag representing all furnace materials.
     */
    Tag<Material> ITEMS_FURNACE_MATERIALS = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("furnace_materials"), Material.class);
    /**
     * Vanilla item tag representing all compasses.
     */
    Tag<Material> ITEMS_COMPASSES = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("compasses"), Material.class);
    /**
     * Vanilla item tag representing all hanging signs.
     */
    Tag<Material> ITEMS_HANGING_SIGNS = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("hanging_signs"), Material.class);
    /**
     * Vanilla item tag representing all items which will ignite creepers when
     * interacted with.
     */
    Tag<Material> ITEMS_CREEPER_IGNITERS = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("creeper_igniters"), Material.class);
    /**
     * Vanilla item tag representing all items which modify note block sounds when placed on top.
     */
    Tag<Material> ITEMS_NOTE_BLOCK_TOP_INSTRUMENTS = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("noteblock_top_instruments"), Material.class);
    /**
     * Vanilla item tag representing all trimmable armor items.
     */
    Tag<Material> ITEMS_TRIMMABLE_ARMOR = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("trimmable_armor"), Material.class);
    /**
     * Vanilla item tag representing all materials which can be used for trimming armor.
     */
    Tag<Material> ITEMS_TRIM_MATERIALS = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("trim_materials"), Material.class);
    /**
     * Vanilla item tag representing all trimming templates.
     */
    Tag<Material> ITEMS_TRIM_TEMPLATES = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("trim_templates"), Material.class);
    /**
     * Vanilla item tag representing all food for sniffers.
     */
    Tag<Material> ITEMS_SNIFFER_FOOD = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("sniffer_food"), Material.class);
    /**
     * Vanilla item tag representing all decorated pot sherds.
     */
    Tag<Material> ITEMS_DECORATED_POT_SHERDS = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("decorated_pot_sherds"), Material.class);
    /**
     * Vanilla item tag representing all decorated pot ingredients.
     */
    Tag<Material> ITEMS_DECORATED_POT_INGREDIENTS = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("decorated_pot_ingredients"), Material.class);
    /**
     * Vanilla item tag representing all swords.
     */
    Tag<Material> ITEMS_SWORDS = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("swords"), Material.class);
    /**
     * Vanilla item tag representing all axes.
     */
    Tag<Material> ITEMS_AXES = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("axes"), Material.class);
    /**
     * Vanilla item tag representing all hoes.
     */
    Tag<Material> ITEMS_HOES = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("hoes"), Material.class);
    /**
     * Vanilla item tag representing all pickaxes.
     */
    Tag<Material> ITEMS_PICKAXES = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("pickaxes"), Material.class);
    /**
     * Vanilla item tag representing all shovels.
     */
    Tag<Material> ITEMS_SHOVELS = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("shovels"), Material.class);
    /**
     * Vanilla item tag representing all tools.
     */
    Tag<Material> ITEMS_TOOLS = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("tools"), Material.class);
    /**
     * Vanilla item tag representing all items which break decorated pots.
     */
    Tag<Material> ITEMS_BREAKS_DECORATED_POTS = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("breaks_decorated_pots"), Material.class);
    /**
     * Vanilla item tag representing all seeds planteable by villagers.
     */
    Tag<Material> ITEMS_VILLAGER_PLANTABLE_SEEDS = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("villager_plantable_seeds"), Material.class);
    /**
     * Vanilla item tag representing all items that confer freeze immunity on
     * the wearer.
     */
    Tag<Material> FREEZE_IMMUNE_WEARABLES = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("freeze_immune_wearables"), Material.class);
    /**
     * Vanilla item tag representing all items which tempt axolotls.
     */
    Tag<Material> AXOLOTL_TEMPT_ITEMS = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("axolotl_tempt_items"), Material.class);
    /**
     * Vanilla item tag representing all items which are preferred for
     * harvesting clusters (unused).
     */
    Tag<Material> CLUSTER_MAX_HARVESTABLES = Paper.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("cluster_max_harvestables"), Material.class);
    /**
     * Key for the built in fluid registry.
     */
    String REGISTRY_FLUIDS = "fluids";
    /**
     * Vanilla fluid tag representing lava and flowing lava.
     */
    Tag<Fluid> FLUIDS_LAVA = Paper.getTag(REGISTRY_FLUIDS, NamespacedKey.minecraft("lava"), Fluid.class);
    /**
     * Vanilla fluid tag representing water and flowing water.
     */
    Tag<Fluid> FLUIDS_WATER = Paper.getTag(REGISTRY_FLUIDS, NamespacedKey.minecraft("water"), Fluid.class);
    /**
     * Key for the built in entity registry.
     */
    String REGISTRY_ENTITY_TYPES = "entity_types";
    /**
     * Vanilla tag representing skeletons.
     */
    Tag<EntityType> ENTITY_TYPES_SKELETONS = Paper.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("skeletons"), EntityType.class);
    /**
     * Vanilla tag representing raiders.
     */
    Tag<EntityType> ENTITY_TYPES_RAIDERS = Paper.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("raiders"), EntityType.class);
    /**
     * Vanilla tag representing entities which can live in beehives.
     */
    Tag<EntityType> ENTITY_TYPES_BEEHIVE_INHABITORS = Paper.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("beehive_inhabitors"), EntityType.class);
    /**
     * Vanilla tag representing arrows.
     */
    Tag<EntityType> ENTITY_TYPES_ARROWS = Paper.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("arrows"), EntityType.class);
    /**
     * Vanilla tag representing projectiles.
     */
    Tag<EntityType> ENTITY_TYPES_IMPACT_PROJECTILES = Paper.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("impact_projectiles"), EntityType.class);
    /**
     * Vanilla tag representing mobs which can walk on powder snow.
     */
    Tag<EntityType> ENTITY_TYPES_POWDER_SNOW_WALKABLE_MOBS = Paper.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("powder_snow_walkable_mobs"), EntityType.class);
    /**
     * Vanilla tag representing which entities axolotls are always hostile to.
     */
    Tag<EntityType> ENTITY_TYPES_AXOLOTL_ALWAYS_HOSTILES = Paper.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("axolotl_always_hostiles"), EntityType.class);
    /**
     * Vanilla tag representing axolotl targets.
     */
    Tag<EntityType> ENTITY_TYPES_AXOLOTL_HUNT_TARGETS = Paper.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("axolotl_hunt_targets"), EntityType.class);
    /**
     * Vanilla tag representing entities immune from freezing.
     */
    Tag<EntityType> ENTITY_TYPES_FREEZE_IMMUNE_ENTITY_TYPES = Paper.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("freeze_immune_entity_types"), EntityType.class);
    /**
     * Vanilla tag representing entities extra susceptible to freezing.
     */
    Tag<EntityType> ENTITY_TYPES_FREEZE_HURTS_EXTRA_TYPES = Paper.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("freeze_hurts_extra_types"), EntityType.class);
    /**
     * Vanilla tag representing entities which can be eaten by frogs.
     */
    Tag<EntityType> ENTITY_TYPES_FROG_FOOD = Paper.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("frog_food"), EntityType.class);
    /**
     * Vanilla tag representing entities which are immune from fall damage.
     */
    Tag<EntityType> ENTITY_TYPES_FALL_DAMAGE_IMMUNE = Paper.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("fall_damage_immune"), EntityType.class);
    /**
     * Vanilla tag representing entities which are dismounted when underwater.
     */
    Tag<EntityType> ENTITY_TYPES_DISMOUNTS_UNDERWATER = Paper.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("dismounts_underwater"), EntityType.class);
    // Paper start
    String REGISTRY_GAME_EVENTS = "game_events";

    /**
     * Tag for game events that trigger sculk sensors
     */
    Tag<GameEvent> GAME_EVENT_VIBRATIONS = Paper.getTag(REGISTRY_GAME_EVENTS, NamespacedKey.minecraft("vibrations"), GameEvent.class);

    /**
     * Tag for game events that are ignored if the entity is sneaking
     */
    Tag<GameEvent> GAME_EVENT_IGNORE_VIBRATIONS_SNEAKING = Paper.getTag(REGISTRY_GAME_EVENTS, NamespacedKey.minecraft("ignore_vibrations_sneaking"), GameEvent.class);

    /**
     * Tag for game events that an allay can listen to
     */
    Tag<GameEvent> GAME_EVENT_ALLAY_CAN_LISTEN = Paper.getTag(REGISTRY_GAME_EVENTS, NamespacedKey.minecraft("allay_can_listen"), GameEvent.class);
    // Paper end

    /**
     * Returns whether or not this tag has an entry for the specified item.
     *
     * @param item to check
     * @return if it is tagged
     */
    boolean isTagged(@NotNull T item);

    /**
     * Gets an immutable set of all tagged items.
     *
     * @return set of tagged items
     */
    @NotNull
    Set<T> getValues();

}

