package io.papermc.paper.api.datapack;

import org.checkerframework.checker.nullness.qual.NonNull;

public interface Datapack {

    /**
     * @return the name of the pack
     */
    @NonNull
    String getName();

    /**
     * @return the compatibility of the pack
     */
    @NonNull
    Compatibility getCompatibility();

    /**
     * @return whether or not the pack is currently enabled
     */
    boolean isEnabled();

    void setEnabled(boolean enabled);

    enum Compatibility {
        TOO_OLD,
        TOO_NEW,
        COMPATIBLE,
    }

}

