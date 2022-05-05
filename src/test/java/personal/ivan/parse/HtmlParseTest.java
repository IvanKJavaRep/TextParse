package personal.ivan.parse;

import org.junit.jupiter.api.Test;

public class HtmlParseTest {
    @Test void test()
    {
        HtmlParser parser = new HtmlParser();
        parser.parse("inputhtml.html");
    }
}
