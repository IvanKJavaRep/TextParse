package personal.ivan.spring.dependsOn;

public class Engine {
    int power;
    Fuel fuel;

    public Engine(int power, Fuel f) {
        System.out.println("-- Engine Initialized --");
        this.power = power;
        fuel = f;
    }
}
