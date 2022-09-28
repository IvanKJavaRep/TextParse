package personal.ivan.spring.resourceInjectAutowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import personal.ivan.spring.repository.Car;

@Configuration
@ComponentScan("personal.ivan.spring.repository")
public class AutowiredExample {


    @Autowired
    @CustomFormatter.FormatterType("custom")
    private CustomFormatter.FormatterType formatter;

    @Autowired
    private Car car;

    private Car car2;
    private Car carOnConstructor;

    //не выбросит исключение, хотя такого бина нет, из-за параметра false
    @Autowired(required = false)
    private SomeClass someClass;

    @Autowired
    public AutowiredExample(Car carOnConstructor) {
        this.carOnConstructor = carOnConstructor;
    }

    @Autowired
    public void setCar2(Car car_) {
        car2 = car_;
    }


    public void printCar() {
        System.out.println(car.getPrice());
    }

    public void printCar2() {
        System.out.println(car2.getPrice());
    }

    public void printCar3() {
        System.out.println(carOnConstructor.getPrice());
    }
}
