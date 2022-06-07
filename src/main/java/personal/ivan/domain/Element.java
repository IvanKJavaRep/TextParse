package personal.ivan.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Element {
    public String content;
    public abstract void printContent();
    public List<Element> children = new ArrayList<>();
    public java.util.Map<String, Object> properties = new HashMap<>();
    public Element(String text)
    {
        content =text;
    }
    public void addChild(Element el) {
        children.add(el);
    }
}
