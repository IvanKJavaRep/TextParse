package personal.ivan.domain;

import java.util.List;

public class TxtList extends Element{
    public List<String> lst;
    public TxtList(List<String> l, String content)
    {
        super(content);
        lst=l;
    }

    @Override
    public void printContent() {

    }
}
