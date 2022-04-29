package personal.ivan.domain;

import java.util.List;

public abstract class Text {
    String content;
    public abstract void printContent();
    public Text(String text)
    {
        content =text;
    }
}
