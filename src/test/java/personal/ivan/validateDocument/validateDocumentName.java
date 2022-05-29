package personal.ivan.validateDocument;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Options;
import org.asciidoctor.ast.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.asciidoctor.Asciidoctor.Factory.create;

public class validateDocumentName {
    @Test
    void test() {
        Asciidoctor asciidoctor = create();
        Document document = asciidoctor.loadFile(new File("crptascii.adoc"), Options.builder().build());
        Assertions.assertTrue(document.getTitle().toString().length() < 256);

        //get file from resource directory
        /*File inputXmlFile = new File(this.getClass().getResource("/testdoc.adoc").getFile());
        System.out.println(inputXmlFile.getAbsolutePath());*/
    }
}













