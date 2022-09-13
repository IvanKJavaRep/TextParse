package personal.ivan.spring.getBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import personal.ivan.domain.Cell;
import personal.ivan.domain.Link;
import personal.ivan.domain.Paragraph;

@Configuration
public class GetBeanExamples {
    @Bean(name = {"par", "paragraph"})
    @Primary
    Paragraph getPar() {
        return new Paragraph("text");
    }

    @Bean(name = "link")
    Link getLink() {
        return new Link("link text");
    }

    @Bean(name = "cell")
    @Scope(value = "prototype")
    Cell getCell(String text) {
        return new Cell(text);
    }


}
