package personal.ivan.domain;

import java.util.ArrayList;
import java.util.List;

public class OrderedList extends Element{
    public List<String> lst = new ArrayList<>();
    public OrderedList(String text) {
        super(text);
    }

    @Override
    public void printContent() {

    }
}
