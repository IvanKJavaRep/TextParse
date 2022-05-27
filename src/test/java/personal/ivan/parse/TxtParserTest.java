package personal.ivan.parse;

import org.junit.jupiter.api.Test;
import personal.ivan.domain.Document;
import personal.ivan.process.ProcessDocument;
import personal.ivan.read.ReadFile;

import java.io.FileInputStream;

public class TxtParserTest {
    @Test
    void test() {
        try {
            // объект для чтения
            ReadFile rf = new ReadFile();
            FileInputStream fstream = rf.Read("input.txt");
            // объект для парсинга
            TxtParser parser = new TxtParser();
            Document d = parser.parse(fstream);
            // объект для сериализации
            ProcessDocument pd = new ProcessDocument();
            pd.process(d, ProcessDocument::processToJson);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
