package personal.ivan.validateDocument;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import personal.ivan.domain.Image;
import personal.ivan.parse.AsciidocParser;

public class validatePngAlignmentTest {
    @Test void test() {
        AsciidocParser parser = new AsciidocParser();
        for (var obj : parser.parseAsciiDocument(ClassLoader.getSystemResource("smalldoc.adoc").getPath()).getChildren())
        {
            for(var el : obj.getChildren()) {
                if (el instanceof Image) {
                    String s = ((Image) el).getMap().get("role").toString();
                    Assertions.assertFalse(s.indexOf("text-center") == -1);
                    Assertions.assertTrue(((Image) el).getMap().get("title-align").equals("center"));
                    Assertions.assertTrue(((Image) el).getMap().get("align").equals("center"));
                    Assertions.assertTrue(((Image) el).getMap().get("htmlwidth").toString().matches("\\d+%"));
                }
            }
        }
    }
}
