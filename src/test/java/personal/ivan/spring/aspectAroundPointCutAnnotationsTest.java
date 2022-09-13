package personal.ivan.spring;

import org.junit.jupiter.api.Test;
import personal.ivan.spring.aspectAroundPointCutAnnotations.StereotypeAnnotations;

public class aspectAroundPointCutAnnotationsTest {
    @Test
    void test()
    {
        StereotypeAnnotations s = new StereotypeAnnotations();
        s.testMethod();
    }
}
