package io.papermc.paper.api.math;

import org.checkerframework.checker.nullness.qual.NonNull;

record RotationsImpl(double x, double y, double z) implements Rotations {

    @Override
    public @NonNull RotationsImpl withX(double x) {
        return new RotationsImpl(x, y, z);
    }

    @Override
    public @NonNull RotationsImpl withY(double y) {
        return new RotationsImpl(x, y, z);
    }

    @Override
    public @NonNull RotationsImpl withZ(double z) {
        return new RotationsImpl(x, y, z);
    }

    @Override
    public @NonNull RotationsImpl add(double x, double y, double z) {
        return new RotationsImpl(this.x + x, this.y + y, this.z + z);
    }

}

