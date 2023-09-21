package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when an entity enters the hitbox of a block.
 * Only called for blocks that react when an entity is inside.
 * If cancelled, any action that would have resulted from that entity
 * being in the block will not happen (such as extinguishing an entity in a cauldron).
 * <p>
 * Blocks this is currently called for:
 * <ul>
 *     <li>Big dripleaf</li>
 *     <li>Bubble column</li>
 *     <li>Buttons</li>
 *     <li>Cactus</li>
 *     <li>Campfire</li>
 *     <li>Cauldron</li>
 *     <li>Crops</li>
 *     <li>Ender Portal</li>
 *     <li>Fires</li>
 *     <li>Frogspawn</li>
 *     <li>Honey</li>
 *     <li>Hopper</li>
 *     <li>Detector rails</li>
 *     <li>Nether portals</li>
 *     <li>Pitcher crop</li>
 *     <li>Powdered snow</li>
 *     <li>Pressure plates</li>
 *     <li>Sweet berry bush</li>
 *     <li>Tripwire</li>
 *     <li>Waterlily</li>
 *     <li>Web</li>
 *     <li>Wither rose</li>
 * </ul>
 */
public interface EntityInsideBlockEvent extends CancellableEntityEvent {

    /**
     * Gets the block the entity is inside.
     *
     * @return the block
     */
    @Param(1)
    Block block();
}
