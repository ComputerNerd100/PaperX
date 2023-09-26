package io.papermc.paper.api.command.cloud.commandframework.paper;

import cloud.commandframework.brigadier.argument.WrappedBrigadierParser;
import cloud.commandframework.execution.preprocessor.CommandPreprocessingContext;
import cloud.commandframework.execution.preprocessor.CommandPreprocessor;
import io.papermc.paper.api.command.CommandSender;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Command preprocessor which decorates incoming {@link cloud.commandframework.context.CommandContext}
 * with Bukkit specific objects
 *
 * @param <C> Command sender type
 */
final class PaperCommandPreprocessor<C extends CommandSender> implements CommandPreprocessor<C> {

    private final PaperCommandManager<C> commandManager;
    private final @Nullable BukkitBackwardsBrigadierSenderMapper<C, ?> mapper;

    /**
     * The Bukkit Command Preprocessor for storing Bukkit-specific contexts in the command contexts
     *
     * @param commandManager The BukkitCommandManager
     */
    PaperCommandPreprocessor(final @NonNull PaperCommandManager<C> commandManager) {
        this.commandManager = commandManager;

        if (this.commandManager.hasCapability(CloudPaperCapabilities.NATIVE_BRIGADIER)) {
            this.mapper = new BukkitBackwardsBrigadierSenderMapper<>(this.commandManager);
        } else {
            this.mapper = null;
        }
    }

    @Override
    public void accept(final @NonNull CommandPreprocessingContext<C> context) {
        if (this.mapper != null) {
            // If the server is Brigadier capable but the Brigadier manager has not been registered, store the native
            // sender in context manually so that getting suggestions from WrappedBrigadierParser works like expected.
            if (!context.getCommandContext().contains(WrappedBrigadierParser.COMMAND_CONTEXT_BRIGADIER_NATIVE_SENDER)) {
                context.getCommandContext().store(
                        WrappedBrigadierParser.COMMAND_CONTEXT_BRIGADIER_NATIVE_SENDER,
                        this.mapper.apply(context.getCommandContext().getSender())
                );
            }
        }
        context.getCommandContext().store(
                PaperCommandContextKeys.PAPER_COMMAND_SENDER,
                this.commandManager.getBackwardsCommandSenderMapper().apply(context.getCommandContext().getSender())
        );
        context.getCommandContext().store(
                PaperCommandContextKeys.CLOUD_PAPER_CAPABILITIES,
                this.commandManager.queryCapabilities()
        );
    }
}

