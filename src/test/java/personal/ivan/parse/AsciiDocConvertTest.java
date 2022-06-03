package personal.ivan.parse;

import org.junit.jupiter.api.Test;
import personal.ivan.domain.Document;
import personal.ivan.process.ProcessDocument;

public class AsciiDocConvertTest {
    @Test
    void test1() {
        AsciidocParser parser = new AsciidocParser();
        ProcessDocument pd = new ProcessDocument();
        Document d = parser.parseAsciiDocument("C:\\Users\\i.haritonin\\MyProjects\\TextParse\\src\\test\\resources\\crptascii.adoc");
        pd.process(d, ProcessDocument::processToJson);
    }
}
