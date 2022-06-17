package personal.ivan.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Literal extends Element {
    private String source;

    public Literal(String text, String cont) {
        super(text);
        source = cont;
    }

    @Override
    public void printContent() {

    }
}
