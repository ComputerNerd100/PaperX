package io.papermc.paper.api.brigadier;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.suggestion.SuggestionProvider;

import java.util.function.Predicate;

/**
 * Brigadier {@link Command}, {@link SuggestionProvider}, and permission checker for Bukkit {@link Command}s.
 *
 * @param <S> command source type
 */
public interface PaperBrigadierCommand<S extends PaperBrigadierCommandSource> extends Command<S>, Predicate<S>, SuggestionProvider<S> {
}

