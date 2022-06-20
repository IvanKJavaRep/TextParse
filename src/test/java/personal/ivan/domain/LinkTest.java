package personal.ivan.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import personal.ivan.parse.AsciidocParser;

public class LinkTest {
    @Test
    void test() {
        AsciidocParser parser = new AsciidocParser();
        Document d = parser.parse(ClassLoader.getSystemResource("linkTest.adoc").getPath());
        for (var c : d.getChildren()) {
            if (c instanceof Link) {
                Assertions.assertEquals("https://честныйзнак.рф/", c.getContent());
            }
        }
    }
}
