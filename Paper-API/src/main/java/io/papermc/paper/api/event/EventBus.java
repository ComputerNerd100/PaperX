package io.papermc.paper.api.event;

import java.util.Set;
import java.util.function.Consumer;

/**
 * The Paper Event Bus.
 * <p>Used to subscribe to Paper events.</p>
 */
public interface EventBus {

    /**
     * Registers a new subscription to the given event.
     * <p>The returned {@link EventSubscription} instance encapsulates the subscription state. It has methods which can
     * be used to terminate the subscription, or get information about the nature of the subscription.</p>
     * @param eventClass the event class
     * @param handler the event handler
     * @return an {@link EventSubscription} representing this subscription
     * @param <T> the event type
     */
    <T extends Event> EventSubscription<T> subscribe(Class<T> eventClass, Consumer<? super T> handler);

    /**
     * Registers a new subscription to the given event.
     *
     * <p>The returned {@link EventSubscription} instance encapsulates the subscription state. It has methods which can
     * be used to terminate the subscription, or get information about the nature of the subscription.</p>
     *
     * <p>In contrast to {@link #subscribe(Class, Consumer)}, this method takes an additional parameter for {@code instance}.
     * This object must be an instance of the running environment of the current platform, and is used to automatically
     * {@link EventSubscription#close() unregister} the subscription when the running environment is shutdown.</p>
     *
     * @param instance the instance of the environment (e.g. the plugin instance)
     * @param eventClass the event class
     * @param handler the event handler
     * @return an {@link EventSubscription} representing this subscription
     * @param <T> the event type
     */
    <T extends Event> EventSubscription<T> subscribe(Object instance, Class<T> eventClass, Consumer<? super T> handler);

    /**
     * Gets a set of all registered subscriptions for a given event.
     * @param eventClass the event to find subscriptions for
     * @return an immutable set of event subscriptions
     * @param <T> the event type
     */
    <T extends Event> Set<EventSubscription<T>> getSubscriptions(Class<T> eventClass);

}
