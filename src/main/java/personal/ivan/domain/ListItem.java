package personal.ivan.domain;

import lombok.Data;

@Data
public class ListItem extends Element {
    private String name = "listItem";

    public ListItem(String text) {
        super(text);
    }

    @Override
    public void printContent() {

    }
}
