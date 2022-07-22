package personal.ivan.domain;

import lombok.Data;
import org.junit.jupiter.api.Test;
@Data
public class chainPatternTest {

    private IChain d;
    private int f =5;
    @Test
    void test() {
        IChain document = new Document("d");
        IChain orderedList = new OrderedList("o");
        document.setNextChain(orderedList);
        document.handle(new Document("doc"));
        chainPatternTest c = new chainPatternTest();
        /*IChain gg = c.d;
        int dd = c.f;*/

    }


}
