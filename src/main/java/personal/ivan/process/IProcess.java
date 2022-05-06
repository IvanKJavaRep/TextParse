package personal.ivan.process;

import personal.ivan.domain.Document;

import java.util.function.Function;

public interface IProcess {
    void process(Document d, Function<Document,String> method);
}
