package personal.ivan.spring.repository;

import org.springframework.stereotype.Component;

@Component("carBean")
public class Car {
    int power = 10;
    int speed = 100;

    public String getPrice() {
        return "The price is 25,000$";
    }
}
