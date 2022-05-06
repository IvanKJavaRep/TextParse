package personal.ivan.domain;

import java.util.ArrayList;
import java.util.List;

public class Document extends Element {

    public List<Element> elements = new ArrayList<>();
    public Document(String text) {
        super(text);
    }

    @Override
    public void printContent() {

    }
}
