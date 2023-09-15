package io.papermc.paper.api.inventory;

import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NonNull;

public enum ItemRarity {

    COMMON(NamedTextColor.WHITE),
    UNCOMMON(NamedTextColor.YELLOW),
    RARE(NamedTextColor.AQUA),
    EPIC(NamedTextColor.LIGHT_PURPLE);

    TextColor color;

    ItemRarity(TextColor color) {
        this.color = color;
    }

    /**
     * Gets the color formatting associated with the rarity.
     * @return
     */
    @NonNull
    public TextColor getColor() {
        return color;
    }
}
