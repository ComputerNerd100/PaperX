package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.LivingEntity;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Called when one Entity breeds with another Entity.
 */
public interface EntityBreedEvent extends CancellableEntityEvent {
    default LivingEntity child() {
        return (LivingEntity) entity();
    }

    /**
     * Gets the parent creating this entity.
     *
     * @return The "birth" parent
     */
    @Param(1)
    LivingEntity mother();

    /**
     * Gets the other parent of the newly born entity.
     *
     * @return the other parent
     */
    @Param(2)
    LivingEntity father();

    /**
     * Gets the Entity responsible for breeding. Breeder is null for spontaneous
     * conception.
     *
     * @return The Entity who initiated breeding.
     */
    @Param(3)
    LivingEntity breeder();

    /**
     * The ItemStack that was used to initiate breeding, if present.
     *
     * @return ItemStack used to initiate breeding.
     */
    @Param(4)
    ItemStack bredWith();

    /**
     * Get the amount of experience granted by breeding.
     *
     * @return experience amount
     */
    @Param(5)
    int experience();
}
