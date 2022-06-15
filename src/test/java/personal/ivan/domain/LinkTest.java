package personal.ivan.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import personal.ivan.parse.AsciidocParser;

public class LinkTest {
    @Test
    void test() {
        AsciidocParser parser = new AsciidocParser();
        Document d = parser.parseAsciiDocument(ClassLoader.getSystemResource("linkTest.adoc").getPath());
        for (var c : d.children) {
            if (c instanceof Link) {
                Assertions.assertEquals("https://честныйзнак.рф/", c.content);
            }
        }
    }
}
