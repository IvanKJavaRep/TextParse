package personal.ivan.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import personal.ivan.parse.AsciidocParser;

public class tableTest {
    @Test void test()
    {
        AsciidocParser parser = new AsciidocParser();
        for (var obj : parser.parseAsciiDocument(ClassLoader.getSystemResource("tableTest.adoc").getPath()).getChildren()
        ) {
            if (obj instanceof Table) {
                Assertions.assertEquals(15, obj.getChildren().size());
            }
        }
    }
}
