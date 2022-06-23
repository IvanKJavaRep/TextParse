package personal.ivan.domain.lombok;

import org.junit.jupiter.api.Test;
import personal.ivan.domain.Literal;

public class literalTest {
    @Test
    void test() {
        Literal lit = Literal.builder().text("literal text").cont("literal content").build();
    }
}
