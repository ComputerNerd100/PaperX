package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.sound.Instrument;
import io.papermc.paper.api.sound.Note;

/**
 * Called when a note block is being played through player interaction or a
 * redstone current.
 */
public interface NotePlayEvent extends CancellableBlockEvent {

    /**
     * Gets the {@link Instrument} to be used.
     *
     * @return the Instrument
     */
    @Param(1)
    Instrument instrument();

    /**
     * Gets the {@link Note} to be played.
     *
     * @return the Note
     */
    @Param(2)
    Note note();

}
