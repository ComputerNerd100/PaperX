package io.papermc.paper.api.math;

import org.jetbrains.annotations.NotNull;

record RotationsImpl(double x, double y, double z) implements Rotations {

    @Override
    public @NotNull RotationsImpl withX(double x) {
        return new RotationsImpl(x, y, z);
    }

    @Override
    public @NotNull RotationsImpl withY(double y) {
        return new RotationsImpl(x, y, z);
    }

    @Override
    public @NotNull RotationsImpl withZ(double z) {
        return new RotationsImpl(x, y, z);
    }

    @Override
    public @NotNull RotationsImpl add(double x, double y, double z) {
        return new RotationsImpl(this.x + x, this.y + y, this.z + z);
    }

}

