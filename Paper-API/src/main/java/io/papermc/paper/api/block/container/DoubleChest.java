package io.papermc.paper.api.block.container;

import io.papermc.paper.api.inventory.DoubleChestInventory;
import io.papermc.paper.api.inventory.Inventory;
import io.papermc.paper.api.inventory.InventoryHolder;
import io.papermc.paper.api.location.Location;
import io.papermc.paper.api.world.World;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;


/**
 * Represents a double chest.
 */
public class DoubleChest implements InventoryHolder {
    private DoubleChestInventory inventory;

    public DoubleChest(@NonNull DoubleChestInventory chest) {
        inventory = chest;
    }

    @Override
    @NonNull
    public Inventory getInventory() {
        return inventory;
    }

    @Nullable
    public InventoryHolder getLeftSide() {
        return inventory.getLeftSide().getHolder();
    }

    @Nullable
    public InventoryHolder getRightSide() {
        return inventory.getRightSide().getHolder();
    }

    // Paper start - getHolder without snapshot
    @Nullable
    public InventoryHolder getLeftSide(boolean useSnapshot) {
        return inventory.getLeftSide().getHolder(useSnapshot);
    }

    @Nullable
    public InventoryHolder getRightSide(boolean useSnapshot) {
        return inventory.getRightSide().getHolder(useSnapshot);
    }
    // Paper end

    @NonNull
    public Location getLocation() {
        return getInventory().getLocation();
    }

    @Nullable
    public World getWorld() {
        return getLocation().getWorld();
    }

    public double getX() {
        return getLocation().getX();
    }

    public double getY() {
        return getLocation().getY();
    }

    public double getZ() {
        return getLocation().getZ();
    }
}

