package personal.ivan.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import personal.ivan.domain.Cell;
import personal.ivan.domain.Element;
import personal.ivan.domain.Link;
import personal.ivan.domain.Paragraph;

@ComponentScan("personal.ivan.spring")
//use different methods of getting a certain bean
public class GetBeanExamplesTest {
    @Test
    void test() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(GetBeanExamplesTest.class);
        ctx.refresh();
        Element q = (Element) ctx.getBean("par");
        Assertions.assertEquals("text", q.getContent());
    }

    @Test
    void test1() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(GetBeanExamplesTest.class);
        ctx.refresh();
        Element q = (Element) ctx.getBean("link");
        Assertions.assertEquals("link text", q.getContent());
    }

    @Test
    void test2() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(GetBeanExamplesTest.class);
        ctx.refresh();
        Element q = (Element) ctx.getBean("paragraph");
        Assertions.assertEquals("text", q.getContent());
    }

    @Test
    void test3() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(GetBeanExamplesTest.class);
        ctx.refresh();
        Element q = (Element) ctx.getBean("paragraph", Paragraph.class);
        Assertions.assertEquals("text", q.getContent());
    }

    @Test
    void test4() {
        try {
            AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
            ctx.register(GetBeanExamplesTest.class);
            ctx.refresh();
            Element q = (Element) ctx.getBean("paragraph", Link.class);
            Assertions.assertEquals("text", q.getContent());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void test5() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(GetBeanExamplesTest.class);
        ctx.refresh();
        Element q = ctx.getBean(Paragraph.class);
        Assertions.assertEquals("text", q.getContent());
    }

    @Test
    void test6() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(GetBeanExamplesTest.class);
        ctx.refresh();
        //если бы я не добавил @Primary, то было бы исключение, так как два бина подходили бы
        Element q = ctx.getBean(Element.class);
        Assertions.assertEquals("text", q.getContent());
    }
    @Test
    void test7() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(GetBeanExamplesTest.class);
        ctx.refresh();
        Element q = (Element) ctx.getBean("cell","text");
        Assertions.assertEquals("text", q.getContent());
    }
    @Test
    void test8() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(GetBeanExamplesTest.class);
        ctx.refresh();
        Element cell = (Element) ctx.getBean("cell","text");
        Element cell2 = (Element) ctx.getBean("cell","text2");
        Assertions.assertEquals("text", cell.getContent());
        Assertions.assertEquals("text2", cell2.getContent());
    }
    @Test
    void test9() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(GetBeanExamplesTest.class);
        ctx.refresh();
        Element q = (Element) ctx.getBean(Cell.class,"text");
        Assertions.assertEquals("text", q.getContent());
    }
}
