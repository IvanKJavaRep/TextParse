package personal.ivan.spring.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceClass {
    public int countSomething(int param) {
        return param * 5;
    }
}
