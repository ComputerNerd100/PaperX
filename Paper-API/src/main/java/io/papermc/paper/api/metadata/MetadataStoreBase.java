package io.papermc.paper.api.metadata;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

public interface MetadataStoreBase<T> {
    void setMetadata(T subject, String metadataKey, MetadataValue newMetadataValue);
    List<MetadataValue> getMetadata(@NonNull T subject, @NonNull String metadataKey);
    boolean hasMetadata(@NonNull T subject, @NonNull String metadataKey);
    void removeMetadata(@NonNull T subject, @NonNull String metadataKey, @NonNull Plugin owningPlugin);
    void invalidateAll(@NonNull Plugin owningPlugin);
    void removeAll(@NonNull PLugin owningPlugin);
    String disambiguate(@NonNull Plugin owningPlugin, @NonNull String metadataKey);
}
