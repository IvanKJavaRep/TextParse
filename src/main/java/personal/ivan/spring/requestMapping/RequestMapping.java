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

    @org.springframework.web.bind.annotation.RequestMapping(value = {"/order1/{order}", "/order1/"})
    public void variablePathFalse(@PathVariable(required = false) String order) {
        if (order == null) {
            System.out.println("no param passed");
        } else {
            System.out.println(order);
        }
    }

    @org.springframework.web.bind.annotation.RequestMapping(value = "/order2",
            method = RequestMethod.GET)
    void requestParam(@RequestParam("id") long id) {
        System.out.println("Requested param " + id);
    }

    @org.springframework.web.bind.annotation.RequestMapping(value = "/order3",
            method = RequestMethod.GET)
    void requestParamWithDefault(@RequestParam(defaultValue = "5") long id) {
        if (id == 5) {
            System.out.println("no param passed and default value = " + id);
        } else {
            System.out.println("Requested param " + id);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(RequestMapping.class, args);
    }
}
