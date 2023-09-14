package io.papermc.paper.api.world.generator.structure;

import io.papermc.paper.api.namespace.Keyed;
import io.papermc.paper.api.namespace.NamespacedKey;
import io.papermc.paper.api.registry.Registry;

/**
 * Represent a StructureType of a {@link Structure}.
 *
 * Listed structure types are present in the default server. Depending on the
 * server there might be additional structure types present (for example
 * structure types added by data packs), which can be received via
 * {@link Registry#STRUCTURE_TYPE}.
 */
public interface StructureType extends Keyed {

    StructureType BURIED_TREASURE = getStructureType("buried_treasure");
    StructureType DESERT_PYRAMID = getStructureType("desert_pyramid");
    StructureType END_CITY = getStructureType("end_city");
    StructureType FORTRESS = getStructureType("fortress");
    StructureType IGLOO = getStructureType("igloo");
    StructureType JIGSAW = getStructureType("jigsaw");
    StructureType JUNGLE_TEMPLE = getStructureType("jungle_temple");
    StructureType MINESHAFT = getStructureType("mineshaft");
    StructureType NETHER_FOSSIL = getStructureType("nether_fossil");
    StructureType OCEAN_MONUMENT = getStructureType("ocean_monument");
    StructureType OCEAN_RUIN = getStructureType("ocean_ruin");
    StructureType RUINED_PORTAL = getStructureType("ruined_portal");
    StructureType SHIPWRECK = getStructureType("shipwreck");
    StructureType STRONGHOLD = getStructureType("stronghold");
    StructureType SWAMP_HUT = getStructureType("swamp_hut");
    StructureType WOODLAND_MANSION = getStructureType("woodland_mansion");

    private static StructureType getStructureType(String name) {
        return Registry.STRUCTURE_TYPE.get(NamespacedKey.minecraft(name));
    }
}

