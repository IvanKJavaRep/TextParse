package personal.ivan.domain;

public abstract class Element {
    public String content;
    public abstract void printContent();
    public Element(String text)
    {
        content =text;
    }
}
