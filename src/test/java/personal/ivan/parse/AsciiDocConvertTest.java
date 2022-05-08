package personal.ivan.parse;

import org.junit.jupiter.api.Test;
import personal.ivan.domain.Document;
import personal.ivan.process.ProcessDocument;
import personal.ivan.read.AsciidocREadFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AsciiDocConvertTest {
    @Test void test() throws FileNotFoundException {
        AsciidocREadFile aread = new AsciidocREadFile();
        FileInputStream fs = aread.Read("article.adoc");
        AsciidocParser ap = new AsciidocParser();
        Document d = ap.parse("outputAsci.html");
        ProcessDocument pd = new ProcessDocument();
        pd.process(d, ProcessDocument::processToJson);
    }
}
