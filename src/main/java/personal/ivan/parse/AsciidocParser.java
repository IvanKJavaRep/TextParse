package personal.ivan.parse;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;
import personal.ivan.domain.Document;

import java.io.File;
import java.io.FileInputStream;

public class AsciidocParser implements IParse {

    @Override
    public Document parse(String s) {
        try {
            Asciidoctor adoc = Asciidoctor.Factory.create();
            adoc.convertFile(new File("article.adoc"),
                    OptionsBuilder.options().toFile(new File("outputAsci.html"))
                            .safe(SafeMode.UNSAFE));
            Document d = new Document("Document");
            return d;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void parseByString(String s) {
    }

    @Override
    public Document parse(FileInputStream fstream) {
        return null;
    }
}
