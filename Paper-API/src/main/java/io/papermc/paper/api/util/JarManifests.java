package io.papermc.paper.api.util;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.jetbrains.annotations.ApiStatus;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.jar.Manifest;

@ApiStatus.Internal
public final class JarManifests {
    private JarManifests() {
    }

    private static final Map<ClassLoader, Manifest> MANIFESTS = Collections.synchronizedMap(new WeakHashMap<>());

    public static @Nullable Manifest manifest(final @NonNull Class<?> clazz) {
        return MANIFESTS.computeIfAbsent(clazz.getClassLoader(), classLoader -> {
            final String classLocation = "/" + clazz.getName().replace(".", "/") + ".class";
            final URL resource = clazz.getResource(classLocation);
            if (resource == null) {
                return null;
            }
            final String classFilePath = resource.toString().replace("\\", "/");
            final String archivePath = classFilePath.substring(0, classFilePath.length() - classLocation.length());
            try (final InputStream stream = new URL(archivePath + "/META-INF/MANIFEST.MF").openStream()) {
                return new Manifest(stream);
            } catch (final IOException ex) {
                return null;
            }
        });
    }
}
