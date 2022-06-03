package personal.ivan.read;

import org.junit.jupiter.api.Test;

public class TreeReadTest {
    @Test void test()
    {
        AsciidocREadFile r = new AsciidocREadFile();
        r.readTreeAsciidoc("C:\\Users\\i.haritonin\\MyProjects\\TextParse\\src\\test\\resources\\crptascii.adoc");
    }
}
