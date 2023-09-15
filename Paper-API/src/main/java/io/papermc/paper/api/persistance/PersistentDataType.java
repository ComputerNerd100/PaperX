package io.papermc.paper.api.persistance;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * This class represents an enum with a generic content type. It defines the
 * types a custom tag can have.
 * <p>
 * This interface can be used to create your own custom
 * {@link PersistentDataType} with different complex types. This may be useful
 * for the likes of a UUIDTagType:
 * <pre>
 * {@code
 * public class UUIDTagType implements PersistentDataType<byte[], UUID> {
 *
 *         {@literal @Override}
 *         public Class<byte[]> getPrimitiveType() {
 *             return byte[].class;
 *         }
 *
 *         {@literal @Override}
 *         public Class<UUID> getComplexType() {
 *             return UUID.class;
 *         }
 *
 *         {@literal @Override}
 *         public byte[] toPrimitive(UUID complex, PersistentDataAdapterContext context) {
 *             ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
 *             bb.putLong(complex.getMostSignificantBits());
 *             bb.putLong(complex.getLeastSignificantBits());
 *             return bb.array();
 *         }
 *
 *         {@literal @Override}
 *         public UUID fromPrimitive(byte[] primitive, PersistentDataAdapterContext context) {
 *             ByteBuffer bb = ByteBuffer.wrap(primitive);
 *             long firstLong = bb.getLong();
 *             long secondLong = bb.getLong();
 *             return new UUID(firstLong, secondLong);
 *         }
 *     }}</pre>
 *
 * @param <T> the primary object type that is stored in the given tag
 * @param <Z> the retrieved object type when applying this tag type
 */
public interface PersistentDataType<T, Z> {

    /*
        The primitive one value types.
     */
    PersistentDataType<Byte, Byte> BYTE = new PrimitivePersistentDataType<>(Byte.class);
    PersistentDataType<Short, Short> SHORT = new PrimitivePersistentDataType<>(Short.class);
    PersistentDataType<Integer, Integer> INTEGER = new PrimitivePersistentDataType<>(Integer.class);
    PersistentDataType<Long, Long> LONG = new PrimitivePersistentDataType<>(Long.class);
    PersistentDataType<Float, Float> FLOAT = new PrimitivePersistentDataType<>(Float.class);
    PersistentDataType<Double, Double> DOUBLE = new PrimitivePersistentDataType<>(Double.class);

    /*
        Boolean.
     */
    /**
     * A convenience implementation to convert between Byte and Boolean as there is
     * no native implementation for booleans. <br>
     * Any byte value not equal to 0 is considered to be true.
     */
    PersistentDataType<Byte, Boolean> BOOLEAN = new BooleanPersistentDataType();

    /*
        String.
     */
    PersistentDataType<String, String> STRING = new PrimitivePersistentDataType<>(String.class);

    /*
        Primitive Arrays.
     */
    PersistentDataType<byte[], byte[]> BYTE_ARRAY = new PrimitivePersistentDataType<>(byte[].class);
    PersistentDataType<int[], int[]> INTEGER_ARRAY = new PrimitivePersistentDataType<>(int[].class);
    PersistentDataType<long[], long[]> LONG_ARRAY = new PrimitivePersistentDataType<>(long[].class);

    /*
        Complex Arrays.
     */
    PersistentDataType<PersistentDataContainer[], PersistentDataContainer[]> TAG_CONTAINER_ARRAY = new PrimitivePersistentDataType<>(PersistentDataContainer[].class);

    /*
        Nested PersistentDataContainer.
     */
    PersistentDataType<PersistentDataContainer, PersistentDataContainer> TAG_CONTAINER = new PrimitivePersistentDataType<>(PersistentDataContainer.class);

    /**
     * Returns the primitive data type of this tag.
     *
     * @return the class
     */
    @NonNull
    Class<T> getPrimitiveType();

    /**
     * Returns the complex object type the primitive value resembles.
     *
     * @return the class type
     */
    @NonNull
    Class<Z> getComplexType();

    /**
     * Returns the primitive data that resembles the complex object passed to
     * this method.
     *
     * @param complex the complex object instance
     * @param context the context this operation is running in
     * @return the primitive value
     */
    @NonNull
    T toPrimitive(@NonNull Z complex, @NonNull PersistentDataAdapterContext context);

    /**
     * Creates a complex object based of the passed primitive value
     *
     * @param primitive the primitive value
     * @param context the context this operation is running in
     * @return the complex object instance
     */
    @NonNull
    Z fromPrimitive(@NonNull T primitive, @NonNull PersistentDataAdapterContext context);

    /**
     * A default implementation that simply exists to pass on the retrieved or
     * inserted value to the next layer.
     * <p>
     * This implementation does not add any kind of logic, but is used to
     * provide default implementations for the primitive types.
     *
     * @param <T> the generic type of the primitive objects
     */
    class PrimitivePersistentDataType<T> implements PersistentDataType<T, T> {

        private final Class<T> primitiveType;

        PrimitivePersistentDataType(@NonNull Class<T> primitiveType) {
            this.primitiveType = primitiveType;
        }

        @NonNull
        @Override
        public Class<T> getPrimitiveType() {
            return primitiveType;
        }

        @NonNull
        @Override
        public Class<T> getComplexType() {
            return primitiveType;
        }

        @NonNull
        @Override
        public T toPrimitive(@NonNull T complex, @NonNull PersistentDataAdapterContext context) {
            return complex;
        }

        @NonNull
        @Override
        public T fromPrimitive(@NonNull T primitive, @NonNull PersistentDataAdapterContext context) {
            return primitive;
        }
    }

    /**
     * A convenience implementation to convert between Byte and Boolean as there is
     * no native implementation for booleans. <br>
     * Any byte value not equal to 0 is considered to be true.
     */
    class BooleanPersistentDataType implements PersistentDataType<Byte, Boolean> {

        @NonNull
        @Override
        public Class<Byte> getPrimitiveType() {
            return Byte.class;
        }

        @NonNull
        @Override
        public Class<Boolean> getComplexType() {
            return Boolean.class;
        }

        @NonNull
        @Override
        public Byte toPrimitive(@NonNull Boolean complex, @NonNull PersistentDataAdapterContext context) {
            return (byte) (complex ? 1 : 0);
        }

        @NonNull
        @Override
        public Boolean fromPrimitive(@NonNull Byte primitive, @NonNull PersistentDataAdapterContext context) {
            return primitive != 0;
        }
    }
}

