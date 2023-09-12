package io.papermc.paper.api.command;

import io.papermc.paper.api.Paper;
import io.papermc.paper.api.Server;
import io.papermc.paper.api.permisson.Permission;
import io.papermc.paper.api.permisson.PermissionAttachment;
import io.papermc.paper.api.permisson.PermissionAttachmentInfo;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Set;
import java.util.UUID;

/**
 * For when all you care about is just messaging
 */
public interface MessageCommandSender extends CommandSender {

    @Override
    default void sendMessage(@NonNull String[] messages) {
        for (String message : messages) {
            sendMessage(message);
        }
    }

    @Override
    default void sendMessage(@Nullable UUID sender, @NonNull String message) {
        sendMessage(message);
    }

    @Override
    default void sendMessage(@Nullable UUID sender, @NonNull String[] messages) {
        for (String message : messages) {
            sendMessage(message);
        }
    }

    @NonNull
    @Override
    default Server getServer() {
        return Paper.getServer();
    }

    @Override
    default net.kyori.adventure.text.@NonNull Component name() {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    default String getName() {
        throw new UnsupportedOperationException();
    }

    @Override
    default boolean isOp() {
        throw new UnsupportedOperationException();
    }

    @Override
    default void setOp(boolean value) {
        throw new UnsupportedOperationException();
    }

    @Override
    default boolean isPermissionSet(@NonNull String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    default boolean isPermissionSet(@NonNull Permission perm) {
        throw new UnsupportedOperationException();
    }

    @Override
    default boolean hasPermission(@NonNull String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    default boolean hasPermission(@NonNull Permission perm) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    default PermissionAttachment addAttachment(@NonNull Plugin plugin, @NonNull String name, boolean value) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    default PermissionAttachment addAttachment(@NonNull Plugin plugin) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    default PermissionAttachment addAttachment(@NonNull Plugin plugin, @NonNull String name, boolean value, int ticks) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    default PermissionAttachment addAttachment(@NonNull Plugin plugin, int ticks) {
        throw new UnsupportedOperationException();
    }

    @Override
    default void removeAttachment(@NonNull PermissionAttachment attachment) {
        throw new UnsupportedOperationException();
    }

    @Override
    default void recalculatePermissions() {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    default Set<PermissionAttachmentInfo> getEffectivePermissions() {
        throw new UnsupportedOperationException();
    }
}

