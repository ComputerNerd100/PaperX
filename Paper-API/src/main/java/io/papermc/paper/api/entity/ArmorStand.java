package io.papermc.paper.api.entity;

import io.papermc.paper.api.inventory.EntityEquipment;
import io.papermc.paper.api.inventory.EquipmentSlot;
import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.math.Rotations;
import io.papermc.paper.api.util.EulerAngle;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Set;

public interface ArmorStand extends LivingEntity {

    /**
     * Returns the armor stand's body's current pose as a
     * {@link EulerAngle}.
     *
     * @return the current pose
     */
    @NonNull
    EulerAngle getBodyPose();

    /**
     * Sets the armor stand's body's current pose as a
     * {@link EulerAngle}.
     *
     * @param pose the current pose
     */
    void setBodyPose(@NonNull EulerAngle pose);

    /**
     * Returns the armor stand's left arm's current pose as a
     * {@link EulerAngle}.
     *
     * @return the current pose
     */
    @NonNull
    EulerAngle getLeftArmPose();

    /**
     * Sets the armor stand's left arm's current pose as a
     * {@link EulerAngle}.
     *
     * @param pose the current pose
     */
    void setLeftArmPose(@NonNull EulerAngle pose);

    /**
     * Returns the armor stand's right arm's current pose as a
     * {@link EulerAngle}.
     *
     * @return the current pose
     */
    @NonNull
    EulerAngle getRightArmPose();

    /**
     * Sets the armor stand's right arm's current pose as a
     * {@link EulerAngle}.
     *
     * @param pose the current pose
     */
    void setRightArmPose(@NonNull EulerAngle pose);

    /**
     * Returns the armor stand's left leg's current pose as a
     * {@link EulerAngle}.
     *
     * @return the current pose
     */
    @NonNull
    EulerAngle getLeftLegPose();

    /**
     * Sets the armor stand's left leg's current pose as a
     * {@link EulerAngle}.
     *
     * @param pose the current pose
     */
    void setLeftLegPose(@NonNull EulerAngle pose);

    /**
     * Returns the armor stand's right leg's current pose as a
     * {@link EulerAngle}.
     *
     * @return the current pose
     */
    @NonNull
    EulerAngle getRightLegPose();

    /**
     * Sets the armor stand's right leg's current pose as a
     * {@link EulerAngle}.
     *
     * @param pose the current pose
     */
    void setRightLegPose(@NonNull EulerAngle pose);

    /**
     * Returns the armor stand's head's current pose as a
     * {@link EulerAngle}.
     *
     * @return the current pose
     */
    @NonNull
    EulerAngle getHeadPose();

    /**
     * Sets the armor stand's head's current pose as a
     * {@link EulerAngle}.
     *
     * @param pose the current pose
     */
    void setHeadPose(@NonNull EulerAngle pose);

    /**
     * Returns whether the armor stand has a base plate.
     *
     * @return whether it has a base plate
     */
    boolean hasBasePlate();

    /**
     * Sets whether the armor stand has a base plate.
     *
     * @param basePlate whether is has a base plate
     */
    void setBasePlate(boolean basePlate);

    /**
     * Returns whether the armor stand should be visible or not.
     *
     * @return whether the stand is visible or not
     */
    boolean isVisible();

    /**
     * Sets whether the armor stand should be visible or not.
     *
     * @param visible whether the stand is visible or not
     */
    void setVisible(boolean visible);

    /**
     * Returns whether this armor stand has arms.
     *
     * @return whether this has arms or not
     */
    boolean hasArms();

    /**
     * Sets whether this armor stand has arms.
     *
     * @param arms whether this has arms or not
     */
    void setArms(boolean arms);

    /**
     * Returns whether this armor stand is scaled down.
     *
     * @return whether this is scaled down
     */
    boolean isSmall();

    /**
     * Sets whether this armor stand is scaled down.
     *
     * @param small whether this is scaled down
     */
    void setSmall(boolean small);

    /**
     * Returns whether this armor stand is a marker, meaning it has a very small
     * collision box.
     *
     * @return whether this is a marker
     */
    boolean isMarker();

    /**
     * Sets whether this armor stand is a marker, meaning it has a very small
     * collision box.
     *
     * @param marker whether this is a marker
     */
    void setMarker(boolean marker);

    /**
     * Locks the equipment slot with the specified
     * {@link LockType locking mechanism}.
     *
     * @param slot the equipment slot to lock
     * @param lockType the LockType to lock the equipment slot with
     */
    void addEquipmentLock(@NonNull EquipmentSlot slot, @NonNull LockType lockType);

    /**
     * Remove a {@link LockType locking mechanism}.
     *
     * @param slot the equipment slot to change
     * @param lockType the LockType to remove
     */
    void removeEquipmentLock(@NonNull EquipmentSlot slot, @NonNull LockType lockType);

    /**
     * Returns if the ArmorStand has the specified
     * {@link LockType locking mechanism}.
     *
     * @param slot the EquipmentSlot to test
     * @param lockType the LockType to test
     * @return if the ArmorStand has been locked with the parameters specified
     */
    boolean hasEquipmentLock(@NonNull EquipmentSlot slot, @NonNull LockType lockType);

    /**
     * Represents types of locking mechanisms for ArmorStand equipment.
     */
    enum LockType {

        /**
         * Prevents adding or changing the respective equipment - players cannot
         * replace the empty slot with a new item or swap the items between
         * themselves and the ArmorStand.
         */
        ADDING_OR_CHANGING,
        /**
         * Prevents removing or changing the respective equipment - players
         * cannot take an item from the slot or swap the items between
         * themselves and the ArmorStand.
         */
        REMOVING_OR_CHANGING,
        /**
         * Prevents adding the respective equipment - players cannot replace the
         * empty slot with a new item, but can swap items between themselves and
         * the ArmorStand.
         */
        ADDING
    }
    /**
     * Tests if this armor stand can move.
     *
     * <p>The default value is {@code true}.</p>
     *
     * @return {@code true} if this armour stand can move, {@code false} otherwise
     */
    boolean canMove();

    /**
     * Sets if this armor stand can move.
     *
     * @param move {@code true} if this armour stand can move, {@code false} otherwise
     */
    void setCanMove(boolean move);

    @Override
    @NonNull EntityEquipment getEquipment();

    /**
     * Tests if this armor stand can tick.
     *
     * <p>The default value is defined in {@code paper.yml}.</p>
     *
     * @return {@code true} if this armour stand can tick, {@code false} otherwise
     */
    boolean canTick();

    /**
     * Sets if this armor stand can tick.
     *
     * @param tick {@code true} if this armour stand can tick, {@code false} otherwise
     */
    void setCanTick(final boolean tick);

    /**
     * Returns the item the armor stand has
     * equip in the given equipment slot
     *
     * @param slot the equipment slot to get
     * @return the ItemStack in the equipment slot
     */
    @NonNull
    ItemStack getItem(@NonNull final EquipmentSlot slot);

    /**
     * Sets the item the armor stand has
     * equip in the given equipment slot
     *
     * @param slot the equipment slot to set
     * @param item the item to hold
     */
    void setItem(@NonNull final EquipmentSlot slot, @Nullable final ItemStack item);

    /**
     * Get the list of disabled slots
     *
     * @return list of disabled slots
     */
    @NonNull
    Set<EquipmentSlot> getDisabledSlots();

    /**
     * Set the disabled slots
     *
     * This makes it so a player is unable to interact with the Armor Stand to place, remove, or replace an item in the given slot(s)
     * Note: Once a slot is disabled, the only way to get an item back it to break the armor stand.
     *
     * @param slots var-arg array of slots to lock
     */
    void setDisabledSlots(@NonNull EquipmentSlot... slots);

    /**
     * Disable specific slots, adding them
     * to the currently disabled slots
     *
     * This makes it so a player is unable to interact with the Armor Stand to place, remove, or replace an item in the given slot(s)
     * Note: Once a slot is disabled, the only way to get an item back it to break the armor stand.
     *
     * @param slots var-arg array of slots to lock
     */
    void addDisabledSlots(@NonNull final EquipmentSlot... slots);

    /**
     * Remove the given slots from the disabled
     * slots list, enabling them.
     *
     * This makes it so a player is able to interact with the Armor Stand to place, remove, or replace an item in the given slot(s)
     *
     * @param slots var-arg array of slots to unlock
     */
    void removeDisabledSlots(@NonNull final EquipmentSlot... slots);

    /**
     * Check if a specific slot is disabled
     *
     * @param slot The slot to check
     * @return {@code true} if the slot is disabled, else {@code false}.
     */
    boolean isSlotDisabled(@NonNull EquipmentSlot slot);

    /**
     * Returns the ArmorStand's body rotations as
     * {@link Rotations}.
     *
     * @return the current rotations
     */
    @NonNull Rotations getBodyRotations();

    /**
     * Sets the ArmorStand's body rotations as
     * {@link Rotations}.
     *
     * @param rotations the current rotations
     */
    void setBodyRotations(@NonNull Rotations rotations);

    /**
     * Returns the ArmorStand's left arm rotations as
     * {@link Rotations}.
     *
     * @return the current rotations
     */
    @NonNull Rotations getLeftArmRotations();

    /**
     * Sets the ArmorStand's left arm rotations as
     * {@link Rotations}.
     *
     * @param rotations the current rotations
     */
    void setLeftArmRotations(@NonNull Rotations rotations);

    /**
     * Returns the ArmorStand's right arm rotations as
     * {@link Rotations}.
     *
     * @return the current rotations
     */
    @NonNull Rotations getRightArmRotations();

    /**
     * Sets the ArmorStand's right arm rotations as
     * {@link Rotations}.
     *
     * @param rotations the current rotations
     */
    void setRightArmRotations(@NonNull Rotations rotations);

    /**
     * Returns the ArmorStand's left leg rotations as
     * {@link Rotations}.
     *
     * @return the current rotations
     */
    @NonNull Rotations getLeftLegRotations();

    /**
     * Sets the ArmorStand's left leg rotations as
     * {@link Rotations}.
     *
     * @param rotations the current rotations
     */
    void setLeftLegRotations(@NonNull Rotations rotations);

    /**
     * Returns the ArmorStand's right leg rotations as
     * {@link Rotations}.
     *
     * @return the current rotations
     */
    @NonNull Rotations getRightLegRotations();

    /**
     * Sets the ArmorStand's right leg rotations as
     * {@link Rotations}.
     *
     * @param rotations the current rotations
     */
    void setRightLegRotations(@NonNull Rotations rotations);

    /**
     * Returns the ArmorStand's head rotations as
     * {@link Rotations}.
     *
     * @return the current rotations
     */
    @NonNull Rotations getHeadRotations();

    /**
     * Sets the ArmorStand's head rotations as
     * {@link Rotations}.
     *
     * @param rotations the current rotations
     */
    void setHeadRotations(@NonNull Rotations rotations);
}

