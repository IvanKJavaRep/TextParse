package personal.ivan.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Document extends Element {

    private List<Element> elements = new ArrayList<>();
    public Document(String text) {
        super(text);
    }

    @Override
    public void printContent() {

    }
}
