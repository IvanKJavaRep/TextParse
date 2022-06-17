package personal.ivan.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListItem extends Element{
    private String name = "listItem";
    public ListItem(String text) {
        super(text);
    }

    @Override
    public void printContent() {

    }
}
