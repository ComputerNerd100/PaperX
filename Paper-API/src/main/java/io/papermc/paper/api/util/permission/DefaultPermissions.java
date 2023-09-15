package io.papermc.paper.api.util.permission;

import io.papermc.paper.api.Paper;
import io.papermc.paper.api.permisson.Permission;
import io.papermc.paper.api.permisson.PermissionDefault;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Map;

public final class DefaultPermissions {
    private static final String ROOT = "craftbukkit";
    private static final String LEGACY_PREFIX = "craft";

    private DefaultPermissions() {}

    @NonNull
    public static Permission registerPermission(@NonNull Permission perm) {
        return registerPermission(perm, true);
    }

    @NonNull
    public static Permission registerPermission(@NonNull Permission perm, boolean withLegacy) {
        Permission result = perm;

        try {
            Paper.getPluginManager().addPermission(perm);
        } catch (IllegalArgumentException ex) {
            result = Paper.getPluginManager().getPermission(perm.getName());
            assert result != null;
        }

        if (withLegacy) {
            Permission legacy = new Permission(LEGACY_PREFIX + result.getName(), result.getDescription(), PermissionDefault.FALSE);
            legacy.getChildren().put(result.getName(), true);
            registerPermission(perm, false);
        }

        return result;
    }

    @NonNull
    public static Permission registerPermission(@NonNull Permission perm, @NonNull Permission parent) {
        parent.getChildren().put(perm.getName(), true);
        return registerPermission(perm);
    }

    @NonNull
    public static Permission registerPermission(@NonNull String name, @Nullable String desc) {
        Permission perm = registerPermission(new Permission(name, desc));
        return perm;
    }

    @NonNull
    public static Permission registerPermission(@NonNull String name, @Nullable String desc, @NonNull Permission parent) {
        Permission perm = registerPermission(name, desc);
        parent.getChildren().put(perm.getName(), true);
        return perm;
    }

    @NonNull
    public static Permission registerPermission(@NonNull String name, @Nullable String desc, @Nullable PermissionDefault def) {
        Permission perm = registerPermission(new Permission(name, desc, def));
        return perm;
    }

    @NonNull
    public static Permission registerPermission(@NonNull String name, @Nullable String desc, @Nullable PermissionDefault def, @NonNull Permission parent) {
        Permission perm = registerPermission(name, desc, def);
        parent.getChildren().put(perm.getName(), true);
        return perm;
    }

    @NonNull
    public static Permission registerPermission(@NonNull String name, @Nullable String desc, @Nullable PermissionDefault def, @Nullable Map<String, Boolean> children) {
        Permission perm = registerPermission(new Permission(name, desc, def, children));
        return perm;
    }

    @NonNull
    public static Permission registerPermission(@NonNull String name, @Nullable String desc, @Nullable PermissionDefault def, @Nullable Map<String, Boolean> children, @NonNull Permission parent) {
        Permission perm = registerPermission(name, desc, def, children);
        parent.getChildren().put(perm.getName(), true);
        return perm;
    }

    public static void registerCorePermissions() {
        Permission parent = registerPermission(ROOT, "Gives the user the ability to use all CraftBukkit utilities and commands");

        CommandPermissions.registerPermissions(parent);
        BroadcastPermissions.registerPermissions(parent);

        parent.recalculatePermissibles();
    }
}

