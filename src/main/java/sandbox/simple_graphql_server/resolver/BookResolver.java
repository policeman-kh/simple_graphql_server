package sandbox.simple_graphql_server.resolver;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import graphql.GraphQLError;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import sandbox.simple_graphql_server.data.DataProvider;
import sandbox.simple_graphql_server.model.Book;
import sandbox.simple_graphql_server.processor.IBookProcessor;

@Slf4j
@AllArgsConstructor
@Component
public class BookResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    private final DataProvider dataProvider;
    private final IBookProcessor bookProcessor;

    /**
     * Query: Get all books.
     */
    public List<Book> books() {
        return dataProvider.books();
    }

    /**
     * Query: Retrieve a book by id.
     */
    public Book bookById(String bookId) {
        return dataProvider.bookById(bookId);
    }

    /**
     * Mutation: Register a book.
     */
    public Book registerBook(String id, String name, int pageCount) {
        final Book book = new Book(id, name, pageCount);
        dataProvider.books().add(book);

        // Emit an event for subscription.
        bookProcessor.emit(book);
        return book;
    }

    /**
     * Error handler. can handle an throwable that occurs in resolver execution.
     */
    @ExceptionHandler(Throwable.class)
    GraphQLError handle(Throwable e) {
        log.error("Failed to execute resolver.", e);
        return new ThrowableGraphQLError(e, "Failed to execute resolver.");
    }
}
