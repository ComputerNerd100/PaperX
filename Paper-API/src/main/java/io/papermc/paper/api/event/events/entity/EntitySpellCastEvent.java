package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Spellcaster;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a {@link Spellcaster} casts a spell.
 */
public interface EntitySpellCastEvent extends CancellableEntityEvent {
    default Spellcaster spellcaster() {
        return (Spellcaster) entity();
    }

    /**
     * Get the spell to be cast in this event.
     *
     * This is a convenience method equivalent to
     * {@link Spellcaster#getSpell()}.
     *
     * @return the spell to cast
     */
    @Param(1)
    Spellcaster.Spell spell();
}
