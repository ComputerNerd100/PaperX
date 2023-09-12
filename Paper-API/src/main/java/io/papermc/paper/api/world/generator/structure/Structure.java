package io.papermc.paper.api.world.generator.structure;

import io.papermc.paper.api.namespace.Keyed;
import io.papermc.paper.api.namespace.NamespacedKey;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represent a Structure from the world.
 *
 * Listed structures are present in the default server. Depending on the server
 * there might be additional structures present (for example structures added by
 * data packs), which can be received via {@link Registry#STRUCTURE}.
 */
public interface Structure extends Keyed {

    Structure PILLAGER_OUTPOST = getStructure("pillager_outpost");
    Structure MINESHAFT = getStructure("mineshaft");
    Structure MINESHAFT_MESA = getStructure("mineshaft_mesa");
    Structure MANSION = getStructure("mansion");
    Structure JUNGLE_PYRAMID = getStructure("jungle_pyramid");
    Structure DESERT_PYRAMID = getStructure("desert_pyramid");
    Structure IGLOO = getStructure("igloo");
    Structure SHIPWRECK = getStructure("shipwreck");
    Structure SHIPWRECK_BEACHED = getStructure("shipwreck_beached");
    Structure SWAMP_HUT = getStructure("swamp_hut");
    Structure STRONGHOLD = getStructure("stronghold");
    Structure MONUMENT = getStructure("monument");
    Structure OCEAN_RUIN_COLD = getStructure("ocean_ruin_cold");
    Structure OCEAN_RUIN_WARM = getStructure("ocean_ruin_warm");
    Structure FORTRESS = getStructure("fortress");
    Structure NETHER_FOSSIL = getStructure("nether_fossil");
    Structure END_CITY = getStructure("end_city");
    Structure BURIED_TREASURE = getStructure("buried_treasure");
    Structure BASTION_REMNANT = getStructure("bastion_remnant");
    Structure VILLAGE_PLAINS = getStructure("village_plains");
    Structure VILLAGE_DESERT = getStructure("village_desert");
    Structure VILLAGE_SAVANNA = getStructure("village_savanna");
    Structure VILLAGE_SNOWY = getStructure("village_snowy");
    Structure VILLAGE_TAIGA = getStructure("village_taiga");
    Structure RUINED_PORTAL = getStructure("ruined_portal");
    Structure RUINED_PORTAL_DESERT = getStructure("ruined_portal_desert");
    Structure RUINED_PORTAL_JUNGLE = getStructure("ruined_portal_jungle");
    Structure RUINED_PORTAL_SWAMP = getStructure("ruined_portal_swamp");
    Structure RUINED_PORTAL_MOUNTAIN = getStructure("ruined_portal_mountain");
    Structure RUINED_PORTAL_OCEAN = getStructure("ruined_portal_ocean");
    Structure RUINED_PORTAL_NETHER = getStructure("ruined_portal_nether");
    Structure ANCIENT_CITY = getStructure("ancient_city");
    Structure TRAIL_RUINS = getStructure("trail_ruins");

    private static Structure getStructure(String name) {
        return Registry.STRUCTURE.get(NamespacedKey.minecraft(name));
    }

    /**
     * Returns the type of the structure.
     *
     * @return the type of structure
     */
    @NonNull
    StructureType getStructureType();
}
