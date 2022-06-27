package personal.ivan.domain.lombok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import personal.ivan.domain.Paragraph;

public class paragraphBuilderTest {
    @Test
    void test() {
        Paragraph par = Paragraph.builder().text("test paragraph").build();
        Assertions.assertEquals("Paragraph(super=Element(content=test paragraph, children=[], properties={}), name=Paragraph)", par.toString());
    }
}
