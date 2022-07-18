package personal.ivan.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Link extends Element {
    private String name = "link";

    @Builder
    public Link(String text) {
        super(text);
    }

    @Override
    public void printContent() {

    }
}
