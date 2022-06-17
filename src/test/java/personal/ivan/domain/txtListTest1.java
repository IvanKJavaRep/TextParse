package personal.ivan.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import personal.ivan.parse.AsciidocParser;

public class txtListTest1 {
    @Test
    void test() {
        AsciidocParser parser = new AsciidocParser();
        for (var obj : parser.parseAsciiDocument(ClassLoader.getSystemResource("txtListTest.adoc").getPath()).getChildren()
        ) {
            Assertions.assertEquals(3, obj.getChildren().size());
        }
    }
}
