package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.data.BlockData;
import io.papermc.paper.api.event.events.inventory.CancellableInventoryEvent;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.material.Material;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Called when an anvil is damaged from being used
 */
public interface AnvilDamagedEvent extends CancellableInventoryEvent {
    @Param(1)
    DamageState damageState();
    @Param(2)
    BlockData blockData();

    /**
     * Represents the amount of damage on an anvil block
     */
    enum DamageState {
        FULL(Material.ANVIL),
        CHIPPED(Material.CHIPPED_ANVIL),
        DAMAGED(Material.DAMAGED_ANVIL),
        BROKEN(Material.AIR);

        private Material material;

        DamageState(@NonNull Material material) {
            this.material = material;
        }

        /**
         * Get block material of this state
         *
         * @return Material
         */
        @NonNull
        public Material getMaterial() {
            return material;
        }

        /**
         * Get damaged state by block data
         *
         * @param blockData Block data
         * @return DamageState
         * @throws IllegalArgumentException If non anvil block data is given
         */
        @NonNull
        public static DamageState getState(@Nullable BlockData blockData) {
            return blockData == null ? BROKEN : getState(blockData.getMaterial());
        }

        /**
         * Get damaged state by block material
         *
         * @param material Block material
         * @return DamageState
         * @throws IllegalArgumentException If non anvil material is given
         */
        @NonNull
        public static DamageState getState(@Nullable Material material) {
            if (material == null) {
                return BROKEN;
            }
            for (DamageState state : values()) {
                if (state.material == material) {
                    return state;
                }
            }
            throw new IllegalArgumentException("Material not an anvil");
        }
    }
}
