package personal.ivan.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderedList extends Element implements IChain {
    private IChain chain;
    private List<String> lst = new ArrayList<>();

    public OrderedList(String text) {
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
        if (element.getChildren().size() <= 3 && element.getChildren().size() > 1) {
            System.out.println("less than 3 children");
        } else {
            System.out.println("the end");
        }
    }
}
