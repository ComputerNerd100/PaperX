package io.papermc.paper.api.entity;

import io.papermc.paper.api.block.color.DyeColor;
import io.papermc.paper.api.namespace.Keyed;
import io.papermc.paper.api.namespace.NamespacedKey;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Meow.
 */
public interface Cat extends Tameable, Sittable, CollarColorable {

    /**
     * Gets the current type of this cat.
     *
     * @return Type of the cat.
     */
    @NonNull
    Type getCatType();

    /**
     * Sets the current type of this cat.
     *
     * @param type New type of this cat.
     */
    void setCatType(@NonNull Type type);

    /**
     * Get the collar color of this cat
     *
     * @return the color of the collar
     */
    @NonNull
    @Override
    public DyeColor getCollarColor();

    /**
     * Set the collar color of this cat
     *
     * @param color the color to apply
     */
    @Override
    void setCollarColor(@NonNull DyeColor color);

    /**
     * Represents the various different cat types there are.
     */
    enum Type implements Keyed {
        TABBY,
        BLACK,
        RED,
        SIAMESE,
        BRITISH_SHORTHAIR,
        CALICO,
        PERSIAN,
        RAGDOLL,
        WHITE,
        JELLIE,
        ALL_BLACK;

        // Paper start
        private final NamespacedKey key;

        Type() {
            this.key = NamespacedKey.minecraft(name().toLowerCase(java.util.Locale.ROOT));
        }

        @NonNull
        @Override
        public NamespacedKey getKey() {
            return key;
        }
    }

    /**
     * Sets if the cat is lying down.
     * This is visual and does not affect the behaviour of the cat.
     *
     * @param lyingDown whether the cat should lie down
     */
    void setLyingDown(boolean lyingDown);

    /**
     * Gets if the cat is lying down.
     *
     * @return whether the cat is lying down
     */
   boolean isLyingDown();

    /**
     * Sets if the cat has its head up.
     * This is visual and does not affect the behaviour of the cat.
     *
     * @param headUp head is up
     */
    void setHeadUp(boolean headUp);

    /**
     * Gets if the cat has its head up.
     *
     * @return head is up
     */
    boolean isHeadUp();
}

