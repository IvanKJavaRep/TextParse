package personal.ivan.validateDocument;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Options;
import org.asciidoctor.ast.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.asciidoctor.Asciidoctor.Factory.create;

public class validateDocumentNameTest {
    @Test
    void test() {
        Asciidoctor asciidoctor = create();
        Document document = asciidoctor.loadFile(new File(ClassLoader.getSystemResource("crptascii.adoc").getPath()), Options.builder().build());
        Assertions.assertTrue(document.getTitle().length() < 256);
    }
}













