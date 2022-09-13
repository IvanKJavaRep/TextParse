package personal.ivan.spring.qualifierAnnotation;

import org.springframework.stereotype.Component;

@Component("plane")
public class PlaneComponent implements IVehicle {
    @Override
    public String getSpeed() {
        return "Plane has a speed of 1000 km\\h";
    }
}
