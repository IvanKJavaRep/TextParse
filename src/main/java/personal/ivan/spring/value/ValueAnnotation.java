package personal.ivan.spring.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Configuration
@PropertySource(value = {"file:C:\\Users\\i.haritonin\\MyProjects\\TextParse\\src\\main\\resources\\application.properties"})
public class ValueAnnotation {
    private int a;
    private String b;
    private int a1;
    @Value("${server.port}")
    private String port;


    /*@Value("${server.port}")
    public void setPortNumber(String port) {
        this.port = port;
    }*/


    @Value("101")
    public void setA(int value) {
        a = value;
    }

    @Value("some text")
    public void setB(String value) {
        b = value;
    }

    public void setA1(int value) {
        a1 = value;
    }

    public String printProperties() {
        return a + " " + b + " " + a1 + " " + port;
    }
}
