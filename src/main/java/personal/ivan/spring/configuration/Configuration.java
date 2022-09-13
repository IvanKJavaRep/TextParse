package personal.ivan.spring.configuration;


import org.springframework.context.annotation.Bean;
import personal.ivan.spring.repository.Car;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    Car getCar() {
        return new Car();
    }
}
