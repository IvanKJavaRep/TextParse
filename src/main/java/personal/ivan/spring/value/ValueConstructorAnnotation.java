package personal.ivan.spring.value;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueConstructorAnnotation {
    private int a;
    private String b;
    private int a1;

    public ValueConstructorAnnotation(@Value("8") int a, @Value("10") String b, @Value("97") int a1) {
        this.a = a;
        this.b = b;
        this.a1 = a1;
    }


    @Autowired
    public ValueConstructorAnnotation(@Value("99") int a) {
        this.a = a;
    }


    public String printProperties() {
        return a + " " + b + " " + a1;
    }
}
