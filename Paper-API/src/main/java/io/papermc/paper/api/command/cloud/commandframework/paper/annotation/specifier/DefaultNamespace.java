package io.papermc.paper.api.command.cloud.commandframework.paper.annotation.specifier;

import io.papermc.paper.api.command.cloud.commandframework.paper.argument.NamespacedKeyArgument;
import io.papermc.paper.api.namespace.NamespacedKey;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to set a custom namespace for {@link NamespacedKeyArgument}.
 * Without this annotation, the default namespace is {@link NamespacedKey#MINECRAFT}.
 *
 * @since 1.7.0
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultNamespace {

    /**
     * Default namespace string.
     *
     * @return default namespace
     * @since 1.7.0
     */
    @NonNull String value();
}

