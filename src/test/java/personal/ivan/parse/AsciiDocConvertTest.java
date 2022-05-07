package personal.ivan.parse;

import org.junit.jupiter.api.Test;

public class AsciiDocConvertTest {
    @Test void test()
    {
        AsciidocParser ap = new AsciidocParser();
        ap.parse("1");
    }
}
