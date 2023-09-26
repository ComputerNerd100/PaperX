package io.papermc.paper.api.command.cloud.commandframework.paper.annotation.specifier;

import io.papermc.paper.api.command.cloud.commandframework.paper.argument.NamespacedKeyArgument;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to set {@link NamespacedKeyArgument} to
 * require explicit namespaces.
 *
 * @since 1.7.0
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequireExplicitNamespace {

}
