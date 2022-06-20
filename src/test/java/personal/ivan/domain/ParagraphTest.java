package personal.ivan.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import personal.ivan.parse.AsciidocParser;

public class ParagraphTest {
    @Test void test()
    {
        AsciidocParser parser = new AsciidocParser();
        Document d = parser.parse(ClassLoader.getSystemResource("paragraphTest.adoc").getPath());
        Assertions.assertEquals("<strong>Пример строки запроса:</strong>",d.getChildren().get(0).getContent());
    }
    @Test void test1()
    {
        AsciidocParser parser = new AsciidocParser();
        Document d = parser.parse(ClassLoader.getSystemResource("paragraphTest1.adoc").getPath());
        Assertions.assertEquals("Пример строки запроса:",d.getChildren().get(0).getContent());

    }


}
