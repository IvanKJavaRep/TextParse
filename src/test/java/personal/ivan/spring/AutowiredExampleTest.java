package personal.ivan.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import personal.ivan.spring.resourceInjectAutowired.AutowiredExample;

@ComponentScan("personal.ivan.spring.resourceInjectAutowired")
public class AutowiredExampleTest {
    @Test
    void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AutowiredExampleTest.class);
        context.refresh();
        AutowiredExample auto = context.getBean(AutowiredExample.class);
        auto.printCar();
        auto.printCar2();
        auto.printCar3();

    }

}
