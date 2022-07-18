package personal.ivan.validateDocument;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import personal.ivan.domain.Image;
import personal.ivan.parse.IParse;
import personal.ivan.parse.ParserHolder;

public class validatePngAlignmentTest {
    @Test
    void test() {
        String filename = ClassLoader.getSystemResource("smalldoc.adoc").getPath();
        ParserHolder parserType = ParserHolder.getInstance();
        IParse parserObject = parserType.chooseParserObject(filename);
        for (var obj : parserObject.parse(filename).getChildren()) {
            for (var el : obj.getChildren()) {
                if (el instanceof Image) {
                    String s = ((Image) el).getMap().get("role").toString();
                    Assertions.assertNotEquals(-1, s.indexOf("text-center"));
                    Assertions.assertEquals("center", ((Image) el).getMap().get("title-align"));
                    Assertions.assertEquals("center", ((Image) el).getMap().get("align"));
                    Assertions.assertTrue(((Image) el).getMap().get("htmlwidth").toString().matches("\\d+%"));
                }
            }
        }
    }
}
