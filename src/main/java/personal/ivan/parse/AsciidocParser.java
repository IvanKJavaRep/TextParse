package personal.ivan.parse;

import org.asciidoctor.Asciidoctor;
import personal.ivan.domain.Document;

import static org.asciidoctor.Asciidoctor.Factory.create;

public class AsciidocParser implements IParse {

    @Override
    public Document parse(String s) {
        Asciidoctor adoc = create();
        //adoc.convertFile("")
        Document d = new Document("Document");
        return d;
    }

    @Override
    public void parseByString(String s) {

    }
}
