package personal.ivan.parse;

import org.junit.jupiter.api.Test;
import personal.ivan.domain.Document;
import personal.ivan.process.ProcessDocument;

public class HtmlParseTest {
    @Test void test()
    {
        // объект для пасинга (для html нет чтения)
        HtmlParser parser = new HtmlParser();
        // объект для процессинга
        ProcessDocument pd = new ProcessDocument();
        Document d = parser.parse("C:\\Users\\i.haritonin\\MyProjects\\TextParse\\src\\test\\resources\\inputhtml.html");
        pd.process(d, ProcessDocument::processToJson);

    }
}
