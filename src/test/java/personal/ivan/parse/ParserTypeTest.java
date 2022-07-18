package personal.ivan.parse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import personal.ivan.GlobalConstants;
import personal.ivan.domain.Document;
import personal.ivan.domain.Image;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserTypeTest {
    @ParameterizedTest
    @CsvSource({"asciidocparser.adoc",
            "htmlparser.html",
            "txtparser.txt"}
    )
    void test(String arg) {
        String filename = ClassLoader.getSystemResource(arg).getPath();
        ParserHolder parserHolder = new ParserHolder();
        IParse parse = parserHolder.chooseParserObject(ClassLoader.getSystemResource(arg).getPath());
        Document document = parse.parse(filename);
        if (parse instanceof AsciidocParser) {
            for (var obj : document.getChildren()
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
        } else if (parse instanceof HtmlParser) {
            Assertions.assertEquals("The freeCodeCamp Contribution Page shows you how and where you can contribute to freeCodeCamp's community and growth.",
                    document.getElements().get(0).getContent());
        } else if (parse instanceof TxtParser) {
            Assertions.assertEquals("text parse test\n", document.getElements().get(0).getContent());
        }
        else
        {
            Assertions.fail();
        }
    }
}
