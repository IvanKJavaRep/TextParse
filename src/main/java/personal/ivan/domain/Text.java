package personal.ivan.domain;

public abstract class Text {
    public String content;
    public abstract void printContent();
    public Text(String text)
    {
        content =text;
    }
}
