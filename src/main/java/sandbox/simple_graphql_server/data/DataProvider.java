package sandbox.simple_graphql_server.data;

import java.util.List;

import sandbox.simple_graphql_server.model.Book;

public interface DataProvider {
    List<Book> books();

    Book bookById(String bookId);
}
