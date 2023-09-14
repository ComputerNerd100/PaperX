package io.papermc.paper.api.tag;

import com.google.common.collect.Lists;
import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.block.BlockState;
import io.papermc.paper.api.block.data.BlockData;
import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.material.Material;
import io.papermc.paper.api.namespace.NamespacedKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaterialSetTag extends BaseTag<Material, MaterialSetTag> {

    public MaterialSetTag(@Nullable NamespacedKey key, @NotNull Predicate<Material> filter) {
        this(key, Stream.of(Material.values()).filter(filter).collect(Collectors.toList()));
    }

    public MaterialSetTag(@Nullable NamespacedKey key, @NotNull Material... materials) {
        this(key, Lists.newArrayList(materials));
    }

    public MaterialSetTag(@Nullable NamespacedKey key, @NotNull Collection<Material> materials) {
        this(key != null ? key : NamespacedKey.randomKey(), materials, ((Predicate<Material>) Material::isLegacy).negate());
    }

    public MaterialSetTag(@Nullable NamespacedKey key, @NotNull Collection<Material> materials, @NotNull Predicate<Material>...globalPredicates) {
        super(Material.class, key != null ? key : NamespacedKey.randomKey(), materials, globalPredicates);
    }

    @NotNull
    @Override
    protected Set<Material> getAllPossibleValues() {
        return Stream.of(Material.values()).collect(Collectors.toSet());
    }

    @Override
    @NotNull
    protected String getName(@NotNull Material value) {
        return value.name();
    }

    public boolean isTagged(@NotNull BlockData block) {
        return isTagged(block.getMaterial());
    }

    public boolean isTagged(@NotNull BlockState block) {
        return isTagged(block.getType());
    }

    public boolean isTagged(@NotNull Block block) {
        return isTagged(block.getType());
    }

    public boolean isTagged(@NotNull ItemStack item) {
        return isTagged(item.getType());
    }

    public boolean isTagged(@NotNull Material material) {
        return this.tagged.contains(material);
    }
}

