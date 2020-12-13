package sandbox.simple_graphql_server.processor;

import org.reactivestreams.Publisher;

public interface IProcessor<T> {
    /**
     * Publisher of an event emitted.
     */
    Publisher<T> publish();
    /**
     * Emit an event.
     */
    void emit(T t);
}
