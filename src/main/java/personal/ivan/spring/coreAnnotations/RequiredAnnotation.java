package personal.ivan.spring.coreAnnotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RequiredAnnotation {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        SomeClass student = (SomeClass) context.getBean("someClass");
        System.out.println(student.a);

    }
}
