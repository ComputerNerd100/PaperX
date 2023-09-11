package io.papermc.paper.api.entity;

import net.kyori.adventure.bossbar.BossBar;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents the Boss Entity.
 */
public interface Boss extends Entity {

    /**
     * Returns the {@link BossBar} of the {@link Boss}
     *
     * @return the {@link BossBar} of the entity
     */
    @Nullable
    BossBar getBossBar();
}

