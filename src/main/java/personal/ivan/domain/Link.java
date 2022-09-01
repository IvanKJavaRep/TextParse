package personal.ivan.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Link extends Element implements IVisitable {
    private String name = "link";

    @Builder
    public Link(String text) {
        super(text);
    }

    @Override
    public void printContent() {

    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
