package personal.ivan.spring;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"personal.ivan.spring.SomeCLass"})
public class ComponentScanController {
    public static void test()
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ComponentScanController.class);
        context.refresh();
        context.getBean("componentScanController");
        System.out.println(context.getBean("someClass"));
        System.out.println("Contains SomeClass: "
                + context.containsBean("someClass"));
    }
}
