package personal.ivan.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import personal.ivan.GlobalConstants;
import personal.ivan.parse.AsciidocParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class imageTest {
    @Test
    void test() {
        AsciidocParser parser = new AsciidocParser();
        for (var obj : parser.parse(ClassLoader.getSystemResource("imageTest.adoc").getPath()).getChildren()
        ) {
            if (obj instanceof Image) {
                Pattern pat = Pattern.compile(GlobalConstants.pngRegexp);
                String s = ((Image) obj).getPath().getFileName().toString();
                Matcher mat = pat.matcher(s);
                //нашлось ли хоть одно совпадение
                Assertions.assertTrue(mat.find());
                //совпадение равно длине всей строки или нет
                Assertions.assertTrue(mat.group().length() == s.length());
            }
        }
    }
}
