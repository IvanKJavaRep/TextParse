package personal.ivan.process;

import personal.ivan.domain.Document;

import java.util.function.Consumer;

public interface IProcess {
    void process(Document d, Consumer<Document> method);
}
