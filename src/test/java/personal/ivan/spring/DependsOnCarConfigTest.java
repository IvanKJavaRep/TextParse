package personal.ivan.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import personal.ivan.spring.dependsOn.DependsOnCarConfig;

public class DependsOnCarConfigTest {
    @Test
    void test() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(DependsOnCarConfig.class);
        ctx.refresh();
    }
}
