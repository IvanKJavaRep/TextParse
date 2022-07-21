package personal.ivan.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class patternVisitorTest {
    @Test
    void test() {
        Visitor visitor = new Visitor();
        Paragraph p = new Paragraph("p");
        Link l = new Link("l");
        String paragraphVisit = p.accept(visitor);
        String linkVisit = l.accept(visitor);
        Assertions.assertEquals("Paragraph", paragraphVisit);
        Assertions.assertEquals("link", linkVisit);
    }
}
