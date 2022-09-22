package personal.ivan.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import personal.ivan.spring.defaultValues.DefaultValues;

@ComponentScan("personal.ivan.spring.defaultValues")
public class DefaultValuesTest {
    @Test
    void test() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(DefaultValuesTest.class);
        ctx.refresh();
        DefaultValues df = ctx.getBean(DefaultValues.class);
        Assertions.assertEquals("1 2 3  text 42 true three",
                df.printProperties());
    }
}
