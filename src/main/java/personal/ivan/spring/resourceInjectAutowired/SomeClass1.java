package personal.ivan.spring.resourceInjectAutowired;

import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@CustomFormatter.FormatterType("custom1")
@Component
public class SomeClass1 implements CustomFormatter.FormatterType {

    @Override
    public String value() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
