package io.papermc.paper.api.inventory.meta;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents armor that an entity can equip and can also be colored.
 */
public interface ColorableArmorMeta extends ArmorMeta, LeatherArmorMeta {

    @Override
    @NonNull
    ColorableArmorMeta clone();
}
