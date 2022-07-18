package personal.ivan.domain;

import lombok.Data;

@Data
public class Cell extends Element {
    public Cell(String text) {
        super(text);
    }

    @Override
    public void printContent() {

    }

}
