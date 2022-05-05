package personal.ivan.domain;

import java.util.ArrayList;
import java.util.List;

public class Paragraph extends Text{
    String name = "Paragraph";
    public Paragraph(String text) {
        super(text);
    }
    @Override
    public void printContent() {
    }
    public TxtList searchForList()
    {
        List<String> lst1= new ArrayList<>();
        String[] arr = content.split("\\d+\\.");
        for(var l :arr)
        {
            lst1.add(l);
        }
        lst1.remove(0);
        TxtList lst = new TxtList(lst1);
        return lst;
    }
}
