package personal.ivan.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import personal.ivan.spring.resourceInjectAutowired.ResourceInjection;


public class ResourceInjectionTest {
    @Test
    void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
                ("appcontext.xml");
        context.refresh();
        ResourceInjection res = (ResourceInjection) context.getBean("injectionBean");
        res.printCar();
    }
}
