package personal.ivan.parse;

import org.junit.jupiter.api.Test;
import personal.ivan.domain.Document;
import personal.ivan.process.ProcessDocument;
import personal.ivan.read.ReadFile;

import java.io.FileInputStream;

public class TxtParserTest {
    @Test void test()
    {
        try {
            TxtParser parser = new TxtParser();
            ReadFile rf = new ReadFile();
            FileInputStream fstream = rf.Read("input.txt");
            Document d = parser.parse(fstream);
            ProcessDocument pd = new ProcessDocument();
            pd.process(d, ProcessDocument::processToJson);
        }
        catch (Exception e)
        {
            System.out.println("11111111");
            System.out.println(e);
        }
    }
}
