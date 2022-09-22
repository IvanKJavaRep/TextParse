package personal.ivan.spring.defaultValues;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource( value = {"file:C:\\Users\\i.haritonin\\MyProjects\\TextParse\\src\\main\\java\\personal\\ivan\\spring\\defaultValues\\someProperties.properties"})
public class DefaultValues {
    @Value("${some.key: text}")
    private String text;
    @Value("${some.key: 42}")
    private int a;
    @Value("${some.key: 1,2,3}")
    private int[] arr = new int[3];
    @Value("${some.key: true}")
    private boolean bool;
    //создал файл с ресурсами. Пока там лежит валидное значение, будет подставляться оттуда.
    //Если нет, то дефолтное значение.
    @Value("${list1:my default value for spell}")
    private String spellString;

    public String printProperties() {
        String result = "";
        for (var a : arr
        ) {
            result = result + a + " ";
        }
        result = result + text + " " + a + " " + bool + " " + spellString;
        return result;
    }
}
