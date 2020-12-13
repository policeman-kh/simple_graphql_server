package sandbox.simple_graphql_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sandbox.simple_graphql_server.data.ConstantDataProvider;
import sandbox.simple_graphql_server.data.DataProvider;
import sandbox.simple_graphql_server.processor.BookInMemoryProcessor;
import sandbox.simple_graphql_server.processor.IBookProcessor;

@SpringBootApplication
public class SimpleGraphqlServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimpleGraphqlServerApplication.class, args);
    }

    @Bean
    public DataProvider dataProvider() {
        return new ConstantDataProvider();
    }

    @Bean
    public IBookProcessor bookProcessor() {
        return new BookInMemoryProcessor();
    }
}
