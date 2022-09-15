package personal.ivan.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import personal.ivan.spring.dependsOn.Fuel;
import personal.ivan.spring.importAnnotation.ImportAnnotation;

public class ImportAnnotationTest {
    @Test
    void test() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ImportAnnotation.class);
        ctx.refresh();
        ImportAnnotation im = ctx.getBean(ImportAnnotation.class);
        Fuel fuel = ctx.getBean(Fuel.class);
    }
}
