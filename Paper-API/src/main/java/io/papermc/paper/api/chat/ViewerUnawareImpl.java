package io.papermc.paper.api.chat;

import io.papermc.paper.api.entity.Player;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

sealed class ViewerUnawareImpl implements ChatRenderer, ChatRenderer.ViewerUnaware permits ViewerUnawareImpl.Default {
    private final ViewerUnaware unaware;
    private @Nullable Component message;

    ViewerUnawareImpl(final ViewerUnaware unaware) {
        this.unaware = unaware;
    }

    @Override
    public @NonNull Component render(final @NonNull Player source, final @NonNull Component sourceDisplayName, final @NonNull Component message, final @NonNull Audience viewer) {
        return this.render(source, sourceDisplayName, message);
    }

    @Override
    public @NonNull Component render(final @NonNull Player source, final @NonNull Component sourceDisplayName, final @NonNull Component message) {
        if (this.message == null) {
            this.message = this.unaware.render(source, sourceDisplayName, message);
        }
        return this.message;
    }

    static final class Default extends ViewerUnawareImpl implements ChatRenderer.Default {
        Default(final ViewerUnaware unaware) {
            super(unaware);
        }
    }
}
