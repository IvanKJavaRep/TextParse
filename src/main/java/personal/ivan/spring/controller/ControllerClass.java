package personal.ivan.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//http://localhost:8080/hello ввести такое в браузер и будет напечатаная фраза из метода response
@Controller
public class ControllerClass {
    @RequestMapping("/hello")
    @ResponseBody
    public String response() {
        return "Hello";
    }
}
