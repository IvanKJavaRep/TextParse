package personal.ivan.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import personal.ivan.parse.AsciidocParser;

public class ParagraphTest {
    @Test void test()
    {
        AsciidocParser parser = new AsciidocParser();
        Document d = parser.parse(ClassLoader.getSystemResource("paragraphTest.adoc").getPath());
        Assertions.assertEquals("<strong>������ ������ �������:</strong>",d.getChildren().get(0).getContent());
    }
    @Test void test1()
    {
        AsciidocParser parser = new AsciidocParser();
        Document d = parser.parse(ClassLoader.getSystemResource("paragraphTest1.adoc").getPath());
        Assertions.assertEquals("������ ������ �������:",d.getChildren().get(0).getContent());

    }


}
