package personal.ivan.domain;

import lombok.Data;

@Data
public class Section extends Element {
    public Section(String text) {
        super(text);
    }

    @Override
    public void printContent() {

    }
}
