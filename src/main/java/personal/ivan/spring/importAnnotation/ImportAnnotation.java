package personal.ivan.spring.importAnnotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import personal.ivan.spring.dependsOn.Fuel;

@Configuration
@Import(Fuel.class)
public class ImportAnnotation {
    int a = 0;
}
