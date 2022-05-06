package personal.ivan.parse;

import org.junit.jupiter.api.Test;
import personal.ivan.domain.Document;
import personal.ivan.process.ProcessDocument;
import personal.ivan.read.ReadFile;

import java.io.FileInputStream;

public class TxtParserTest {
    @Test void test()
    {
        TxtParser parser = new TxtParser();
        ReadFile rf = new ReadFile();
        FileInputStream fstream = rf.Read("input.txt");
        Document d = parser.parse(fstream);
        ProcessDocument pd = new ProcessDocument();
        pd.process(d, ProcessDocument::processToJson);
    }
}
