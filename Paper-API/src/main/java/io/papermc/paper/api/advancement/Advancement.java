package io.papermc.paper.api.advancement;

import io.papermc.paper.api.namespace.Keyed;
import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Collection;

public interface Advancement extends Keyed {
    /**
     * Get all the criteria present in this advancement.
     *
     * @return a unmodifiable copy of all criteria
     */
    @NonNull
    Collection<String> getCriteria();

    /**
     * Get the display info of this advancement.
     * <p>
     * Will be {@code null} when totally hidden, for example with crafting
     * recipes.
     *
     * @return the display info
     */
    @Nullable
    AdvancementDisplay getDisplay();

    /**
     * Gets the formatted display name for this display. This
     * is part of the component that would be shown in chat when a player
     * completes the advancement. Will return the same as
     * {@link AdvancementDisplay#displayName()} when an
     * {@link AdvancementDisplay} is present.
     *
     * @return the display name
     * @see AdvancementDisplay#displayName()
     */
    @NonNull Component displayName();

    /**
     * Gets the parent advancement, if any.
     *
     * @return the parent advancement
     */
    @Nullable
    Advancement getParent();

    /**
     * Gets all the direct children advancements.
     *
     * @return the children advancements
     */
    @NonNull
    @Unmodifiable
    Collection<Advancement> getChildren();

    /**
     * Gets the root advancement of the tree this is located in.
     *
     * @return the root advancement
     */
    @NonNull
    Advancement getRoot();
}
