package sandbox.simple_graphql_server.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Book {
    private String id;
    private String name;
    private int pageCount;
}
