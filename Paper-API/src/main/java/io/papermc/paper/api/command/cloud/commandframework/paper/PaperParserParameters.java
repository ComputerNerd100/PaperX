package io.papermc.paper.api.command.cloud.commandframework.paper;

import cloud.commandframework.arguments.parser.ParserParameter;
import io.leangen.geantyref.TypeToken;
import io.papermc.paper.api.command.cloud.commandframework.paper.argument.NamespacedKeyArgument;
import io.papermc.paper.api.command.cloud.commandframework.paper.parser.selector.MultipleEntitySelectorArgument;
import io.papermc.paper.api.command.cloud.commandframework.paper.parser.selector.MultiplePlayerSelectorArgument;
import io.papermc.paper.api.namespace.NamespacedKey;
import org.apiguardian.api.API;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * {@link ParserParameter} keys for cloud-paper.
 *
 * @since 1.7.0
 */
@API(status = API.Status.STABLE, since = "1.7.0")
public final class PaperParserParameters {

    private PaperParserParameters() {
    }

    /**
     * Used to specify if an empty result is allowed for
     * {@link MultiplePlayerSelectorArgument} and
     * {@link MultipleEntitySelectorArgument}.
     *
     * @since 1.8.0
     */
    @API(status = API.Status.STABLE, since = "1.8.0")
    public static final ParserParameter<Boolean> ALLOW_EMPTY_SELECTOR_RESULT =
            create("allow_empty_selector_result", TypeToken.get(Boolean.class));

    /**
     * Sets to require explicit namespaces for {@link NamespacedKeyArgument}
     * (i.e. 'test' will be rejected but 'test:test' will pass).
     *
     * @since 1.7.0
     */
    public static final ParserParameter<Boolean> REQUIRE_EXPLICIT_NAMESPACE =
            create("require_explicit_namespace", TypeToken.get(Boolean.class));

    /**
     * Sets a custom default namespace for {@link NamespacedKeyArgument}.
     * Without this annotation the default is {@link NamespacedKey#MINECRAFT}.
     *
     * @since 1.7.0
     */
    public static final ParserParameter<String> DEFAULT_NAMESPACE =
            create("default_namespace", TypeToken.get(String.class));

    private static <T> @NonNull ParserParameter<T> create(
            final @NonNull String key,
            final @NonNull TypeToken<T> expectedType
    ) {
        return new ParserParameter<>(key, expectedType);
    }
}

