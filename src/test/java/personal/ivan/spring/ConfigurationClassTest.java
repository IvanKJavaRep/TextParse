package personal.ivan.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import personal.ivan.spring.configuration.Configuration;
import personal.ivan.spring.repository.Car;

public class ConfigurationClassTest {
    @Test
    void test() {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(
                Configuration.class);
        Car c = context.getBean("getCar", Car.class);
        System.out.println(c.getPrice());
    }
}
