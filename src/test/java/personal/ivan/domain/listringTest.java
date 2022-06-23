package personal.ivan.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import personal.ivan.parse.AsciidocParser;

public class listringTest {
    @Test
    void test() {
        AsciidocParser parser = new AsciidocParser();
        for (var obj : parser.parse(ClassLoader.getSystemResource("listingTest.adoc").getPath()).getChildren()
        ) {
            if (obj instanceof Listing) {
                Assertions.assertEquals("source", obj.getProperties().get("1"));
                Assertions.assertEquals("source", obj.getProperties().get("style"));
                Assertions.assertEquals("curl -X POST \"{hostname}/ServiceModel/AuthService.svc/Login\"",
                        ((Listing) obj).getSource());
            }
        }
    }
}
