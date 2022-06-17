package personal.ivan.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import personal.ivan.parse.AsciidocParser;

public class listItemTest {
    @Test void test()
    {
        AsciidocParser parser = new AsciidocParser();
        for (var obj : parser.parseAsciiDocument(ClassLoader.getSystemResource("listItemTest.adoc").getPath()).getChildren()
        ) {
            if (obj instanceof ListItem) {
                Assertions.assertEquals("направить обращение в СТП;",obj.getContent());
            }
        }
    }
}
