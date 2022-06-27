package personal.ivan.domain.lombok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import personal.ivan.domain.Image;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class imageBuilderTest {
    @Test
    void test() {
        Map<String, Object> map = new HashMap<>();
        Image image = Image.builder().text("image").p(Path.of("ivan\\test")).m(map).build();
        Assertions.assertEquals("Image(super=Element(content=image, children=[], properties={}), map={}, path=ivan\\test)", image.toString());
    }

}
