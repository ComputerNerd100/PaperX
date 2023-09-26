package io.papermc.paper.api.permisson;

import io.papermc.paper.api.Paper;
import io.papermc.paper.api.plugin.Plugin;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;
import java.util.logging.Level;

/**
 * Base Permissible for use in any Permissible object via proxy or extension
 */
public class PermissibleBase implements Permissible {
    private final ServerOperator opable;
    private final Permissible parent;
    private final List<PermissionAttachment> attachments = new LinkedList<PermissionAttachment>();
    private final Map<String, PermissionAttachmentInfo> permissions = new HashMap<String, PermissionAttachmentInfo>();

    public PermissibleBase(@Nullable ServerOperator opable) {
        this.opable = opable;
        this.parent = (opable instanceof Permissible) ? (Permissible) opable : this;

        recalculatePermissions();
    }

    @Override
    public boolean isOp() {
        if (opable == null) {
            return false;
        } else {
            return opable.isOp();
        }
    }

    @Override
    public void setOp(boolean value) {
        if (opable == null) {
            throw new UnsupportedOperationException("Cannot change op value as no ServerOperator is set");
        } else {
            opable.setOp(value);
        }
    }

    @Override
    public boolean isPermissionSet(@NonNull String name) {
        if (name == null) {
            throw new IllegalArgumentException("Permission name cannot be null");
        }

        return permissions.containsKey(name.toLowerCase(java.util.Locale.ENGLISH));
    }

    @Override
    public boolean isPermissionSet(@NonNull Permission perm) {
        if (perm == null) {
            throw new IllegalArgumentException("Permission cannot be null");
        }

        return isPermissionSet(perm.getName());
    }

    @Override
    public boolean hasPermission(@NonNull String inName) {
        if (inName == null) {
            throw new IllegalArgumentException("Permission name cannot be null");
        }

        String name = inName.toLowerCase(java.util.Locale.ENGLISH);

        // Paper start
        PermissionAttachmentInfo info = permissions.get(name);
        if (info != null) {
            return info.getValue();
            // Paper end
        } else {
            Permission perm = Paper.getServer().getPluginManager().getPermission(name);

            if (perm != null) {
                return perm.getDefault().getValue(isOp());
            } else {
                return Permission.DEFAULT_PERMISSION.getValue(isOp());
            }
        }
    }

    @Override
    public boolean hasPermission(@NonNull Permission perm) {
        if (perm == null) {
            throw new IllegalArgumentException("Permission cannot be null");
        }

        String name = perm.getName().toLowerCase(java.util.Locale.ENGLISH);

        // Paper start
        PermissionAttachmentInfo info = permissions.get(name);
        if (info != null) {
            return info.getValue();
        }
        // Paper end
        return perm.getDefault().getValue(isOp());
    }

    @Override
    @NonNull
    public synchronized PermissionAttachment addAttachment(@NonNull Plugin plugin, @NonNull String name, boolean value) {
        if (name == null) {
            throw new IllegalArgumentException("Permission name cannot be null");
        } else if (plugin == null) {
            throw new IllegalArgumentException("Plugin cannot be null");
        } else if (!plugin.enabled()) {
            throw new IllegalArgumentException("Plugin " + plugin.description().getFullName() + " is disabled");
        }

        PermissionAttachment result = addAttachment(plugin);
        result.setPermission(name, value);

        recalculatePermissions();

        return result;
    }

    @Override
    @NonNull
    public synchronized PermissionAttachment addAttachment(@NonNull Plugin plugin) {
        if (plugin == null) {
            throw new IllegalArgumentException("Plugin cannot be null");
        } else if (!plugin.enabled()) {
            throw new IllegalArgumentException("Plugin " + plugin.description().getFullName() + " is disabled");
        }

        PermissionAttachment result = new PermissionAttachment(plugin, parent);

        attachments.add(result);
        recalculatePermissions();

        return result;
    }

    @Override
    public synchronized void removeAttachment(@NonNull PermissionAttachment attachment) {
        if (attachment == null) {
            throw new IllegalArgumentException("Attachment cannot be null");
        }

        if (attachments.remove(attachment)) {
            PermissionRemovedExecutor ex = attachment.getRemovalCallback();

            if (ex != null) {
                ex.attachmentRemoved(attachment);
            }

            recalculatePermissions();
        } else {
            throw new IllegalArgumentException("Given attachment is not part of Permissible object " + parent);
        }
    }

    @Override
    public synchronized void recalculatePermissions() { // Paper - synchronized
        clearPermissions();
        Set<Permission> defaults = Paper.getServer().pluginManager().getDefaultPermissions(isOp());
        Paper.getServer().pluginManager().subscribeToDefaultPerms(isOp(), parent);

        for (Permission perm : defaults) {
            String name = perm.getName().toLowerCase(java.util.Locale.ENGLISH);
            permissions.put(name, new PermissionAttachmentInfo(parent, name, null, true));
            Paper.getServer().pluginManager().subscribeToPermission(name, parent);
            calculateChildPermissions(perm.getChildren(), false, null);
        }

        for (PermissionAttachment attachment : attachments) {
            calculateChildPermissions(attachment.getPermissions(), false, attachment);
        }
    }

    public synchronized void clearPermissions() {
        Set<String> perms = permissions.keySet();

        for (String name : perms) {
            Paper.getServer().pluginManager().unsubscribeFromPermission(name, parent);
        }

        Paper.getServer().pluginManager().unsubscribeFromDefaultPerms(false, parent);
        Paper.getServer().pluginManager().unsubscribeFromDefaultPerms(true, parent);

        permissions.clear();
    }

    private void calculateChildPermissions(@NonNull Map<String, Boolean> children, boolean invert, @Nullable PermissionAttachment attachment) {
        for (Map.Entry<String, Boolean> entry : children.entrySet()) {
            String name = entry.getKey();

            Permission perm = Paper.getServer().pluginManager().getPermission(name);
            boolean value = entry.getValue() ^ invert;
            String lname = name.toLowerCase(java.util.Locale.ENGLISH);

            permissions.put(lname, new PermissionAttachmentInfo(parent, lname, attachment, value));
            Paper.getServer().pluginManager().subscribeToPermission(name, parent);

            if (perm != null) {
                calculateChildPermissions(perm.getChildren(), !value, attachment);
            }
        }
    }

    @Override
    @Nullable
    public synchronized PermissionAttachment addAttachment(@NonNull Plugin plugin, @NonNull String name, boolean value, int ticks) {
        if (name == null) {
            throw new IllegalArgumentException("Permission name cannot be null");
        } else if (plugin == null) {
            throw new IllegalArgumentException("Plugin cannot be null");
        } else if (!plugin.enabled()) {
            throw new IllegalArgumentException("Plugin " + plugin.description().getFullName() + " is disabled");
        }

        PermissionAttachment result = addAttachment(plugin, ticks);

        if (result != null) {
            result.setPermission(name, value);
        }

        return result;
    }

    @Override
    @Nullable
    public synchronized PermissionAttachment addAttachment(@NonNull Plugin plugin, int ticks) {
        if (plugin == null) {
            throw new IllegalArgumentException("Plugin cannot be null");
        } else if (!plugin.enabled()) {
            throw new IllegalArgumentException("Plugin " + plugin.description().getFullName() + " is disabled");
        }

        PermissionAttachment result = addAttachment(plugin);

        if (Paper.getServer().scheduler().scheduleSyncDelayedTask(plugin, new RemoveAttachmentRunnable(result), ticks) == -1) {
            Paper.getServer().logger().log(Level.WARNING, "Could not add PermissionAttachment to " + parent + " for plugin " + plugin.description().getFullName() + ": Scheduler returned -1");
            result.remove();
            return null;
        } else {
            return result;
        }
    }

    @Override
    @NonNull
    public synchronized Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return new HashSet<PermissionAttachmentInfo>(permissions.values());
    }

    private static class RemoveAttachmentRunnable implements Runnable {
        private final PermissionAttachment attachment;

        public RemoveAttachmentRunnable(@NonNull PermissionAttachment attachment) {
            this.attachment = attachment;
        }

        @Override
        public void run() {
            attachment.remove();
        }
    }
}

