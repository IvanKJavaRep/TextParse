package personal.ivan.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class Literal extends Element {
    private String source;

    @Builder
    public Literal(String text, String cont) {
        super(text);
        source = cont;
    }

    @Override
    public void printContent() {

    }
}
