package personal.ivan.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import personal.ivan.spring.value.ValueAnnotation;

public class ValueAnnotationTest {
    @Test
    void test() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("personal.ivan.spring");
        ctx.refresh();
        ValueAnnotation v = ctx.getBean(ValueAnnotation.class);
        Assertions.assertEquals("101 some text 0", v.printProperties());
    }
}
