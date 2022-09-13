package personal.ivan.spring.qualifierAnnotation;

import org.springframework.stereotype.Component;

@Component("car")
public class CarComponent implements IVehicle {
    @Override
    public String getSpeed() {
        return "Car has a speed of 100 km\\h";
    }
}
