package personal.ivan.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Data
@ToString(callSuper = true)
public class Document extends Element {

    private List<Element> elements = new ArrayList<>();

    @Builder
    public Document(String text) {
        super(text);
    }

    @Override
    public void printContent() {

    }
}









