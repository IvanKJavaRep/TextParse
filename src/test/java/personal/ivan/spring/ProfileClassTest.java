package personal.ivan.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import personal.ivan.domain.Document;
import personal.ivan.spring.profile.ProfileClass;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ProfileClass.class}, loader = AnnotationConfigContextLoader.class)
public class ProfileClassTest {

    @Test
    void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("prod");
        context.register(ProfileClass.class);
        context.refresh();
        Document doc = context.getBean("d", Document.class);
        Assertions.assertEquals("prod", doc.getContent());
    }
}
