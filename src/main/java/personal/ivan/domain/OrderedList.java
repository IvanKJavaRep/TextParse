package personal.ivan.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderedList extends Element{
    private List<String> lst = new ArrayList<>();
    public OrderedList(String text) {
        super(text);
    }

    @Override
    public void printContent() {

    }
}
