package personal.ivan.spring.dependsOn;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Car {
    Engine engine;
    Wheels wheels;
    String passengerName;

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }


    public Car(Engine e, Wheels wheels) {
        System.out.println("-- Car Initialized --");
        engine = e;
        this.wheels = wheels;
    }
}
