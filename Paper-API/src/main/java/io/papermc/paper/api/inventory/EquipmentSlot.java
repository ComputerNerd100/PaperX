package io.papermc.paper.api.inventory;

public enum EquipmentSlot {

    HAND,
    OFF_HAND,
    FEET,
    LEGS,
    CHEST,
    HEAD
    ;
    /**
     * Checks whether this equipment slot is a hand:
     * either {@link #HAND} or {@link #OFF_HAND}
     *
     * @return whether this is a hand slot
     */
    public boolean isHand() {
        return this == HAND || this == OFF_HAND;
    }

    /**
     * Checks whether this equipment slot
     * is one of the armor slots:
     * {@link #HEAD}, {@link #CHEST},
     * {@link #LEGS}, or {@link #FEET}
     *
     * @return whether this is an armor slot
     */
    public boolean isArmor() {
        return this == HEAD || this == CHEST || this == LEGS || this == FEET;
    }
}

