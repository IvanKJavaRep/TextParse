package personal.ivan.parse;

import org.junit.jupiter.api.Test;
import personal.ivan.domain.Document;
import personal.ivan.process.ProcessDocument;
import personal.ivan.read.AsciidocREadFile;

public class AsciiDocConvertTest {
    /*@Test void test() throws FileNotFoundException {
        // объект для чтения файла и преобразования в html
        AsciidocREadFile aread = new AsciidocREadFile();
        FileInputStream fs = aread.Read("article.adoc");
        // объект для парсинга
        AsciidocParser ap = new AsciidocParser();
        Document d = ap.parse("outputAsci.html");
        // объект для сериализации в json
        ProcessDocument pd = new ProcessDocument();
        pd.process(d, ProcessDocument::processToJson);
    }*/
    @Test void test1()
    {
        AsciidocREadFile reader = new AsciidocREadFile();
        Document d = reader.readTreeAsciidoc();
        ProcessDocument pd = new ProcessDocument();
        pd.process(d,ProcessDocument::processToJson);
    }
}
