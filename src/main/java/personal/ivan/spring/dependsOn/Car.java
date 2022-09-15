package personal.ivan.spring.dependsOn;

public class Car {
    Engine engine;
    Wheels wheels;

    public Car(Engine e, Wheels wheels) {
        System.out.println("-- Car Initialized --");
        engine = e;
        this.wheels = wheels;
    }
}
