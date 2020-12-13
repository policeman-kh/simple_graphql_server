package sandbox.simple_graphql_server.processor;

import org.reactivestreams.Publisher;

import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.FluxSink;
import reactor.core.scheduler.Schedulers;
import sandbox.simple_graphql_server.model.Book;

public class BookInMemoryProcessor implements IBookProcessor {
    private final DirectProcessor<Book> processor = DirectProcessor.create();

    @Override
    public Publisher<Book> publish() {
        return processor.publishOn(Schedulers.single());
    }

    @Override
    public void emit(Book book) {
        final FluxSink<Book> sink = processor.sink();
        sink.next(book);
    }
}
