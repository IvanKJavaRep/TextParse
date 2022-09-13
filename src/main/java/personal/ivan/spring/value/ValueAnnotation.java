package personal.ivan.spring.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueAnnotation {
    private int a;
    private String b;
    private int a1;


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
        return a + " " + b + " " + a1;
    }
}
