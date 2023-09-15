package io.papermc.paper.api.entity;

import io.papermc.paper.api.material.Material;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a boat entity.
 */
public interface Boat extends Vehicle {

    /**
     * Gets the type of the boat.
     *
     * @return the boat type
     */
    @NonNull
    Type getBoatType();

    /**
     * Sets the type of the boat.
     *
     * @param type the new type
     */
    void setBoatType(@NonNull Type type);

    /**
     * Gets the status of the boat.
     *
     * @return the status
     */
    @NonNull
    Status getStatus();

    /**
     * Represents the type of boats.
     */
    enum Type {
        OAK(Material.OAK_PLANKS),
        SPRUCE(Material.SPRUCE_PLANKS),
        BIRCH(Material.BIRCH_PLANKS),
        JUNGLE(Material.JUNGLE_PLANKS),
        ACACIA(Material.ACACIA_PLANKS),
        CHERRY(Material.CHERRY_PLANKS),
        DARK_OAK(Material.DARK_OAK_PLANKS),
        MANGROVE(Material.MANGROVE_PLANKS),
        BAMBOO(Material.BAMBOO_PLANKS),
        ;

        private final Material materialBlock;

        Type(Material materialBlock) {
            this.materialBlock = materialBlock;
        }

        /**
         * Gets the material of the boat type.
         *
         * @return a material
         */
        @NonNull
        public Material getMaterial() {
            return this.materialBlock;
        }
    }

    /**
     * Represents the status of the boat.
     */
    enum Status {

        NOT_IN_WORLD,
        IN_WATER,
        UNDER_WATER,
        UNDER_FLOWING_WATER,
        ON_LAND,
        IN_AIR
    }

    /**
     * Gets the {@link Material} that represents this Boat type.
     *
     * @return the boat material.
     */
    @NonNull
    Material getBoatMaterial();
}
