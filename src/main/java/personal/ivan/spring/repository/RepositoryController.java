package personal.ivan.spring.repository;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//почему надо что-то исключать в фигурных скобках? была ошибка, просто нашел решение без объяснения
//и сработало.
public class RepositoryController {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("personal.ivan.spring.repository");
        context.refresh();
        RepositoryAnnotation rep = context.getBean(RepositoryAnnotation.class);
        rep.save(new Car());
        rep.save(new Car());
        Car c = rep.findById(1);
        System.out.println(c);
        context.close();
    }
}
