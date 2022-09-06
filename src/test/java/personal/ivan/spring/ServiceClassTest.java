package personal.ivan.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import personal.ivan.spring.service.ServiceClass;

public class ServiceClassTest {
    @Test
    void test() {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext();
        context.scan("personal.ivan.spring.service");
        context.refresh();
        ServiceClass myServiceClass
                = context.getBean(ServiceClass.class);
        System.out.println(myServiceClass.countSomething(11));
    }
}
