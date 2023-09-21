package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.LivingEntity;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.material.Material;

/**
 * Called when two entities mate and the mating process results in a fertilization.
 * Fertilization differs from normal breeding, as represented by the {@link EntityBreedEvent}, as
 * it does not result in the immediate creation of the child entity in the world.
 * <p>
 * An example of this would be:
 * <ul>
 * <li>A frog being marked as "is_pregnant" and laying {@link Material#FROGSPAWN} later.</li>
 * <li>Sniffers producing the {@link Material#SNIFFER_EGG} item, which needs to be placed before it can begin to hatch.</li>
 * <li>A turtle being marked with "HasEgg" and laying a {@link Material#TURTLE_EGG} later.</li>
 * </ul>
 *
 * The event hence only exposes the two parent entities in the fertilization process and cannot provide the child entity, as it will only exist at a later point in time.
 */
public interface EntityFertilizeEggEvent extends CancellableEntityEvent {

    /**
     * Provides the entity in the fertilization process that will eventually be responsible for "creating" offspring,
     * may that be by setting a block that later hatches or dropping an egg that has to be placed.
     *
     * @return The "mother" entity.
     */
    default LivingEntity mother() {
        return (LivingEntity) entity();
    }

    /**
     * Provides the "father" entity in the fertilization process that is not responsible for initiating the offspring
     * creation.
     *
     * @return the other parent
     */
    @Param(1)
    LivingEntity father();

    /**
     * Gets the Entity responsible for fertilization. Breeder is null for spontaneous
     * conception.
     *
     * @return The Entity who initiated breeding.
     */
    @Param(2)
    Player breeder();

    /**
     * The ItemStack that was used to initiate fertilization, if present.
     *
     * @return ItemStack used to initiate breeding.
     */
    @Param(3)
    ItemStack bredWith();

    /**
     * Get the amount of experience granted by fertilization.
     *
     * @return experience amount
     */
    @Param(4)
    int experience();
}
