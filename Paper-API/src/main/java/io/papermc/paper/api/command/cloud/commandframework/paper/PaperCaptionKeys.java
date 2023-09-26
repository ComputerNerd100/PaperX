package io.papermc.paper.api.command.cloud.commandframework.paper;

import cloud.commandframework.captions.Caption;
import org.apiguardian.api.API;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * {@link Caption} instances for messages in cloud-bukkit
 */
public final class PaperCaptionKeys {

    private static final Collection<Caption> RECOGNIZED_CAPTIONS = new LinkedList<>();

    /**
     * Variables: {input}
     */
    public static final Caption ARGUMENT_PARSE_FAILURE_ENCHANTMENT = of("argument.parse.failure.enchantment");
    /**
     * Variables: {input}
     */
    public static final Caption ARGUMENT_PARSE_FAILURE_MATERIAL = of("argument.parse.failure.material");
    /**
     * Variables: {input}
     */
    public static final Caption ARGUMENT_PARSE_FAILURE_OFFLINEPLAYER = of("argument.parse.failure.offlineplayer");
    /**
     * Variables: {input}
     */
    public static final Caption ARGUMENT_PARSE_FAILURE_PLAYER = of("argument.parse.failure.player");
    /**
     * Variables: {input}
     */
    public static final Caption ARGUMENT_PARSE_FAILURE_WORLD = of("argument.parse.failure.world");
    /**
     * Variables: {input}
     *
     * @deprecated parsing is now handled by Brigadier and will throw {@link com.mojang.brigadier.exceptions.CommandSyntaxException} instead.
     */
    @API(status = API.Status.DEPRECATED, since = "1.8.0")
    @Deprecated
    public static final Caption ARGUMENT_PARSE_FAILURE_SELECTOR_MALFORMED = of("argument.parse.failure.selector.malformed");
    /**
     * Variables: None
     */
    public static final Caption ARGUMENT_PARSE_FAILURE_SELECTOR_UNSUPPORTED = of("argument.parse.failure.selector.unsupported");
    /**
     * Variables: None
     *
     * @deprecated parsing is now handled by Brigadier and will throw {@link com.mojang.brigadier.exceptions.CommandSyntaxException} instead.
     */
    @API(status = API.Status.DEPRECATED, since = "1.8.0")
    @Deprecated
    public static final Caption ARGUMENT_PARSE_FAILURE_SELECTOR_TOO_MANY_PLAYERS = of(
            "argument.parse.failure.selector.too_many_players");
    /**
     * Variables: None
     *
     * @deprecated parsing is now handled by Brigadier and will throw {@link com.mojang.brigadier.exceptions.CommandSyntaxException} instead.
     */
    @API(status = API.Status.DEPRECATED, since = "1.8.0")
    @Deprecated
    public static final Caption ARGUMENT_PARSE_FAILURE_SELECTOR_TOO_MANY_ENTITIES = of(
            "argument.parse.failure.selector.too_many_entities");
    /**
     * Variables: None
     *
     * @deprecated parsing is now handled by Brigadier and will throw {@link com.mojang.brigadier.exceptions.CommandSyntaxException} instead.
     */
    @API(status = API.Status.DEPRECATED, since = "1.8.0")
    @Deprecated
    public static final Caption ARGUMENT_PARSE_FAILURE_SELECTOR_NON_PLAYER = of(
            "argument.parse.failure.selector.non_player_in_player_selector");
    /**
     * Variables: {input}
     */
    public static final Caption ARGUMENT_PARSE_FAILURE_LOCATION_INVALID_FORMAT = of(
            "argument.parse.failure.location.invalid_format");
    /**
     * Variables: None
     */
    public static final Caption ARGUMENT_PARSE_FAILURE_LOCATION_MIXED_LOCAL_ABSOLUTE = of(
            "argument.parse.failure.location.mixed_local_absolute");
    /**
     * Variables: {input}
     *
     * @since 1.7.0
     */
    public static final Caption ARGUMENT_PARSE_FAILURE_NAMESPACED_KEY_NAMESPACE =
            of("argument.parse.failure.namespacedkey.namespace");
    /**
     * Variables: {input}
     *
     * @since 1.7.0
     */
    public static final Caption ARGUMENT_PARSE_FAILURE_NAMESPACED_KEY_KEY =
            of("argument.parse.failure.namespacedkey.key");
    /**
     * Variables: {input}
     *
     * @since 1.7.0
     */
    public static final Caption ARGUMENT_PARSE_FAILURE_NAMESPACED_KEY_NEED_NAMESPACE =
            of("argument.parse.failure.namespacedkey.need_namespace");

    private PaperCaptionKeys() {
    }

    private static @NonNull Caption of(final @NonNull String key) {
        final Caption caption = Caption.of(key);
        RECOGNIZED_CAPTIONS.add(caption);
        return caption;
    }

    /**
     * Get an immutable collection containing all standard caption keys
     *
     * @return Immutable collection of keys
     */
    public static @NonNull Collection<@NonNull Caption> getBukkitCaptionKeys() {
        return Collections.unmodifiableCollection(RECOGNIZED_CAPTIONS);
    }
}

