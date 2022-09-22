package personal.ivan.spring.resourceInjectAutowired;

import personal.ivan.spring.repository.Car;

import javax.annotation.Resource;

public class ResourceInjection {
    @Resource(name = "carBean")
    public Car car;

    public void printCar() {
        System.out.println(car.getPrice());
    }

}
