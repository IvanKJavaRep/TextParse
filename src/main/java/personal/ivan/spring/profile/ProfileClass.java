package personal.ivan.spring.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import personal.ivan.domain.Document;

@Configuration
public class ProfileClass {
    @Profile("dev")
    @Bean(name = "d")
    Document getDocDev() {
        return new Document("dev");
    }

    @Profile("prod")
    @Bean(name = "d")
    Document getDocProd() {
        return new Document("prod");
    }
}
