package personal.ivan.domain.lombok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import personal.ivan.domain.Document;

public class documentBuilderTest {
    @Test
    void test() {
        Document doc = Document.builder().text("Document").build();
        Assertions.assertEquals("Document(super=Element(content=Document, children=[], properties={}), elements=[])", doc.toString());

    }
}
