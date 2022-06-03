package personal.ivan.parse;

import org.asciidoctor.ast.StructuralNode;
import org.junit.jupiter.api.Test;
import personal.ivan.process.ProcessDocument;
import personal.ivan.read.AsciidocREadFile;

import java.net.MalformedURLException;
import java.util.ArrayList;

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
    @Test
    void test1() throws MalformedURLException {
        AsciidocREadFile reader = new AsciidocREadFile();
        AsciidocParser parser = new AsciidocParser();
        ProcessDocument pd = new ProcessDocument();
        ArrayList<StructuralNode> lst = reader.readTreeAsciidoc("C:\\Users\\i.haritonin\\MyProjects\\TextParse\\src\\test\\resources\\crptascii.adoc");
        parser.parseAsciidoc(lst);
        pd.process(parser.GetDocument(), ProcessDocument::processToJson);
    }
}
