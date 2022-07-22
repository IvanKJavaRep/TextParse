package personal.ivan.domain;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;


@Data
@ToString(callSuper = true)
@SuperBuilder
public class Document extends Element implements IChain {
    private IChain chain;

    private List<Element> elements = new ArrayList<>();


    public Document(String text) {
        super(text);
    }

    @Override
    public void printContent() {

    }

    @Override
    public void setNextChain(IChain chain) {
        this.chain = chain;

    }

    @Override
    public void handle(Element element) {
        if (element.getChildren().size() > 3) {
            System.out.println(">3 children");
        } else {
            System.out.println("task is transferred to another chain");
            chain.handle(element);
        }
    }
}









