package personal.ivan.patterns;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import personal.ivan.domain.Image;
import personal.ivan.domain.Memento;
import personal.ivan.parse.AsciidocParser;

public class mementoTest {
    @Test
    void test() {
        Image im = new Image(null, null, null);
        AsciidocParser parser = new AsciidocParser();
        for (var obj : parser.parse(ClassLoader.getSystemResource("imageTest.adoc").getPath()).getChildren()
        ) {
            if (obj instanceof Image) {
                im =  (Image) ((Image) obj).copy();
                break;
            }
        }
        Memento imageMemento = new Memento(im.getPath(),im.getMap());
        //изменили значение мапа и проверили, что не поменялось
        im.getMap().put("str", 1);
        Assertions.assertEquals(im.getPath(),imageMemento.getPath());
        Assertions.assertNotEquals(im.getMap().size(),imageMemento.getMap().size());
    }
}
