package io.papermc.paper.api.entity;

import org.checkerframework.checker.nullness.qual.Nullable;


/**
 * Represents an Evoker "Illager".
 */
public interface Evoker extends Spellcaster {

    /**
     * @return the sheep being targeted by the {@link Spell#WOLOLO wololo spell}, or {@code null} if none
     */
    @Nullable
    Sheep getWololoTarget();

    /**
     * Set the sheep to be the target of the {@link Spell#WOLOLO wololo spell}, or {@code null} to clear.
     *
     * @param sheep new wololo target
     */
    void setWololoTarget(@Nullable Sheep sheep);
}

