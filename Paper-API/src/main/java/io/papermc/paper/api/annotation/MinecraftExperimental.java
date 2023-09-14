package io.papermc.paper.api.annotation;

import org.jetbrains.annotations.ApiStatus;

import java.lang.annotation.*;

/**
 * Indicates that the annotated element (class, method, field, etc.) is part of a
 * <a href="https://minecraft.fandom.com/wiki/Experimental_Gameplay">minecraft experimental feature</a>
 * and is subject to changes by Mojang.
 * <p>
 * <b>Note:</b> Elements marked with this annotation require the use of a datapack or otherwise
 * non-standard feature to be enabled on the server.
 *
 * @see <a href="https://www.minecraft.net/en-us/article/testing-new-minecraft-features/feature-toggles-java-edition">Features Toggles - Minecraft Article</a>
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({
        ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE
})
@ApiStatus.Internal
public @interface MinecraftExperimental {
}

