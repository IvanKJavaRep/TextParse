package personal.ivan.domain.lombok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import personal.ivan.domain.Literal;

public class literalBuilderTest {
    @Test
    void test() {
        Literal lit = Literal.builder().text("literal text").cont("literal content").build();
        Assertions.assertEquals(
                "Literal(super=Element(content=literal text, children=[], properties={}), source=literal content)", lit.toString());
    }
}
