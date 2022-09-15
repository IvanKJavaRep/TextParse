package personal.ivan.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import personal.ivan.spring.lookupAnnotation.LookUpAnnotation;

@ComponentScan("personal.ivan.spring.lookupAnnotation")
public class LookUpAnnotationTest {
    @Test
    void test() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(LookUpAnnotationTest.class);
        ctx.refresh();
        LookUpAnnotation lk = ctx.getBean(LookUpAnnotation.class);
        System.out.println(lk.drive("Ivan"));
    }
}
