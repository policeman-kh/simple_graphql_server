package sandbox.simple_graphql_server.resolver;

import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import lombok.AllArgsConstructor;
import sandbox.simple_graphql_server.model.Book;
import sandbox.simple_graphql_server.processor.IBookProcessor;

@AllArgsConstructor
@Component
public class SubscriptionResolver implements GraphQLSubscriptionResolver {
    private final IBookProcessor bookProcessor;

    /**
     * Publish an event that a book is registered.
     */
    public Publisher<Book> subscribeBooks() {
        return bookProcessor.publish();
    }
}
