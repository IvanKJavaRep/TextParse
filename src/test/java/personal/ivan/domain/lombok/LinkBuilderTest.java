package personal.ivan.domain.lombok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import personal.ivan.domain.Link;

public class LinkBuilderTest {
    @Test
    void test() {
        Link link = Link.builder().text("https://www.apple.com").build();
        Assertions.assertEquals("Link(super=Element(content=https://www.apple.com, children=[], properties={}), name=link)", link.toString());
    }
}
