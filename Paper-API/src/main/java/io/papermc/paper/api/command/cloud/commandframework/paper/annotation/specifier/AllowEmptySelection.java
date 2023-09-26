package io.papermc.paper.api.command.cloud.commandframework.paper.annotation.specifier;

import io.papermc.paper.api.command.cloud.commandframework.paper.parser.selector.MultipleEntitySelectorArgument;
import io.papermc.paper.api.command.cloud.commandframework.paper.parser.selector.MultiplePlayerSelectorArgument;
import org.apiguardian.api.API;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to specify if an empty result is allowed for
 * {@link MultiplePlayerSelectorArgument} and
 * {@link MultipleEntitySelectorArgument}.
 *
 * @since 1.8.0
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@API(status = API.Status.STABLE, since = "1.8.0")
public @interface AllowEmptySelection {

    /**
     * Whether to allow empty results.
     *
     * @return value
     */
    boolean value() default true;

}

