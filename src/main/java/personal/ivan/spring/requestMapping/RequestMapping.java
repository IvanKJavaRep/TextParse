package personal.ivan.spring.requestMapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import personal.ivan.spring.repository.Car;

@RestController
@Controller
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RequestMapping {
    @org.springframework.web.bind.annotation.RequestMapping(value = "/home")
    public @ResponseBody
    void testFunc() {
        System.out.println("hello");
    }

    @PostMapping("/request")
    public void requestCar(@RequestBody Car car) {
        System.out.println(car.getPrice());
        System.out.println("car deserialized");
    }

    @org.springframework.web.bind.annotation.RequestMapping(value = "/order/{orderId}")
    public void variablePath(@PathVariable String orderId) {
        System.out.println(orderId);
    }

    public static void main(String[] args) {
        SpringApplication.run(RequestMapping.class, args);
    }
}
