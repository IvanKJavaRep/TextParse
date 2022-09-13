package personal.ivan.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import personal.ivan.spring.prop.PropertySourceClass;

public class PropertySourceClassTest {
    @Test
    void test() {
        Assertions.assertEquals("some text", PropertySourceClass.main());
    }
}
