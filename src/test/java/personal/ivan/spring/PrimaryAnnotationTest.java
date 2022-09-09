package personal.ivan.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import personal.ivan.spring.qualifierAnnotation.ConfigPrimaryClass;
import personal.ivan.spring.qualifierAnnotation.IVehicle;

@ComponentScan("personal.ivan.spring")
public class PrimaryAnnotationTest {
    @Test
    void test() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ConfigPrimaryClass.class);
        ctx.refresh();
        IVehicle q = ctx.getBean(IVehicle.class);
        Assertions.assertEquals("Plane has a speed of 1000 km\\h", q.getSpeed());
    }
}
