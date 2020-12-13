package sandbox.simple_graphql_server.data;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import sandbox.simple_graphql_server.model.Book;

/**
 * Provider of hardcoded constant data.
 */
@Component
public class ConstantDataProvider implements DataProvider {
    private final List<Book> books;

    public ConstantDataProvider() {
        books = new ArrayList<>();
        books.add(new Book("1", "bookName1", 900));
        books.add(new Book("2", "bookName2", 100));
        books.add(new Book("3", "bookName3", 300));
        books.add(new Book("4", "bookName4", 1000));
    }

    @Override
    public List<Book> books() {
        return books;
    }

    @Nullable
    @Override
    public Book bookById(String bookId) {
        return books.stream()
                    .filter(book -> book.getId().equals(bookId))
                    .findFirst()
                    .orElse(null);
    }
}
