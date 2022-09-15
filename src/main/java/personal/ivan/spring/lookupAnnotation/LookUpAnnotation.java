package personal.ivan.spring.lookupAnnotation;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import personal.ivan.spring.dependsOn.Car;

@Component
@ComponentScan("personal.ivan.spring.dependsOn")
public class LookUpAnnotation {
    @Lookup
    public Car createCar() {
        return null;
    }

    public String drive(String name) {
        Car car = createCar();
        car.setPassengerName(name);
        return "name - " + car.getPassengerName();
    }
}
