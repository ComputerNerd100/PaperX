package io.papermc.paper.api.util;

import io.papermc.paper.api.Paper;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface VersionFetcher {
    /**
     * Amount of time to cache results for in milliseconds
     * <p>
     * Negative values will never cache.
     *
     * @return cache time
     */
    long getCacheTime();

    /**
     * Gets the version message to cache and show to command senders.
     *
     * <p>NOTE: This is run in a new thread separate from that of the command processing thread</p>
     *
     * @param serverVersion the current version of the server (will match {@link Paper#getVersion()})
     * @return the message to show when requesting a version
     */
    @NonNull
    Component getVersionMessage(@NonNull String serverVersion);

    class DummyVersionFetcher implements VersionFetcher {

        @Override
        public long getCacheTime() {
            return -1;
        }

        @NonNull
        @Override
        public Component getVersionMessage(@NonNull String serverVersion) {
            Paper.getLogger().warning("Version provider has not been set, cannot check for updates!");
            Paper.getLogger().info("Override the default implementation of org.bukkit.UnsafeValues#getVersionFetcher()");
            new Throwable().printStackTrace();
            return Component.text("Unable to check for updates. No version provider set.", NamedTextColor.RED);
        }
    }
}

