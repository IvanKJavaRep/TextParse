package personal.ivan.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Link extends Element{
    private String name="link";
    public Link(String text) {
        super(text);
    }

    @Override
    public void printContent() {

    }
}
