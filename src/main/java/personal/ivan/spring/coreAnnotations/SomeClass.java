package personal.ivan.spring.coreAnnotations;

import org.springframework.beans.factory.annotation.Required;

public class SomeClass {
    Integer a;
    String b;

    @Required
    public void setA(Integer value) {
        a = value;
    }

    @Required
    public void setB(String value) {
        b = value;
    }
}
