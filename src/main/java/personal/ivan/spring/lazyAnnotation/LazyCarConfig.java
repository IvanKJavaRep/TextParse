package personal.ivan.spring.lazyAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import personal.ivan.spring.dependsOn.Car;
import personal.ivan.spring.dependsOn.Engine;
import personal.ivan.spring.dependsOn.Fuel;
import personal.ivan.spring.dependsOn.Wheels;

@Configuration
public class LazyCarConfig {

    @Bean(name = "fuel")
    @Lazy
    public Fuel getFuel() {
        return new Fuel();
    }

    @DependsOn("fuel")
    @Bean(name = "engine")
    @Lazy
    public Engine getEngine() {
        return new Engine(500, getFuel());
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
