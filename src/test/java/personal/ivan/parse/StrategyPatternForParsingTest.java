package personal.ivan.parse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import personal.ivan.domain.Document;

public class StrategyPatternForParsingTest {
    @ParameterizedTest
    @CsvSource({"htmlparser.html"})
    void test(String arg) {
        String filename = ClassLoader.getSystemResource(arg).getPath();
        StrategyParser strategyParser = new StrategyParser(filename);
        Document document = strategyParser.parse(new HtmlParser());
        Assertions.assertEquals("The freeCodeCamp Contribution Page shows you how and where you can contribute to freeCodeCamp's community and growth.",
                document.getElements().get(0).getContent());
    }
}
