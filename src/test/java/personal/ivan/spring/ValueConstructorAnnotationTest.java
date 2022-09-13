package personal.ivan.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import personal.ivan.spring.value.ValueConstructorAnnotation;

public class ValueConstructorAnnotationTest {
    @Test
    void test() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("personal.ivan.spring");
        ctx.refresh();
        ValueConstructorAnnotation v = ctx.getBean(ValueConstructorAnnotation.class);
        Assertions.assertEquals("101 some text 0", v.printProperties());
    }
}
