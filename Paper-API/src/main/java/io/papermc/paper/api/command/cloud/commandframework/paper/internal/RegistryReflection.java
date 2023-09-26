package io.papermc.paper.api.command.cloud.commandframework.paper.internal;

import com.google.common.annotations.Beta;
import io.leangen.geantyref.GenericTypeReflector;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Objects;

/**
 * This is not API, and as such, may break, change, or be removed without any notice.
 */
@Beta
public final class RegistryReflection {

    public static final @Nullable Field REGISTRY_REGISTRY;
    public static final @Nullable Method REGISTRY_GET;
    public static final @Nullable Method REGISTRY_KEY;

    private static final Class<?> RESOURCE_LOCATION_CLASS = CraftPaperReflection.needNMSClassOrElse(
            "MinecraftKey",
            "net.minecraft.resources.MinecraftKey",
            "net.minecraft.resources.ResourceLocation"
    );
    private static final Constructor<?> RESOURCE_LOCATION_CTR = CraftPaperReflection.needConstructor(
            RESOURCE_LOCATION_CLASS,
            String.class
    );

    private RegistryReflection() {
    }

    static {
        Class<?> registryClass;
        if (CraftPaperReflection.MAJOR_REVISION < 17) {
            REGISTRY_REGISTRY = null;
            REGISTRY_GET = null;
            REGISTRY_KEY = null;
        } else {
            registryClass = CraftPaperReflection.firstNonNullOrThrow(
                    () -> "Registry",
                    CraftPaperReflection.findMCClass("core.IRegistry"),
                    CraftPaperReflection.findMCClass("core.Registry")
            );
            REGISTRY_REGISTRY = registryRegistryField(registryClass);
            REGISTRY_REGISTRY.setAccessible(true);
            final Class<?> resourceLocationClass = CraftPaperReflection.firstNonNullOrThrow(
                    () -> "ResourceLocation class",
                    CraftPaperReflection.findMCClass("resources.ResourceLocation"),
                    CraftPaperReflection.findMCClass("resources.MinecraftKey")
            );
            REGISTRY_GET = Arrays.stream(registryClass.getDeclaredMethods())
                    .filter(it -> it.getParameterCount() == 1
                            && it.getParameterTypes()[0].equals(resourceLocationClass)
                            && it.getReturnType().equals(Object.class))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("Could not find Registry#get(ResourceLocation)"));

            final Class<?> resourceKeyClass = CraftPaperReflection.needMCClass("resources.ResourceKey");
            REGISTRY_KEY = Arrays.stream(registryClass.getDeclaredMethods())
                    .filter(m -> m.getParameterCount() == 0 && m.getReturnType().equals(resourceKeyClass))
                    .findFirst()
                    .orElse(null);
        }
    }

    public static Object registryKey(final Object registry) {
        Objects.requireNonNull(REGISTRY_KEY, "REGISTRY_KEY");
        try {
            return REGISTRY_KEY.invoke(registry);
        } catch (final ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object get(final Object registry, final String resourceLocation) {
        Objects.requireNonNull(REGISTRY_GET, "REGISTRY_GET");
        try {
            return REGISTRY_GET.invoke(registry, RegistryReflection.createResourceLocation(resourceLocation));
        } catch (final ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object registryByName(final String name) {
        Objects.requireNonNull(REGISTRY_REGISTRY, "REGISTRY_REGISTRY");
        try {
            return get(REGISTRY_REGISTRY.get(null), name);
        } catch (final ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object createResourceLocation(final String str) {
        try {
            return RESOURCE_LOCATION_CTR.newInstance(str);
        } catch (final ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    private static Field registryRegistryField(final Class<?> registryClass) {
        // Pre-1.19.3 we want the first Registry type field in Registry
        // 1.19.3+ we want the only static final Registry<? extends Registry<?>> from BuiltInRegistries
        // In 1.19.3+ there are no Registry type fields in Registry
        return Arrays.stream(registryClass.getDeclaredFields())
                .filter(it -> it.getType().equals(registryClass))
                .findFirst()
                .orElseGet(() -> registryRegistryFieldFromBuiltInRegistries(registryClass));
    }

    private static Field registryRegistryFieldFromBuiltInRegistries(final Class<?> registryClass) {
        final Class<?> builtInRegistriesClass =
                CraftPaperReflection.needMCClass("core.registries.BuiltInRegistries");
        return Arrays.stream(builtInRegistriesClass.getDeclaredFields())
                .filter(it -> {
                    if (!it.getType().equals(registryClass) || !Modifier.isStatic(it.getModifiers())) {
                        return false;
                    }
                    final Type genericType = it.getGenericType();
                    if (!(genericType instanceof ParameterizedType)) {
                        return false;
                    }
                    Type valueType = ((ParameterizedType) genericType).getActualTypeArguments()[0];
                    while (valueType instanceof WildcardType) {
                        valueType = ((WildcardType) valueType).getUpperBounds()[0];
                    }
                    return GenericTypeReflector.erase(valueType).equals(registryClass);
                })
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Could not find Registry Registry field"));
    }
}

