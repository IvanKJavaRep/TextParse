package personal.ivan.domain;

import lombok.Data;

@Data
public class Link extends Element {
    private String name = "link";

    public Link(String text) {
        super(text);
    }

    @Override
    public void printContent() {

    }
}
