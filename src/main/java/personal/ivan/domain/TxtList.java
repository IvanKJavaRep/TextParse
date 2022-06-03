package personal.ivan.domain;

import java.util.List;

public class TxtList extends Element{
    public List<String> lst;
    public TxtList(String content)
    {
        super(content);
    }

    @Override
    public void printContent() {

    }
}
