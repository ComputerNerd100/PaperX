package io.papermc.paper.api.command.cloud.commandframework.paper;

import cloud.commandframework.captions.SimpleCaptionRegistry;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import org.apiguardian.api.API;

/**
 * Caption registry that uses bi-functions to produce messages
 *
 * @param <C> Command sender type
 */
public class PaperCaptionRegistry<C> extends SimpleCaptionRegistry<C> {

    /**
     * Default caption for {@link PaperCaptionKeys#ARGUMENT_PARSE_FAILURE_ENCHANTMENT}
     */
    public static final String ARGUMENT_PARSE_FAILURE_ENCHANTMENT = "'{input}' is not a valid enchantment";
    /**
     * Default caption for {@link PaperCaptionKeys#ARGUMENT_PARSE_FAILURE_MATERIAL}
     */
    public static final String ARGUMENT_PARSE_FAILURE_MATERIAL = "'{input}' is not a valid material name";
    /**
     * Default caption for {@link PaperCaptionKeys#ARGUMENT_PARSE_FAILURE_OFFLINEPLAYER}
     */
    public static final String ARGUMENT_PARSE_FAILURE_OFFLINEPLAYER = "No player found for input '{input}'";
    /**
     * Default caption for {@link PaperCaptionKeys#ARGUMENT_PARSE_FAILURE_PLAYER}
     */
    public static final String ARGUMENT_PARSE_FAILURE_PLAYER = "No player found for input '{input}'";
    /**
     * Default caption for {@link PaperCaptionKeys#ARGUMENT_PARSE_FAILURE_WORLD}
     */
    public static final String ARGUMENT_PARSE_FAILURE_WORLD = "'{input}' is not a valid Minecraft world";
    /**
     * Default caption for {@link PaperCaptionKeys#ARGUMENT_PARSE_FAILURE_SELECTOR_MALFORMED}
     *
     * @deprecated parsing is now handled by Brigadier and will throw {@link CommandSyntaxException} instead.
     */
    @API(status = API.Status.DEPRECATED, since = "1.8.0")
    @Deprecated
    public static final String ARGUMENT_PARSE_FAILURE_SELECTOR_MALFORMED = "Selector '{input}' is malformed.";
    /**
     * Default caption for {@link PaperCaptionKeys#ARGUMENT_PARSE_FAILURE_SELECTOR_UNSUPPORTED}
     */
    public static final String ARGUMENT_PARSE_FAILURE_SELECTOR_UNSUPPORTED =
            "Entity selector argument type not supported below Minecraft 1.13.";
    /**
     * Default caption for {@link PaperCaptionKeys#ARGUMENT_PARSE_FAILURE_SELECTOR_TOO_MANY_PLAYERS}
     *
     * @deprecated parsing is now handled by Brigadier and will throw {@link CommandSyntaxException} instead.
     */
    @API(status = API.Status.DEPRECATED, since = "1.8.0")
    @Deprecated
    public static final String ARGUMENT_PARSE_FAILURE_SELECTOR_TOO_MANY_PLAYERS = "More than 1 player selected in single player selector";
    /**
     * Default caption for {@link PaperCaptionKeys#ARGUMENT_PARSE_FAILURE_SELECTOR_TOO_MANY_ENTITIES}
     *
     * @deprecated parsing is now handled by Brigadier and will throw {@link CommandSyntaxException} instead.
     */
    @API(status = API.Status.DEPRECATED, since = "1.8.0")
    @Deprecated
    public static final String ARGUMENT_PARSE_FAILURE_SELECTOR_TOO_MANY_ENTITIES = "More than 1 entity selected in single entity selector.";
    /**
     * Default caption for {@link PaperCaptionKeys#ARGUMENT_PARSE_FAILURE_SELECTOR_NON_PLAYER}
     *
     * @deprecated parsing is now handled by Brigadier and will throw {@link CommandSyntaxException} instead.
     */
    @API(status = API.Status.DEPRECATED, since = "1.8.0")
    @Deprecated
    public static final String ARGUMENT_PARSE_FAILURE_SELECTOR_NON_PLAYER = "Non-player(s) selected in player selector.";
    /**
     * Default caption for {@link PaperCaptionKeys#ARGUMENT_PARSE_FAILURE_LOCATION_INVALID_FORMAT}
     */
    public static final String ARGUMENT_PARSE_FAILURE_LOCATION_INVALID_FORMAT =
            "'{input}' is not a valid location. Required format is '<x> <y> <z>'";
    /**
     * Default caption for {@link PaperCaptionKeys#ARGUMENT_PARSE_FAILURE_LOCATION_MIXED_LOCAL_ABSOLUTE}
     */
    public static final String ARGUMENT_PARSE_FAILURE_LOCATION_MIXED_LOCAL_ABSOLUTE =
            "Cannot mix local and absolute coordinates. (either all coordinates use '^' or none do)";
    /**
     * Default caption for {@link PaperCaptionKeys#ARGUMENT_PARSE_FAILURE_NAMESPACED_KEY_NAMESPACE}
     *
     * @since 1.7.0
     */
    public static final String ARGUMENT_PARSE_FAILURE_NAMESPACED_KEY_NAMESPACE =
            "Invalid namespace '{input}'. Must be [a-z0-9._-]";
    /**
     * Default caption for {@link PaperCaptionKeys#ARGUMENT_PARSE_FAILURE_NAMESPACED_KEY_KEY}
     *
     * @since 1.7.0
     */
    public static final String ARGUMENT_PARSE_FAILURE_NAMESPACED_KEY_KEY =
            "Invalid key '{input}'. Must be [a-z0-9/._-]";
    /**
     * Default caption for {@link PaperCaptionKeys#ARGUMENT_PARSE_FAILURE_NAMESPACED_KEY_KEY}
     *
     * @since 1.7.0
     */
    public static final String ARGUMENT_PARSE_FAILURE_NAMESPACED_KEY_NEED_NAMESPACE =
            "Invalid input '{input}', requires an explicit namespace.";


    @SuppressWarnings("deprecation")
    protected PaperCaptionRegistry() {
        super();
        this.registerMessageFactory(
                PaperCaptionKeys.ARGUMENT_PARSE_FAILURE_ENCHANTMENT,
                (caption, sender) -> ARGUMENT_PARSE_FAILURE_ENCHANTMENT
        );
        this.registerMessageFactory(
                PaperCaptionKeys.ARGUMENT_PARSE_FAILURE_MATERIAL,
                (caption, sender) -> ARGUMENT_PARSE_FAILURE_MATERIAL
        );
        this.registerMessageFactory(
                PaperCaptionKeys.ARGUMENT_PARSE_FAILURE_OFFLINEPLAYER,
                (caption, sender) -> ARGUMENT_PARSE_FAILURE_OFFLINEPLAYER
        );
        this.registerMessageFactory(
                PaperCaptionKeys.ARGUMENT_PARSE_FAILURE_PLAYER,
                (caption, sender) -> ARGUMENT_PARSE_FAILURE_PLAYER
        );
        this.registerMessageFactory(
                PaperCaptionKeys.ARGUMENT_PARSE_FAILURE_WORLD,
                (caption, sender) -> ARGUMENT_PARSE_FAILURE_WORLD
        );
        this.registerMessageFactory(
                PaperCaptionKeys.ARGUMENT_PARSE_FAILURE_SELECTOR_MALFORMED,
                (caption, sender) -> ARGUMENT_PARSE_FAILURE_SELECTOR_MALFORMED
        );
        this.registerMessageFactory(
                PaperCaptionKeys.ARGUMENT_PARSE_FAILURE_SELECTOR_UNSUPPORTED,
                (caption, sender) -> ARGUMENT_PARSE_FAILURE_SELECTOR_UNSUPPORTED
        );
        this.registerMessageFactory(
                PaperCaptionKeys.ARGUMENT_PARSE_FAILURE_SELECTOR_TOO_MANY_PLAYERS,
                (caption, sender) -> ARGUMENT_PARSE_FAILURE_SELECTOR_TOO_MANY_PLAYERS
        );
        this.registerMessageFactory(
                PaperCaptionKeys.ARGUMENT_PARSE_FAILURE_SELECTOR_TOO_MANY_ENTITIES,
                (caption, sender) -> ARGUMENT_PARSE_FAILURE_SELECTOR_TOO_MANY_ENTITIES
        );
        this.registerMessageFactory(
                PaperCaptionKeys.ARGUMENT_PARSE_FAILURE_SELECTOR_NON_PLAYER,
                (caption, sender) -> ARGUMENT_PARSE_FAILURE_SELECTOR_NON_PLAYER
        );
        this.registerMessageFactory(
                PaperCaptionKeys.ARGUMENT_PARSE_FAILURE_LOCATION_INVALID_FORMAT,
                (caption, sender) -> ARGUMENT_PARSE_FAILURE_LOCATION_INVALID_FORMAT
        );
        this.registerMessageFactory(
                PaperCaptionKeys.ARGUMENT_PARSE_FAILURE_LOCATION_MIXED_LOCAL_ABSOLUTE,
                (caption, sender) -> ARGUMENT_PARSE_FAILURE_LOCATION_MIXED_LOCAL_ABSOLUTE
        );
        this.registerMessageFactory(
                PaperCaptionKeys.ARGUMENT_PARSE_FAILURE_NAMESPACED_KEY_NAMESPACE,
                (caption, sender) -> ARGUMENT_PARSE_FAILURE_NAMESPACED_KEY_NAMESPACE
        );
        this.registerMessageFactory(
                PaperCaptionKeys.ARGUMENT_PARSE_FAILURE_NAMESPACED_KEY_KEY,
                (caption, sender) -> ARGUMENT_PARSE_FAILURE_NAMESPACED_KEY_KEY
        );
        this.registerMessageFactory(
                PaperCaptionKeys.ARGUMENT_PARSE_FAILURE_NAMESPACED_KEY_NEED_NAMESPACE,
                (caption, sender) -> ARGUMENT_PARSE_FAILURE_NAMESPACED_KEY_NEED_NAMESPACE
        );
    }
}

