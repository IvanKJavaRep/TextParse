package personal.ivan.spring.qualifierAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class QualifierAnnotation {
    @Autowired
    @Qualifier("plane")
    private IVehicle someVehicle;

    public  String main() {
        return someVehicle.getSpeed();
    }

}
