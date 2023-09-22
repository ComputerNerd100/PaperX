package io.papermc.paper.api.util;

import io.papermc.paper.api.Server;
import io.papermc.paper.api.event.events.server.ServerListPingEvent;
import org.jetbrains.annotations.Nullable;

/**
 * This is a cached version of a server-icon. Its internal representation
 * and implementation is undefined.
 *
 * @see Server#getServerIcon()
 * @see Server#loadServerIcon(java.awt.image.BufferedImage)
 * @see Server#loadServerIcon(java.io.File)
 * @see ServerListPingEvent#setServerIcon(CachedServerIcon)
 */
public interface CachedServerIcon {
    @Nullable String getData();
    default boolean isEmpty() {
        return getData() == null;
    }
}

