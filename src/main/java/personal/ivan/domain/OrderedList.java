package personal.ivan.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderedList extends Element {
    private List<String> lst = new ArrayList<>();

    public OrderedList(String text) {
        super(text);
    }

    @Override
    public void printContent() {

    }
}
