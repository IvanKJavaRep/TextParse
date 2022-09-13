package personal.ivan.spring.prop;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(name = "x", value = {"file:C:\\Users\\i.haritonin\\MyProjects\\TextParse\\src\\main\\java\\personal\\ivan\\spring\\prop\\someInfo.properties"})
public class PropertySourceClass {
    public static String main() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        try {
            ctx.register(PropertySourceClass.class);
            ctx.refresh();
            Environment env = ctx.getEnvironment();
            return env.getProperty("prop1");
        } finally {
            ctx.close();
        }
    }
}
