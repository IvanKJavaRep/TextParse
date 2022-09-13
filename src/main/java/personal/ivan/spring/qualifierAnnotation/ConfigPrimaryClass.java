package personal.ivan.spring.qualifierAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfigPrimaryClass {
    @Bean
    public IVehicle getCar() {
        return new CarComponent();
    }

    @Bean
    @Primary
    public IVehicle getPlane() {
        return new PlaneComponent();
    }
}
