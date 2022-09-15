package personal.ivan.spring.dependsOn;

import org.springframework.stereotype.Component;

@Component
public class Fuel {
    public int sort = 98;

    public Fuel() {
        System.out.println("-- Fuel Initialized --");
    }
}
