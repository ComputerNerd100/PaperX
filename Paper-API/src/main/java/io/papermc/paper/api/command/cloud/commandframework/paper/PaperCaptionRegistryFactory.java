package io.papermc.paper.api.command.cloud.commandframework.paper;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Factory creating {@link PaperCaptionRegistry} instances
 *
 * @param <C> Command sender type
 */
public final class PaperCaptionRegistryFactory<C> {

    /**
     * Create a new bukkit caption registry instance
     *
     * @return Created instance
     */
    public @NonNull PaperCaptionRegistry<C> create() {
        return new PaperCaptionRegistry<>();
    }
}

