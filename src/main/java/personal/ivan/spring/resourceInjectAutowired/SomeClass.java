package personal.ivan.spring.resourceInjectAutowired;

import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@CustomFormatter.FormatterType("custom")
@Component
public class SomeClass implements CustomFormatter.FormatterType {

    @Override
    public String value() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}

