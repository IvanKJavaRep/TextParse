package personal.ivan.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString(callSuper = true)
public class Paragraph extends Element implements IVisitable {
    private String name = "Paragraph";

    @Builder
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

    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
