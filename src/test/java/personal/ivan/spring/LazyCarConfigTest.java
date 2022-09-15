package personal.ivan.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import personal.ivan.spring.lazyAnnotation.LazyCarConfig;

public class LazyCarConfigTest {
    @Test
    void test() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(LazyCarConfig.class);
        ctx.refresh();
    }
}
