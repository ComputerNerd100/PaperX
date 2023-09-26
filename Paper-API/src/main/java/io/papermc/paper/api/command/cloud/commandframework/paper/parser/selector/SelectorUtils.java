package io.papermc.paper.api.command.cloud.commandframework.paper.parser.selector;

import cloud.commandframework.arguments.parser.ArgumentParseResult;
import cloud.commandframework.arguments.parser.ArgumentParser;
import cloud.commandframework.brigadier.argument.WrappedBrigadierParser;
import cloud.commandframework.context.CommandContext;
import com.google.common.base.Suppliers;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import io.leangen.geantyref.GenericTypeReflector;
import io.papermc.paper.api.Paper;
import io.papermc.paper.api.command.CommandSender;
import io.papermc.paper.api.command.cloud.commandframework.paper.PaperCommandContextKeys;
import io.papermc.paper.api.command.cloud.commandframework.paper.internal.CraftPaperReflection;
import io.papermc.paper.api.command.cloud.commandframework.paper.internal.MinecraftArgumentTypes;
import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.namespace.NamespacedKey;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.framework.qual.DefaultQualifier;

import java.lang.reflect.*;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@DefaultQualifier(NonNull.class)
final class SelectorUtils {

    private SelectorUtils() {
    }

    private static <C, T> @Nullable ArgumentParser<C, T> createModernParser(
            final boolean single,
            final boolean playersOnly,
            final SelectorMapper<T> mapper
    ) {
        if (CraftPaperReflection.MAJOR_REVISION < 13) {
            return null;
        }
        final ArgumentParser<C, Object> wrappedBrigParser = new WrappedBrigadierParser<>(
                () -> createEntityArgument(single, playersOnly),
                ArgumentParser.DEFAULT_ARGUMENT_COUNT,
                EntityArgumentParseFunction.INSTANCE
        );
        return new ModernSelectorParser<>(wrappedBrigParser, mapper);
    }

    @SuppressWarnings("unchecked")
    private static ArgumentType<Object> createEntityArgument(final boolean single, final boolean playersOnly) {
        final Constructor<?> constructor =
                MinecraftArgumentTypes.getClassByKey(NamespacedKey.minecraft("entity")).getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        try {
            return (ArgumentType<Object>) constructor.newInstance(single, playersOnly);
        } catch (final ReflectiveOperationException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static final class EntityArgumentParseFunction implements WrappedBrigadierParser.ParseFunction<Object> {

        static final EntityArgumentParseFunction INSTANCE = new EntityArgumentParseFunction();

        @Override
        public Object apply(
                final ArgumentType<Object> type,
                final StringReader reader
        ) throws CommandSyntaxException {
            final @Nullable Method specialParse = CraftPaperReflection.findMethod(
                    type.getClass(),
                    "parse",
                    StringReader.class,
                    boolean.class
            );
            if (specialParse == null) {
                return type.parse(reader);
            }
            try {
                return specialParse.invoke(
                        type,
                        reader,
                        true // CraftBukkit overridePermissions param
                );
            } catch (final InvocationTargetException ex) {
                final Throwable cause = ex.getCause();
                if (cause instanceof CommandSyntaxException) {
                    throw (CommandSyntaxException) cause;
                }
                throw new RuntimeException(ex);
            } catch (final ReflectiveOperationException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @SuppressWarnings("unused") // errorprone false positive
    private abstract static class SelectorParser<C, T> implements ArgumentParser<C, T>, SelectorMapper<T> {

        protected static final Supplier<Object> NO_PLAYERS_EXCEPTION_TYPE =
                Suppliers.memoize(() -> findExceptionType("argument.entity.notfound.player"));
        protected static final Supplier<Object> NO_ENTITIES_EXCEPTION_TYPE =
                Suppliers.memoize(() -> findExceptionType("argument.entity.notfound.entity"));

        private final @Nullable ArgumentParser<C, T> modernParser;

        // Hide brigadier references in inner class
        protected static final class Thrower {

            private final Object type;

            Thrower(final Object simpleCommandExceptionType) {
                this.type = simpleCommandExceptionType;
            }

            void throwIt() {
                throw rethrow(((SimpleCommandExceptionType) this.type).create());
            }
        }

        protected SelectorParser(
                final boolean single,
                final boolean playersOnly
        ) {
            this.modernParser = createModernParser(single, playersOnly, this);
        }

        protected ArgumentParseResult<T> legacyParse(
                final CommandContext<C> commandContext,
                final Queue<String> inputQueue
        ) {
            return ArgumentParseResult.failure(new SelectorParseException(
                    "",
                    commandContext,
                    SelectorParseException.FailureReason.UNSUPPORTED_VERSION,
                    this.getClass()
            ));
        }

        protected List<String> legacySuggestions(
                final CommandContext<C> commandContext,
                final String input
        ) {
            return Collections.emptyList();
        }

        @Override
        public ArgumentParseResult<T> parse(
                final CommandContext<C> commandContext,
                final Queue<String> inputQueue
        ) {
            if (this.modernParser != null) {
                return this.modernParser.parse(commandContext, inputQueue);
            }
            return this.legacyParse(commandContext, inputQueue);
        }

        @Override
        public List<String> suggestions(
                final CommandContext<C> commandContext,
                final String input
        ) {
            if (this.modernParser != null) {
                return this.modernParser.suggestions(commandContext, input);
            }
            return this.legacySuggestions(commandContext, input);
        }

        // returns SimpleCommandExceptionType, does not reference in signature for ABI with pre-1.13
        private static Object findExceptionType(final String type) {
            final Field[] fields = MinecraftArgumentTypes.getClassByKey(NamespacedKey.minecraft("entity")).getDeclaredFields();
            return Arrays.stream(fields)
                    .filter(field -> Modifier.isStatic(field.getModifiers()) && field.getType() == SimpleCommandExceptionType.class)
                    .map(field -> {
                        try {
                            final @Nullable Object fieldValue = field.get(null);
                            if (fieldValue == null) {
                                return null;
                            }
                            final Field messageField = SimpleCommandExceptionType.class.getDeclaredField("message");
                            messageField.setAccessible(true);
                            if (messageField.get(fieldValue).toString().contains(type)) {
                                return fieldValue;
                            }
                        } catch (final ReflectiveOperationException ex) {
                            throw new RuntimeException(ex);
                        }
                        return null;
                    })
                    .filter(Objects::nonNull)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Could not find exception type '" + type + "'"));
        }
    }

    abstract static class EntitySelectorParser<C, T> extends SelectorParser<C, T> {

        protected EntitySelectorParser(final boolean single) {
            super(single, false);
        }
    }

    abstract static class PlayerSelectorParser<C, T> extends SelectorParser<C, T> {

        protected PlayerSelectorParser(final boolean single) {
            super(single, true);
        }

        @Override
        protected List<String> legacySuggestions(
                final CommandContext<C> commandContext,
                final String input
        ) {
            final List<String> suggestions = new ArrayList<>();

            for (final Player player : Paper.getOnlinePlayers()) {
                final CommandSender bukkit = commandContext.get(PaperCommandContextKeys.PAPER_COMMAND_SENDER);
                if (bukkit instanceof Player && !((Player) bukkit).canSee(player)) {
                    continue;
                }
                suggestions.add(player.getName());
            }

            return suggestions;
        }
    }

    private static class ModernSelectorParser<C, T> implements ArgumentParser<C, T> {

        private final ArgumentParser<C, Object> wrappedBrigadierParser;
        private final SelectorMapper<T> mapper;

        ModernSelectorParser(
                final ArgumentParser<C, Object> wrapperBrigParser,
                final SelectorMapper<T> mapper
        ) {
            this.wrappedBrigadierParser = wrapperBrigParser;
            this.mapper = mapper;
        }

        @Override
        public ArgumentParseResult<T> parse(
                final CommandContext<C> commandContext,
                final Queue<String> inputQueue
        ) {
            final List<String> originalInputQueue = new ArrayList<>(inputQueue);

            final ArgumentParseResult<Object> result = this.wrappedBrigadierParser.parse(commandContext, inputQueue);
            if (result.getFailure().isPresent()) {
                return ArgumentParseResult.failure(result.getFailure().get());
            } else if (result.getParsedValue().isPresent()) {
                try {
                    final int consumed = originalInputQueue.size() - inputQueue.size();
                    final String input = String.join(" ", originalInputQueue.subList(0, consumed));
                    return ArgumentParseResult.success(this.mapper.mapResult(
                            input,
                            new EntitySelectorWrapper(commandContext, result.getParsedValue().get())
                    ));
                } catch (final CommandSyntaxException ex) {
                    inputQueue.clear();
                    inputQueue.addAll(originalInputQueue);
                    return ArgumentParseResult.failure(ex);
                } catch (final Exception ex) {
                    throw rethrow(ex);
                }
            }
            throw new IllegalStateException();
        }

        @Override
        public List<String> suggestions(
                final CommandContext<C> commandContext,
                final String input
        ) {
            final Object commandSourceStack = commandContext.get(WrappedBrigadierParser.COMMAND_CONTEXT_BRIGADIER_NATIVE_SENDER);
            final @Nullable Field bypassField =
                    //TODO: Remove reflection
                    CraftPaperReflection.findField(commandSourceStack.getClass(), "bypassSelectorPermissions");
            try {
                boolean prev = false;
                try {
                    if (bypassField != null) {
                        prev = bypassField.getBoolean(commandSourceStack);
                        bypassField.setBoolean(commandSourceStack, true);
                    }
                    return this.wrappedBrigadierParser.suggestions(commandContext, input);
                } finally {
                    if (bypassField != null) {
                        bypassField.setBoolean(commandSourceStack, prev);
                    }
                }
            } catch (final ReflectiveOperationException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    static final class EntitySelectorWrapper {

        private static volatile @MonotonicNonNull Methods methods;

        private final CommandContext<?> commandContext;
        private final Object selector;

        private static final class Methods {

            private @MonotonicNonNull Method getBukkitEntity;
            private @MonotonicNonNull Method entity;
            private @MonotonicNonNull Method player;
            private @MonotonicNonNull Method entities;
            private @MonotonicNonNull Method players;

            Methods(final CommandContext<?> commandContext, final Object selector) {
                final Object nativeSender = commandContext.get(WrappedBrigadierParser.COMMAND_CONTEXT_BRIGADIER_NATIVE_SENDER);
                final Class<?> nativeSenderClass = nativeSender.getClass();
                for (final Method method : selector.getClass().getDeclaredMethods()) {
                    if (method.getParameterCount() != 1
                            || !method.getParameterTypes()[0].equals(nativeSenderClass)
                            || !Modifier.isPublic(method.getModifiers())) {
                        continue;
                    }

                    final Class<?> returnType = method.getReturnType();
                    if (List.class.isAssignableFrom(returnType)) {
                        final ParameterizedType stringListType = (ParameterizedType) method.getGenericReturnType();
                        Type listType = stringListType.getActualTypeArguments()[0];
                        while (listType instanceof WildcardType) {
                            listType = ((WildcardType) listType).getUpperBounds()[0];
                        }
                        final Class<?> clazz = listType instanceof Class
                                ? (Class<?>) listType
                                : GenericTypeReflector.erase(listType);
                        final @Nullable Method getBukkitEntity = findGetBukkitEntityMethod(clazz);
                        if (getBukkitEntity == null) {
                            continue;
                        }
                        final Class<?> bukkitType = getBukkitEntity.getReturnType();
                        if (Player.class.isAssignableFrom(bukkitType)) {
                            if (this.players != null) {
                                throw new IllegalStateException();
                            }
                            this.players = method;
                        } else {
                            if (this.entities != null) {
                                throw new IllegalStateException();
                            }
                            this.entities = method;
                        }
                    } else if (returnType != Void.TYPE) {
                        final @Nullable Method getBukkitEntity = findGetBukkitEntityMethod(returnType);
                        if (getBukkitEntity == null) {
                            continue;
                        }
                        final Class<?> bukkitType = getBukkitEntity.getReturnType();
                        if (Player.class.isAssignableFrom(bukkitType)) {
                            if (this.player != null) {
                                throw new IllegalStateException();
                            }
                            this.player = method;
                        } else {
                            if (this.entity != null || this.getBukkitEntity != null) {
                                throw new IllegalStateException();
                            }
                            this.entity = method;
                            this.getBukkitEntity = getBukkitEntity;
                        }
                    }
                }
                Objects.requireNonNull(this.getBukkitEntity, "Failed to locate getBukkitEntity method");
                Objects.requireNonNull(this.player, "Failed to locate findPlayer method");
                Objects.requireNonNull(this.entity, "Failed to locate findEntity method");
                Objects.requireNonNull(this.players, "Failed to locate findPlayers method");
                Objects.requireNonNull(this.entities, "Failed to locate findEntities method");
            }

            private static @Nullable Method findGetBukkitEntityMethod(final Class<?> returnType) {
                @Nullable Method getBukkitEntity;
                try {
                    getBukkitEntity = returnType.getDeclaredMethod("getBukkitEntity");
                } catch (final ReflectiveOperationException ex) {
                    try {
                        getBukkitEntity = returnType.getMethod("getBukkitEntity");
                    } catch (final ReflectiveOperationException ex0) {
                        getBukkitEntity = null;
                    }
                }
                return getBukkitEntity;
            }
        }

        EntitySelectorWrapper(
                final CommandContext<?> commandContext,
                final Object selector
        ) {
            this.commandContext = commandContext;
            this.selector = selector;
        }

        private static Methods methods(final CommandContext<?> commandContext, final Object selector) {
            if (methods == null) {
                synchronized (Methods.class) {
                    if (methods == null) {
                        methods = new Methods(commandContext, selector);
                    }
                }
            }
            return methods;
        }

        private Methods methods() {
            return methods(this.commandContext, this.selector);
        }

        Entity singleEntity() {
            return reflectiveOperation(() -> (Entity) this.methods().getBukkitEntity.invoke(this.methods().entity.invoke(
                    this.selector,
                    this.commandContext.<Object>get(WrappedBrigadierParser.COMMAND_CONTEXT_BRIGADIER_NATIVE_SENDER)
            )));
        }

        Player singlePlayer() {
            return reflectiveOperation(() -> (Player) this.methods().getBukkitEntity.invoke(this.methods().player.invoke(
                    this.selector,
                    this.commandContext.<Object>get(WrappedBrigadierParser.COMMAND_CONTEXT_BRIGADIER_NATIVE_SENDER)
            )));
        }

        @SuppressWarnings("unchecked")
        List<Entity> entities() {
            final List<Object> internalEntities = reflectiveOperation(() -> ((List<Object>) this.methods().entities.invoke(
                    this.selector,
                    this.commandContext.<Object>get(WrappedBrigadierParser.COMMAND_CONTEXT_BRIGADIER_NATIVE_SENDER)
            )));
            return internalEntities.stream()
                    .map(o -> reflectiveOperation(() -> (Entity) this.methods().getBukkitEntity.invoke(o)))
                    .collect(Collectors.toList());
        }

        @SuppressWarnings("unchecked")
        List<Player> players() {
            final List<Object> serverPlayers = reflectiveOperation(() -> ((List<Object>) this.methods().players.invoke(
                    this.selector,
                    this.commandContext.<Object>get(WrappedBrigadierParser.COMMAND_CONTEXT_BRIGADIER_NATIVE_SENDER)
            )));
            return serverPlayers.stream()
                    .map(o -> reflectiveOperation(() -> (Player) this.methods().getBukkitEntity.invoke(o)))
                    .collect(Collectors.toList());
        }

        @FunctionalInterface
        interface ReflectiveOperation<T> {

            T run() throws ReflectiveOperationException;
        }

        private static <T> T reflectiveOperation(final ReflectiveOperation<T> op) {
            try {
                return op.run();
            } catch (final InvocationTargetException ex) {
                if (ex.getCause() instanceof CommandSyntaxException) {
                    throw rethrow(ex.getCause());
                }
                throw new RuntimeException(ex);
            } catch (final ReflectiveOperationException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @FunctionalInterface
    interface SelectorMapper<T> {

        T mapResult(String input, EntitySelectorWrapper wrapper) throws Exception; // throws CommandSyntaxException
    }

    @SuppressWarnings("unchecked")
    private static <X extends Throwable> RuntimeException rethrow(final Throwable t) throws X {
        throw (X) t;
    }
}

