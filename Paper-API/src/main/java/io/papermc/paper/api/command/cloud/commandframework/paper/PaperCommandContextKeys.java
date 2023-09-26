package io.papermc.paper.api.command.cloud.commandframework.paper;

import cloud.commandframework.keys.CloudKey;
import cloud.commandframework.keys.SimpleCloudKey;
import io.leangen.geantyref.TypeToken;
import io.papermc.paper.api.command.CommandSender;

import java.util.Set;

/**
 * Bukkit related {@link cloud.commandframework.context.CommandContext} keys.
 *
 * @since 1.5.0
 */
public final class PaperCommandContextKeys {

    /**
     * Key used to store the Bukkit native {@link CommandSender} in the {@link cloud.commandframework.context.CommandContext}.
     *
     * @since 1.5.0
     */
    public static final CloudKey<CommandSender> PAPER_COMMAND_SENDER = SimpleCloudKey.of(
            "BukkitCommandSender",
            TypeToken.get(CommandSender.class)
    );

    /**
     * Key used to store the active {@link CloudPaperCapabilities} in the {@link cloud.commandframework.context.CommandContext}.
     *
     * @since 1.5.0
     */
    public static final CloudKey<Set<CloudPaperCapabilities>> CLOUD_PAPER_CAPABILITIES = SimpleCloudKey.of(
            "CloudBukkitCapabilities",
            new TypeToken<Set<CloudPaperCapabilities>>() {
            }
    );

    private PaperCommandContextKeys() {
    }
}
