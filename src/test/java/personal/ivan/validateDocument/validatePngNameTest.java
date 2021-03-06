package personal.ivan.validateDocument;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import personal.ivan.GlobalConstants;
import personal.ivan.domain.Image;
import personal.ivan.parse.AsciidocParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validatePngNameTest {
    @Test
    void test() {
        AsciidocParser parser = new AsciidocParser();
        for (var obj : parser.parse(ClassLoader.getSystemResource("smalldoc.adoc").getPath()).getChildren()
        ) {
            if (obj instanceof Image) {
                Pattern pat = Pattern.compile(GlobalConstants.pngRegexp);
                String s = ((Image) obj).getPath().getFileName().toString();
                Matcher mat = pat.matcher(s);
                Assertions.assertTrue(mat.find());
                Assertions.assertEquals(mat.group().length(), s.length());
            }
        }
    }
}
