package personal.ivan.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import personal.ivan.spring.qualifierAnnotation.QualifierAnnotation;

@ComponentScan("personal.ivan.spring")
public class QualifierAnnotationTest {
    @Test
    void test() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(QualifierAnnotationTest.class);
        ctx.refresh();
        QualifierAnnotation q = ctx.getBean(QualifierAnnotation.class);
        Assertions.assertEquals("Plane has a speed of 1000 km\\h", q.main());
    }

}
