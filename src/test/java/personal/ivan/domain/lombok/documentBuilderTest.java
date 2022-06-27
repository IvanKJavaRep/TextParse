package personal.ivan.domain.lombok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import personal.ivan.domain.Document;

public class documentBuilderTest {

    @ParameterizedTest
    @ValueSource(strings = {"D", "Doc", "Document"})
    void test(String arg) {
        Document doc = Document.builder().text(arg).build();
        Assertions.assertEquals(String.format("Document(super=Element(content=%s, children=[], properties={}), elements=[])", arg), doc.toString());


    }
}
