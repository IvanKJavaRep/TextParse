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
        //System.out.println(arr.size());
        lst1.remove(0);
        System.out.println("22222");
        System.out.println(lst1.size());
        TxtList lst = new TxtList(lst1);
        return lst;
    }
}
