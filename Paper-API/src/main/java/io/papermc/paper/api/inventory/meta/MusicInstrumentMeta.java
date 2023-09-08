package io.papermc.paper.api.inventory.meta;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;


public interface MusicInstrumentMeta extends ItemMeta {

    /**
     * Sets the goat horn's instrument.
     *
     * @param instrument the instrument to set
     */
    void setInstrument(@Nullable MusicInstrument instrument);

    /**
     * Gets the instrument of the goat horn.
     *
     * @return The instrument of the goat horn
     */
    @Nullable
    MusicInstrument getInstrument();

    @Override
    @NonNull
    MusicInstrumentMeta clone();
}
