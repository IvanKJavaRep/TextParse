package personal.ivan.domain;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Paragraph extends Element {
    private String name = "Paragraph";

    public Paragraph(String text) {
        super(text);
    }

    @Override
    public void printContent() {
    }

    public TxtList searchForList() {
        List<String> lst1 = new ArrayList<>();
        String[] arr = getContent().split("\\d+\\.");
        for (var l : arr) {
            lst1.add(l);
        }
        lst1.remove(0);
        TxtList lst = new TxtList("List");
        return lst;
    }
}
