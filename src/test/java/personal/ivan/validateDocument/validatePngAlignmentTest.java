package personal.ivan.validateDocument;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import personal.ivan.domain.Image;
import personal.ivan.parse.AsciidocParser;

public class validatePngAlignmentTest {
    @Test void test() {
        AsciidocParser parser = new AsciidocParser();
        for (var obj : parser.parseAsciiDocument("C:\\Users\\i.haritonin\\MyProjects\\TextParse\\src\\test\\resources\\smalldoc.adoc").children)
        {
            for(var el : obj.children) {
                if (el instanceof Image) {
                    String s = ((Image) el).map.get("role").toString();
                    Assertions.assertFalse(s.indexOf("text-center") == -1);
                    Assertions.assertTrue(((Image) el).map.get("title-align").equals("center"));
                    Assertions.assertTrue(((Image) el).map.get("align").equals("center"));
                    Assertions.assertTrue(((Image) el).map.get("htmlwidth").toString().matches("\\d+%"));
                }
            }
        }
    }
}
