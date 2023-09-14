package io.papermc.paper.api.datapack;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collection;

public interface DatapackManager {

    /**
     * @return all the packs known to the server
     */
    @NonNull
    Collection<Datapack> getPacks();

    /**
     * @return all the packs which are currently enabled
     */
    @NonNull
    Collection<Datapack> getEnabledPacks();

}
