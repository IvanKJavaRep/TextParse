package personal.ivan.parse;

import org.junit.jupiter.api.Test;
import personal.ivan.domain.Document;
import personal.ivan.process.ProcessDocument;

public class HtmlParseTest {
    @Test void test()
    {
        HtmlParser parser = new HtmlParser();
        ProcessDocument pd = new ProcessDocument();
        Document d = parser.parse("inputhtml.html");
        pd.process(d, ProcessDocument::processToJson);

    }
}
