package personal.ivan.spring.dependsOn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class DependsOnCarConfig {
    @DependsOn("fuel")
    @Bean(name = "engine")
    public Engine getEngine() {
        return new Engine(500, getFuel());
    }

    @Bean(name = "fuel")
    public Fuel getFuel() {
        return new Fuel();
    }

    @Bean(name = "wheels")
    public Wheels getWheels() {
        return new Wheels(22);
    }

    @DependsOn({"engine", "wheels"})
    @Bean(name = "car")
    public Car getCar() {
        return new Car(getEngine(), getWheels());
    }
}
